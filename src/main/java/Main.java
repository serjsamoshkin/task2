import controller.InputController;
import controller.MainController;
import model.Game;
import view.ConsoleView;

public class Main {

    public static void main(String[] args) {

        new Game();


        MainController controller = new MainController(
                new InputController(),
                new ConsoleView());

        controller.Start();

    }
}
