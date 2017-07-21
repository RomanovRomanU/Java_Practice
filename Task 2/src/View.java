import sun.plugin2.message.Message;

/**
 * Created by Roman on 21.07.2017.
 */
public class View {
    String GAME_START = "We made a number in range [0,100].Try to guess it!";
    String WRONG_INPUT = "You must input int!Try again.";
    String NOT_GUESSED_NUMBER = "You didn`t guess it. Try again!";
    String GAME_WIN = "You guessed number! Congratulations!";
    public void printTargetNumberRange(int min,int max) {
        String range = Integer.toString(min) + " and " + Integer.toString(max);
        System.out.println("Target number between:"+range);
    }
    public void printMessage(String message) {
        System.out.println(message);
    }
}
