package pl.sda;
import pl.sda.controller.QueryController;
import pl.sda.service.AppServiceJpa;
import pl.sda.service.MyBaseServiceJpa;

public class DemoApp {

    public static void main(String[] args) {

        MyBaseServiceJpa myBaseService = new MyBaseServiceJpa();
        AppServiceJpa appServiceJpa = new AppServiceJpa();

        QueryController controller = new QueryController(appServiceJpa, myBaseService);
        controller.start();
    }
}
