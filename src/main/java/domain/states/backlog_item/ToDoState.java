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
        logger.log(Level.INFO, String.format("Changed %s to %s", backlogItem.getDescription(), description));
        backlogItem.setDescription(description);
    }

    public void changeTasksAdd(BacklogItem backlogItem, Task task) {
        logger.log(Level.INFO, String.format("Added task %s to %s", task.getName(), backlogItem.getName()));
        backlogItem.addTask(task);
    }

    public void changeTasksRemove(BacklogItem backlogItem, Task task) {
        logger.log(Level.INFO, String.format("Removed task %s from %s", task.getName(), backlogItem.getName()));
        backlogItem.removeTask(task);
    }

    public void moveForward(BacklogItem backlogItem) {
        logger.log(Level.INFO, String.format("Moved %s to: Doing", backlogItem.getName()));
        backlogItem.setState(new DoingState());
    }

    public void moveBackward(BacklogItem backlogItem) {
        logger.log(Level.INFO, String.format("Moved %s to: In Backlog", backlogItem.getName()));
        backlogItem.setState(new InBacklogState());
    }
}
