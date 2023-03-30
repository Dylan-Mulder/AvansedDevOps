package domain.states.sprint;

import domain.BacklogItem;
import domain.Sprint;
import domain.states.backlogItem.InBacklogState;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractSprintState {
    /* ATTRIBUTES */
    protected Sprint sprint;
    Logger logger = Logger.getLogger(InBacklogState.class.getName());

    /* CONSTRUCTORS */
    public AbstractSprintState(Sprint sprint) {
        logger.setLevel(Level.CONFIG);
        this.sprint = sprint;
    }

    /* GETTERS */

    /* SETTERS */
    abstract public void setName(String name);
    abstract public void setDescription(String description);
    abstract public void addBacklogItem(BacklogItem backlogItem);
    abstract public void removeBacklogItem(BacklogItem backlogItem);

    /* METHODS */

    abstract public void start();
    abstract public void performFinish();
    public void dispose() {
        //Use this method to clean up any ongoing processes.
    }
}
