package pl.sda.repository;

import javax.persistence.EntityManager;
import java.util.List;

public class MovieRepository implements Repository{

    private final EntityManager entityManager;

    public MovieRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Object entity) {

    }

    @Override
    public Object merge(Object entity) {
        return null;
    }

    @Override
    public Object findById(Object id) {
        return null;
    }

    @Override
    public void deleteById(Object id) {

    }

    @Override
    public void delete(Object entity) {

    }

    @Override
    public List findAll() {
        return null;
    }
}