package domain.states.backlog_item;

import domain.BacklogItem;
import domain.Task;

import java.util.logging.Level;

public class TestingState extends AbstractBacklogItemState {
    /* ATTRIBUTES */


    /* CONSTRUCTORS */
    public TestingState() {
        // Only create the Object
    }

    /* GETTERS */


    /* SETTERS */


    /* METHODS */
    public void changeName(BacklogItem backlogItem, String name) {
        logger.log(Level.WARNING, "Can't change name while in state: Testing");
    }

    public void changeDescription(BacklogItem backlogItem, String description) {
        logger.log(Level.WARNING, "Can't change description while in state: Testing");
    }

    public void changeTasksAdd(BacklogItem backlogItem, Task task) {
        logger.log(Level.WARNING, "Can't add tasks now while in state: Testing");
    }

    public void changeTasksRemove(BacklogItem backlogItem, Task task) {
        logger.log(Level.WARNING, "Can't remove tasks now while in state: Testing");
    }

    public void moveForward(BacklogItem backlogItem) {
        logger.log(Level.INFO, String.format("Moved %s to: Tested", backlogItem.getName()));
        backlogItem.setState(new TestedState());
    }

    public void moveBackward(BacklogItem backlogItem) {
        logger.log(Level.INFO, String.format("Moved %s to: ToDo", backlogItem.getName()));
        setUpReceivers(backlogItem, "LeadDeveloper");
        backlogItem.setState(new ToDoState());
    }


}
