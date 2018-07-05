package controller;

import model.CheckValueStatus;
import model.Game;
import model.GameIsEndException;
import model.GameMode;
import view.ConsolOutputColor;
import view.ConsoleView;
import view.MessStack;

/**
 * Main [task1] Controller
 */
public class MainController {

    private InputController input;
    private ConsoleView view;

    public MainController(InputController input, ConsoleView view) {
        this.input = input;
        this.view = view;
    }

    public void Start(){

        view.display(MessStack.GREETING);

        Game game = new Game();

        CheckValueStatus status = null;

        view.display(MessStack.GAME_MODE_QUESTION);
        int mode = 0;
        while (true){
            String value =input.getInput();
            if (!value.matches("^[12]$")){
                view.display(MessStack.FORMAT_INCORRECT);
                continue;
            }
            mode = Integer.valueOf(value);
            break;

        }

        switch (mode){
            case 1:
                game.setMode(GameMode.LIGHT);
                break;
            case 2:
                game.setMode(GameMode.HARD);
                break;
        }

        view.display(MessStack.NEXT_MOVE);

        int n = 0;
        for (n = 0; status != CheckValueStatus.WIN ; n++) {


            String value =input.getInput();
            if (!value.matches("^\\d+$")){
                view.display(MessStack.FORMAT_INCORRECT);
                continue;
            }

            try {
                status = game.addNextValue(Integer.valueOf(value));
            }
            catch (GameIsEndException e){
                // nothing to do
            }

            switch (status){
                case INPUT_VALUE_LESS:
                case INPUT_VALUE_GREATER:
                    if (game.getMode() == GameMode.LIGHT) {
                        view.display(MessStack.CURRENT_DIAPASON,
                                Integer.toString(game.getMinDiapason()),
                                Integer.toString(game.getMaxDiapason()));
                    }
                    view.display(MessStack.NEXT_MOVE);
                    break;
                case OUT_OF_MIN_DIAPASON:
                    view.display(MessStack.valueOf(status.name()),
                            Integer.toString(game.getMinDiapason()));
                    break;
                case OUT_OF_MAX_DIAPASON:
                    view.display(MessStack.valueOf(status.name()),
                            Integer.toString(game.getMaxDiapason()));
                    break;
                case WIN:
                    view.display(MessStack.valueOf(status.name()));
                    break;
            }

        }


        view.display(MessStack.GOOD_BYE, Integer.toString(n));

        int i = 0;
        for (Integer key :
                game.getMoves()) {
            if (++i == game.getMoves().size()){
                view.display(Integer.toString(key), ConsolOutputColor.ANSI_RED);
            }else {
                view.display(Integer.toString(key));
            }

        }


    }
}
