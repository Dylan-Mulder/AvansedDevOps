package domain.states.backlogItem;

import domain.BacklogItem;
import domain.Task;

import java.util.logging.Level;

public class DoingState extends AbstractBacklogItemState {
    /* ATTRIBUTES */


    /* CONSTRUCTORS */
    public DoingState() {
    }

    /* GETTERS */


    /* SETTERS */


    /* METHODS */
    public void changeName(BacklogItem backlogItem, String name) {
        logger.log(Level.WARNING, "Can't change name!");
    }

    public void changeDescription(BacklogItem backlogItem, String description) {
        logger.log(Level.WARNING, "Can't change description!");
    }

    public void changeTasksAdd(BacklogItem backlogItem, Task task) {
        logger.log(Level.WARNING, "Can't add tasks now!");
    }

    public void changeTasksRemove(BacklogItem backlogItem, Task task) {
        logger.log(Level.WARNING, "Can't remove tasks now!");
    }

    public void moveForward(BacklogItem backlogItem) {
        logger.log(Level.INFO, "Moved " + backlogItem.getName() + " to: Ready For Testing");
        backlogItem.setState(new ReadyForTestingState());
    }

    public void moveBackward(BacklogItem backlogItem) {
        logger.log(Level.WARNING, "Can't move backwards now!");
    }
}
