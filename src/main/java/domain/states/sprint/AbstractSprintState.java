package domain.states.sprint;

import domain.Sprint;
import domain.states.backlogItem.InBacklogState;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractSprintState {
    /* ATTRIBUTES */
    Logger logger = Logger.getLogger(InBacklogState.class.getName());

    /* CONSTRUCTORS */
    public AbstractSprintState() {
        logger.setLevel(Level.CONFIG);
    }

    /* GETTERS */

    /* SETTERS */

    /* METHODS */
    abstract public void start(Sprint sprint);
    abstract public void performFinish(Sprint sprint);

}
