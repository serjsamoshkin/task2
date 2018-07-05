package view;

/**
 * Contains variants of output to the user
 */
public enum MessStack {

    GREETING("Давай сыграем в игру? Я загадаю число в диапазоне от %s до %s, а ты будешь отгадывать. \n" +
            "Я так же буду тебе подсказывать: если введенное тобой число больше или меньше загадоного - \n" +
            "появится соответствующее сообщение."),
    GOOD_BYE("Вы отгадали число за %s попыток:"),
    NEXT_MOVE("Введите число:"),
    FORMAT_INCORRECT("Введено не число, повторите попытку."),
    GAME_MODE_QUESTION("Включить подсказки? 1 - да, 2 - нет."),
    OUT_OF_MIN_DIAPASON("Вы ввели недопустимое число: число меньше нижней границы %s"),
    INPUT_VALUE_LESS("Введенное число меньше загаданного"),
    INPUT_VALUE_GREATER("Введенное больше загаданного"),
    OUT_OF_MAX_DIAPASON("Вы ввели недопустимое число: число больше верхней границы %s"),
    WIN("Вы справились с заданием, поздравляю!"),
    CURRENT_DIAPASON("Текущий диапазон c %s по %s");

    private String message;

    MessStack(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
