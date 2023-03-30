import domain.BacklogItem;
import domain.Sprint;
import domain.strategies.sprint.FinishRelease;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        BacklogItem bi = new BacklogItem("Title", "Bla bla");
        BacklogItem bi2 = new BacklogItem("augh", "Bla bla");
        //bi.moveBackward();
        //bi.moveForward();

        Sprint s = new Sprint();
        s.setFinishBehaviour(new FinishRelease());
        s.addBacklogItem(bi2);
        System.out.println(s.getBacklogItems().get(0).getName());
        s.start();
        s.performFinish();
    }
}
