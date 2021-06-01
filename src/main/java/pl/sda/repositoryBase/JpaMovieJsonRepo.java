package pl.sda.repositoryBase;
import pl.sda.entity.MovieJson;
import javax.persistence.EntityManagerFactory;
import java.util.Optional;


public class JpaMovieJsonRepo extends JpaRepository<MovieJson, Long> implements MovieJsonRepo {

    public JpaMovieJsonRepo(EntityManagerFactory factory, Class<MovieJson> entityClass) {
        super(factory, entityClass);
    }

    @Override
    public Optional<MovieJson> findByTitle(String title) {
        Optional<MovieJson> result = findAll().stream()
                .filter(movieJson -> movieJson.getTitle().equals(title))
                .findAny();
        if (result.isEmpty()) {
            System.out.println("Nie odnaleziono filmu o podanym tytule w bazie");
        }
        return result;
    }

    @Override
    public Optional<MovieJson> findById(Long id) {
        Optional<MovieJson> result = findAll().stream()
                .filter(movieJson -> movieJson.getId() == id)
                .findAny();
        if (result.isEmpty()) {
            System.out.println("Nie odnaleziono filmu o podanym tytule w bazie");
        }
        return result;
    }
}


