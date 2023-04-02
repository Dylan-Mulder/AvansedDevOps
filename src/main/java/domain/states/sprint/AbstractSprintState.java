package domain.states.sprint;

import domain.BacklogItem;
import domain.Sprint;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractSprintState {
    /* ATTRIBUTES */
    protected Sprint sprint;
    Logger logger = Logger.getLogger(AbstractSprintState.class.getName());

    /* CONSTRUCTORS */
    protected AbstractSprintState(Sprint sprint) {
        logger.setLevel(Level.CONFIG);
        this.sprint = sprint;
    }

    /* GETTERS */
    public abstract String getStateName();

    /* SETTERS */
    public abstract void setName(String name);
    public abstract void setDescription(String description);
    public abstract void addBacklogItem(BacklogItem backlogItem);
    public abstract void removeBacklogItem(BacklogItem backlogItem);

    /* METHODS */

    public abstract void start();
    public abstract void performFinish();
    public void dispose() {
        //Use this method to clean up any ongoing processes.
    }
}
