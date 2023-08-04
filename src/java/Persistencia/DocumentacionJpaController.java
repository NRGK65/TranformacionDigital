
package Persistencia;

import Logica.Documentacion;
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
public class DocumentacionJpaController implements Serializable {

    public DocumentacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public DocumentacionJpaController () {
        emf = Persistence.createEntityManagerFactory("RegistroWeb_PU");
    
    }
    
        

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Documentacion documentacion) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(documentacion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDocumentacion(documentacion.getIdDocume()) != null) {
                throw new PreexistingEntityException("Documentacion " + documentacion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Documentacion documentacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            documentacion = em.merge(documentacion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = documentacion.getIdDocume();
                if (findDocumentacion(id) == null) {
                    throw new NonexistentEntityException("The documentacion with id " + id + " no longer exists.");
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
            Documentacion documentacion;
            try {
                documentacion = em.getReference(Documentacion.class, id);
                documentacion.getIdDocume();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The documentacion with id " + id + " no longer exists.", enfe);
            }
            em.remove(documentacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Documentacion> findDocumentacionEntities() {
        return findDocumentacionEntities(true, -1, -1);
    }

    public List<Documentacion> findDocumentacionEntities(int maxResults, int firstResult) {
        return findDocumentacionEntities(false, maxResults, firstResult);
    }

    private List<Documentacion> findDocumentacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Documentacion.class));
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

    public Documentacion findDocumentacion(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Documentacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getDocumentacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Documentacion> rt = cq.from(Documentacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Number) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
