package domain.states.backlogItem;

import domain.BacklogItem;
import domain.Task;
import java.util.logging.Level;

public class InBacklogState extends AbstractBacklogItemState {
    /* ATTRIBUTES */

    /* CONSTRUCTORS */
    public InBacklogState() {}

    /* GETTERS */


    /* SETTERS */


    /* METHODS */
    public void changeName(BacklogItem backlogItem, String name) {
        logger.log(Level.INFO, "Changed " + backlogItem.getName() + " to " + name);
        backlogItem.setName(name);
    }

    public void changeDescription(BacklogItem backlogItem, String description) {
        logger.log(Level.INFO, "Changed " + backlogItem.getDescription() + " to " + description);
        backlogItem.setDescription(description);
    }

    public void changeTasksAdd(BacklogItem backlogItem, Task task) {
        logger.log(Level.INFO, "Added task " + task.getName() + " to " + backlogItem.getName());
        backlogItem.addTask(task);
    }

    public void changeTasksRemove(BacklogItem backlogItem, Task task) {
        logger.log(Level.INFO, "Removed task " + task.getName() + " from " + backlogItem.getName());
        backlogItem.removeTask(task);
    }

    public void moveForward(BacklogItem backlogItem) {
        logger.log(Level.INFO, "Moved " + backlogItem.getName() + " to: To Do");
        backlogItem.setState(new ToDoState());
    }

    public void moveBackward(BacklogItem backlogItem) {
        logger.log(Level.WARNING, "Can't move backwards!");
        // Do nothing
    }
}
