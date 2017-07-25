package Game; /**
 * Created by Roman on 20.07.2017.
 */
import java.util.Scanner;
public class Controller {
    // Constructor
    Model model;
    View view;
    // Game initial range
    public int gameMinNumber = 0;
    public int gameMaxNumber = 100;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.gameMinNumber = gameMinNumber;
        this.gameMaxNumber = gameMaxNumber;
    }
    private String userStirngInput() {
        Scanner sc = new Scanner(System.in);

        while(!sc.hasNextInt()) {
            view.printMessage(view.WRONG_INPUT);
            sc.next();
        }
        return sc.next();
    }
    public boolean verifyInput(String input) {
        try {
            int intInput = Integer.parseInt(input);
            if (intInput >= gameMinNumber && intInput <= gameMaxNumber) {
                return true;
            }
            else{
                return false;
            }
        }
        catch(NumberFormatException error){
            view.printMessage(view.WRONG_INPUT);
        }
        return false;
    }
    public void gameTry(int intInput) {
        String result = model.gameTry(intInput);
        if (result.equals("equal")) {
            view.printMessage(view.GAME_WIN);
        }
        if (result.equals("greater")) {
            gameMaxNumber = intInput - 1;
            view.printMessage(view.NOT_GUESSED_NUMBER);
            view.printTargetNumberRange(gameMinNumber,gameMaxNumber);
        }
        if (result.equals("less")) {
            gameMinNumber = intInput + 1;
            view.printMessage(view.NOT_GUESSED_NUMBER);
            view.printTargetNumberRange(gameMinNumber,gameMaxNumber);
        }
    }
    // Work method
    public void processUser() {
        model.gameStart();
        view.printMessage(view.GAME_START);
        while (!model.isGameWin()) {
            String input = userStirngInput();
            if (verifyInput(input)) {
                int intInput = Integer.parseInt(input);
                gameTry(intInput);
            }
            else {
                view.printMessage(view.WRONG_INPUT);
                view.printTargetNumberRange(gameMinNumber,gameMaxNumber);
                continue;
            }
        }
    }
}
