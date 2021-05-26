package pl.sda.mymovies_sql;

import pl.sda.repository.MovieJsonRepo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyMovies {

    public static final String MYMOVIES = "mymovies";

    public MovieJsonRepo getfactory() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(MYMOVIES);
        MovieJsonRepo movieJsonRepo = new MovieJsonRepo(factory);
        return movieJsonRepo;
    }


    // static EntityManagerFactory factory = Persistence.createEntityManagerFactory(MYMOVIES);
    //    static MovieJsonRepo movieJsonRepo = new MovieJsonRepo(factory);

//    static private void addArticle(){
//        scanner.nextLine();
//        System.out.println("Wpisz tytuł:");
//        String title = scanner.nextLine();
//        System.out.println("Wpisz autora:");
//        String author = scanner.nextLine();
//        Article article = new Article(0, author, title, "XXX", null, 0);
//        //articleRepo.save(article);
//        articleRepo.merge(article);
//    }

}
