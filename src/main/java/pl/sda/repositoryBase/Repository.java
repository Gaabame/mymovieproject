package pl.sda.repositoryBase;

import java.util.List;
import java.util.Optional;

public interface Repository<T, K> {
    void save(T entity);
    void deleteById(K id);
    void delete(Optional<T> entity);
    List<T> findAll();
}


