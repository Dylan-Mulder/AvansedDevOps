package domain.composites.cicd;

import domain.visitors.cicd.AbstractVisitor;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractComponent {
    /* ATTRIBUTES */
    private final Logger logger = Logger.getLogger(AbstractComponent.class.getName());
    private String name;

    /* CONSTRUCTORS */
    protected AbstractComponent() {
        logger.setLevel(Level.CONFIG);
    }

    /* GETTERS */
    public String getName() {
        return name;
    }

    /* SETTERS */
    public void setName(String name) {
        this.name = name;
    }

    /* METHODS */
    public abstract void acceptVisitor(AbstractVisitor visitor);
}
