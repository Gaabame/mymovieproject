package pl.sda.repositoryBase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import java.util.List;
import java.util.Optional;

public class JpaRepository<T, K> implements Repository<T, K> {

    private final Class<T> entityClass;
    private final EntityManagerFactory factory;

    public JpaRepository(EntityManagerFactory factory, Class<T> entityClass) {
        this.factory = factory;
        this.entityClass = entityClass;
    }

    private EntityManager manager(){
        return factory.createEntityManager();
    }

    @Override
    public void save(T entity) throws PersistenceException {
        EntityManager em = manager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }
    @Override
    public void deleteById(K id) {
        EntityManager em = manager();
        em.getTransaction().begin();
        T obj = em.find(entityClass, id);
        if (obj != null) {
            em.remove(obj);
        }
        em.getTransaction().commit();
    }
    @Override
    public void delete(Optional<T> entity) {
        EntityManager em = manager();
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    @Override
    public List<T> findAll() {
        EntityManager em = manager();
        return em.createQuery("select a from " + entityClass.getSimpleName() +" a", entityClass).getResultList();
    }
}