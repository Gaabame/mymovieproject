package pl.sda.repositoryBase;

import pl.sda.entity.MovieJson;
import java.util.Optional;

public interface MovieJsonRepo{
    Optional<MovieJson> findByTitle(String title);
    Optional<MovieJson> findById(Long id);
}
