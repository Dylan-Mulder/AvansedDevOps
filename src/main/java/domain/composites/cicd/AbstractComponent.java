package domain.composites.cicd;

import domain.states.backlogItem.InBacklogState;
import domain.visitors.cicd.AbstractVisitor;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractComponent {
    /* ATTRIBUTES */
    Logger logger = Logger.getLogger(InBacklogState.class.getName());

    /* CONSTRUCTORS */
    public AbstractComponent() {
        logger.setLevel(Level.CONFIG);
    }

    /* GETTERS */

    /* SETTERS */

    /* METHODS */
    abstract public void acceptVisitor(AbstractVisitor visitor);
}
