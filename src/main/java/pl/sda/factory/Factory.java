package pl.sda.factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Factory {

    public static final String MYMOVIES = "mymovies";

    public EntityManagerFactory getfactory() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(MYMOVIES);
        return factory;
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
