import ua.tests.task2.controller.InputController;
import ua.tests.task2.controller.MainController;
import ua.tests.task2.model.Game;
import ua.tests.task2.view.ConsoleView;

public class Main {

    public static void main(String[] args) {

        new Game();


        MainController controller = new MainController(
                new InputController(),
                new ConsoleView());

        controller.Start();

    }
}
