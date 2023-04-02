package domain.states.backlogItem;

import domain.BacklogItem;
import domain.Task;

import java.util.logging.Level;

public class DoneState extends AbstractBacklogItemState {
    /* ATTRIBUTES */


    /* CONSTRUCTORS */
    public DoneState() {
    }

    /* GETTERS */


    /* SETTERS */


    /* METHODS */
    public void changeName(BacklogItem backlogItem, String name) {
        logger.log(Level.WARNING, "Can't change name while in state: Done");
    }

    public void changeDescription(BacklogItem backlogItem, String description) {
        logger.log(Level.WARNING, "Can't change description while in state: Done");
    }

    public void changeTasksAdd(BacklogItem backlogItem, Task task) {
        logger.log(Level.WARNING, "Can't add tasks now while in state: Done");
    }

    public void changeTasksRemove(BacklogItem backlogItem, Task task) {
        logger.log(Level.WARNING, "Can't remove tasks now while in state: Done");
    }

    public void moveForward(BacklogItem backlogItem) {
        logger.log(Level.WARNING, "Can't move forwards!");
    }

    public void moveBackward(BacklogItem backlogItem) {
        logger.log(Level.WARNING, "Can't move backwards!");
    }
}
