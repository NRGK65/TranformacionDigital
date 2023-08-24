
package Persistencia;

import Logica.DatosFormulario;
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
public class DatosFormularioJpaController implements Serializable {

    public DatosFormularioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public DatosFormularioJpaController () {
        emf = Persistence.createEntityManagerFactory("RegistroWeb_PU");
    
    }
          

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DatosFormulario datosFormulario) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(datosFormulario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDatosFormulario(datosFormulario.getIdTipoForm()) != null) {
                throw new PreexistingEntityException("DatosFormulario " + datosFormulario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DatosFormulario datosFormulario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            datosFormulario = em.merge(datosFormulario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = datosFormulario.getIdTipoForm();
                if (findDatosFormulario(id) == null) {
                    throw new NonexistentEntityException("The datosFormulario with id " + id + " no longer exists.");
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
            DatosFormulario datosFormulario;
            try {
                datosFormulario = em.getReference(DatosFormulario.class, id);
                datosFormulario.getIdTipoForm();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The datosFormulario with id " + id + " no longer exists.", enfe);
            }
            em.remove(datosFormulario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DatosFormulario> findDatosFormularioEntities() {
        return findDatosFormularioEntities(true, -1, -1);
    }

    public List<DatosFormulario> findDatosFormularioEntities(int maxResults, int firstResult) {
        return findDatosFormularioEntities(false, maxResults, firstResult);
    }

    private List<DatosFormulario> findDatosFormularioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DatosFormulario.class));
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

    public DatosFormulario findDatosFormulario(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DatosFormulario.class, id);
        } finally {
            em.close();
        }
    }

    public int getDatosFormularioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DatosFormulario> rt = cq.from(DatosFormulario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Number) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
