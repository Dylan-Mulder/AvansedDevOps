package domain.composites.cicd;

import domain.states.backlogItem.InBacklogState;
import domain.visitors.cicd.AbstractVisitor;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractComponent {
    /* ATTRIBUTES */
    private final Logger logger = Logger.getLogger(InBacklogState.class.getName());
    private String name;
    private String content;

    /* CONSTRUCTORS */
    public AbstractComponent() {
        logger.setLevel(Level.CONFIG);
    }

    /* GETTERS */
    public String getName() {
        return name;
    }
    public String getContent() {
        return content;
    }

    /* SETTERS */
    public void setName(String name) {
        this.name = name;
    }
    public void setContent(String content) {
        this.content = content;
    }

    /* METHODS */
    abstract public void acceptVisitor(AbstractVisitor visitor);
}
