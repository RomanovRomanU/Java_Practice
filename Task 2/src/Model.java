/**
 * Created by Roman on 21.07.2017.
 */
import java.util.Random;

public class Model {
    // Game variables
    int GAME_MIN = 0;
    int GAME_MAX = 100;
    int gameTargetNumber;
    // Indicator of player`s win
    private boolean gameWin = false;

    Random generator = new Random();
    // Bounds are included
    public int randomIntGenerating(int min, int max) {
        if (min>=max) {
            throw new IllegalArgumentException("min must be less then max");
        }
        if (min < 0 || max <=0) {
            throw new IllegalArgumentException("max must be positive,min must be non-negative");
        }
        return generator.nextInt(max - min - 1) + min;
    }
    // Max is included in range
    public int randomIntGenerating(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("max must be positive number!");
        }
        return generator.nextInt(max+1);
    }
    // Work method
    public void gameStart() {
        this.gameTargetNumber = randomIntGenerating(GAME_MIN,GAME_MAX);
    }
    // Work method
    public String gameTry(int number) {
        if (number == this.gameTargetNumber) {
            gameWin = true;
            return "equal";
        }
        if (number > this.gameTargetNumber) {
            return "greater";
        }
        if (number < this.gameTargetNumber) {
            return "less";
        }
        // Compiler don`t see return in if
        // Crutch
        return "";
    }
    public boolean isGameWin() {
        return gameWin;
    }
}
