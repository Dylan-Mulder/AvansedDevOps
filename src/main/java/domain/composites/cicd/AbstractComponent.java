package domain.composites.cicd;

import domain.states.backlogItem.InBacklogState;
import domain.visitors.cicd.AbstractVisitor;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractComponent {
    /* ATTRIBUTES */
    private final Logger logger = Logger.getLogger(InBacklogState.class.getName());
    private String name;
    private String description;

    /* CONSTRUCTORS */
    public AbstractComponent() {
        logger.setLevel(Level.CONFIG);
    }

    /* GETTERS */
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    /* SETTERS */
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    /* METHODS */
    abstract public void acceptVisitor(AbstractVisitor visitor);
}
