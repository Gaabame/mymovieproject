package pl.sda;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pl.sda.controller.QueryController;
import pl.sda.service.AppServiceJpa;
import pl.sda.service.MyBaseService;
import pl.sda.service.MyBaseServiceJpa;

public class DemoApp {

    public static void main(String[] args) {

        MyBaseServiceJpa myBaseService = new MyBaseServiceJpa();
        AppServiceJpa appServiceJpa = new AppServiceJpa();

        QueryController controller = new QueryController(appServiceJpa, myBaseService);
        controller.start();
    }

//    public class SpringDemoApplication implements CommandLineRunner {
//
//        private final QuizController controller;
//
//        public SpringDemoApplication(QuizService quizService) {
//            controller = new QuizController(quizService);
//        }
//
//        public static void main(String[] args) {
//            SpringApplication.run(SpringDemoApplication.class, args);
//        }
//
//        @Override
//        public void run(String... args) throws Exception {
//            controller.start();
//
}
