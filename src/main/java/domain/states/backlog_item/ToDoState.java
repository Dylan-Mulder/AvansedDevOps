package domain.states.backlog_item;

import domain.BacklogItem;
import domain.Task;

import java.util.logging.Level;

public class ToDoState extends AbstractBacklogItemState {
    public ToDoState() {
        // Only create the Object
    }

    public void changeName(BacklogItem backlogItem, String name) {
        logger.log(Level.WARNING, "Can't change name while in state: To Do");
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
        logger.log(Level.INFO, "Moved " + backlogItem.getName() + " to: Doing");
        backlogItem.setState(new DoingState());
    }

    public void moveBackward(BacklogItem backlogItem) {
        logger.log(Level.INFO, "Moved " + backlogItem.getName() + " to: In Backlog");
        backlogItem.setState(new InBacklogState());
    }
}
