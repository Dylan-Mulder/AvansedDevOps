package domain.states.backlog_item;

import domain.BacklogItem;
import domain.Task;

import java.util.ArrayList;
import java.util.logging.Level;

public class ReadyForTestingState extends AbstractBacklogItemState {
    public ReadyForTestingState() {
        // Only create the Object
    }

    public void changeName(BacklogItem backlogItem, String name) {
        logger.log(Level.WARNING, "Can't change name while in state: Ready For Testing");
    }

    public void changeDescription(BacklogItem backlogItem, String description) {
        logger.log(Level.WARNING, "Can't change description while in state: Ready For Testing");
    }

    public void changeTasksAdd(BacklogItem backlogItem, Task task) {
        logger.log(Level.WARNING, "Can't add tasks now while in state: Ready For Testing");
    }

    public void changeTasksRemove(BacklogItem backlogItem, Task task) {
        logger.log(Level.WARNING, "Can't remove tasks now while in state: Ready For Testing");
    }

    public void moveForward(BacklogItem backlogItem) {
        logger.log(Level.INFO, String.format("Moved %s to: Testing", backlogItem.getName()));
        backlogItem.setDevelopersToNotify(new ArrayList<>());
        backlogItem.setState(new TestingState());
    }

    public void moveBackward(BacklogItem backlogItem) {
        logger.log(Level.WARNING, "Can't move backwards now!");
    }
}
