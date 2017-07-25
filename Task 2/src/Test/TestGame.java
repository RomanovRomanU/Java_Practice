package Test;
/**
 * Created by Roman on 25.07.2017.
 */
import org.junit.Test;
import Game.Controller;
import Game.View;
import Game.Model;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
public class TestGame {
    Model model = new Model();
    View view = new View();
    Controller controller = new Controller(model,view);
    @Test
    public void testWronginput() {
        model.gameStart();
        // Check number input out of boundaries
        assertEquals("Out if boundaries",controller.verifyInput("1234"),false);
    }
    @Test
    public void testBoundariesCorrectEdition() {
        model.gameStart();
        controller.gameTry(50);
        int gameMinNumberOld = controller.gameMinNumber;
        int gameMaxNumberOld = controller.gameMaxNumber;
        // Now let`s give input out of boundaries
        controller.gameTry(gameMinNumberOld - 1);
        controller.gameTry(gameMaxNumberOld + 1);
        assertEquals("Min numbers:",gameMinNumberOld,controller.gameMinNumber);
        assertEquals("Msx numbers",gameMaxNumberOld,controller.gameMaxNumber);
    }
}
