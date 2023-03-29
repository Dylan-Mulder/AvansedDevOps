import domain.BacklogItem;
import domain.Developer;
import domain.Task;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        BacklogItem bi = new BacklogItem("Title", "Bla bla");
        bi.moveBackward();
        bi.moveForward();
    }
}
