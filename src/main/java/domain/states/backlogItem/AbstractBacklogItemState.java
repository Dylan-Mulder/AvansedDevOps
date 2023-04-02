package domain.states.backlogItem;

import domain.BacklogItem;
import domain.Task;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractBacklogItemState {
    /* ATTRIBUTES */
    Logger logger = Logger.getLogger(InBacklogState.class.getName());

    /* CONSTRUCTORS */
    public AbstractBacklogItemState() {
        logger.setLevel(Level.CONFIG);
    }

    /* METHODS */
    abstract public void changeName(BacklogItem backlogItem, String name);
    abstract public void changeDescription(BacklogItem backlogItem, String description);
    abstract public void changeTasksAdd(BacklogItem backlogItem, Task task);
    abstract public void changeTasksRemove(BacklogItem backlogItem, Task task);
    abstract public void moveForward(BacklogItem backlogItem);
    abstract public void moveBackward(BacklogItem backlogItem);
}
