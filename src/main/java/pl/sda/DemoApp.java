package pl.sda;
import pl.sda.controller.QueryController;

public class DemoApp {

    public static void main(String[] args) {
        QueryController queryController = new QueryController();
        queryController.start();
    }
}
