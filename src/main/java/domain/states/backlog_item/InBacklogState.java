package domain.states.backlog_item;

import domain.BacklogItem;
import domain.Task;
import java.util.logging.Level;

public class InBacklogState extends AbstractBacklogItemState {
    public InBacklogState() {
        // Only create the Object
    }

    public void changeName(BacklogItem backlogItem, String name) {
        logger.log(Level.INFO, String.format("Changed %s to %s", backlogItem.getName(), name));
        backlogItem.setName(name);
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
        logger.log(Level.INFO, String.format("Moved %s to: To Do", backlogItem.getName()));
        backlogItem.setState(new ToDoState());
    }

    public void moveBackward(BacklogItem backlogItem) {
        logger.log(Level.WARNING, "Can't move backwards!");
    }
}
