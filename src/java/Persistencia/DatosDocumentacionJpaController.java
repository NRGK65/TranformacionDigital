
package Persistencia;

import Logica.DatosDocumentacion;
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
public class DatosDocumentacionJpaController implements Serializable {

    public DatosDocumentacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public DatosDocumentacionJpaController () {
        emf = Persistence.createEntityManagerFactory("RegistroWeb_PU");
    
    }
    
        

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DatosDocumentacion datosDocumentacion) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(datosDocumentacion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDatosDocumentacion(datosDocumentacion.getIdDocume()) != null) {
                throw new PreexistingEntityException("DatosDocumentacion " + datosDocumentacion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DatosDocumentacion datosDocumentacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            datosDocumentacion = em.merge(datosDocumentacion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = datosDocumentacion.getIdDocume();
                if (findDatosDocumentacion(id) == null) {
                    throw new NonexistentEntityException("The datosDocumentacion with id " + id + " no longer exists.");
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
            DatosDocumentacion datosDocumentacion;
            try {
                datosDocumentacion = em.getReference(DatosDocumentacion.class, id);
                datosDocumentacion.getIdDocume();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The datosDocumentacion with id " + id + " no longer exists.", enfe);
            }
            em.remove(datosDocumentacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DatosDocumentacion> findDatosDocumentacionEntities() {
        return findDatosDocumentacionEntities(true, -1, -1);
    }

    public List<DatosDocumentacion> findDatosDocumentacionEntities(int maxResults, int firstResult) {
        return findDatosDocumentacionEntities(false, maxResults, firstResult);
    }

    private List<DatosDocumentacion> findDatosDocumentacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DatosDocumentacion.class));
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

    public DatosDocumentacion findDatosDocumentacion(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DatosDocumentacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getDatosDocumentacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DatosDocumentacion> rt = cq.from(DatosDocumentacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Number) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
