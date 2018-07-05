package view;

/**
 *  Contains output methods to interact with the user.
 *  Uses console for output.
 */
public class ConsoleView {

    public void display(MessStack messStack, ConsolOutputColor color){
        display(messStack.getMessage(), color);
    }

    public void display(MessStack messStack, ConsolOutputColor color, String... params){
        display(String.format(messStack.getMessage(), params), color);
    }

    public void display(MessStack messStack){
        display(messStack.getMessage());
    }

    public void display(MessStack messStack, String... params){
        display(String.format(messStack.getMessage(), params));
    }

    public void display(String message, ConsolOutputColor color){
        display(color + message);
    }

    public void display(String message, ConsolOutputColor color, String... params){
        display(color + String.format(message, params));
    }

    public void display(String message){
        System.out.println( message);
    }

    public void display(String message, String... params){
        System.out.println(String.format(message, params));
    }

}
