package pl.sda.repository;


import pl.sda.entity.MovieJson;
import pl.sda.repository.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


public class MovieJsonRepo implements Repository {

    private final EntityManagerFactory factory;

    public MovieJsonRepo(EntityManagerFactory factory) {
        this.factory = factory;
    }

    private EntityManager manager(){
        return factory.createEntityManager();
    }

    @Override
    public void save(Object entity) {
        EntityManager em = manager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
        }

    @Override
    public Object merge(Object entity) {
        return null;
    }

    @Override
    public Object findById(Object id) {
        EntityManager em = manager();
        MovieJson movieJson = em.find(MovieJson.class, id);
        em.close();
        return movieJson;
    }

    @Override
    public void deleteById(Object id) {
        EntityManager em = manager();
        em.getTransaction().begin();
        MovieJson movieJson = em.find(MovieJson.class, id);
        if (movieJson == null){
            return;
        }
        em.remove(movieJson);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Object entity) {
        EntityManager em = manager();
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<MovieJson> findAll() {
        EntityManager em = manager();
        List<MovieJson> movieJsons = em.createQuery("select m from MovieJson m", MovieJson.class).getResultList();
        em.close();
        return movieJsons;
    }

}
