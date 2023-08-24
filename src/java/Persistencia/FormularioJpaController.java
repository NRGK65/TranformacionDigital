
package Persistencia;

import Logica.Formulario;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Nestor
 */
public class FormularioJpaController implements Serializable {

    public FormularioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public FormularioJpaController () {
        emf = Persistence.createEntityManagerFactory("RegistroWeb_PU");
    
    }

    
        public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Formulario formulario) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(formulario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFormulario(formulario.getIdTipoForm()) != null) {
                throw new PreexistingEntityException("Formulario " + formulario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Formulario formulario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            formulario = em.merge(formulario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = formulario.getIdTipoForm();
                if (findFormulario(id) == null) {
                    throw new NonexistentEntityException("The formulario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Formulario formulario;
            try {
                formulario = em.getReference(Formulario.class, id);
                formulario.getIdTipoForm();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The formulario with id " + id + " no longer exists.", enfe);
            }
            em.remove(formulario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Formulario> findFormularioEntities() {
        return findFormularioEntities(true, -1, -1);
    }

    public List<Formulario> findFormularioEntities(int maxResults, int firstResult) {
        return findFormularioEntities(false, maxResults, firstResult);
    }

    private List<Formulario> findFormularioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Formulario.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Formulario findFormulario(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Formulario.class, id);
        } finally {
            em.close();
        }
    }

    public int getFormularioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Formulario> rt = cq.from(Formulario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Number) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
