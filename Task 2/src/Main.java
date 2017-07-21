/**
 * Created by Roman on 20.07.2017.
 */
public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model,view);
        // Work method
        controller.processUser();
    }
}
