package domain.composites.cicd;

import domain.visitors.cicd.AbstractVisitor;

public class Stage extends CompositeComponent {
    /* ATTRIBUTES */
    private String description;

    /* CONSTRUCTORS */
    public Stage(String name) {
        setName(name);
        setDescription("");
    }
    public Stage(String name, String description) {
        setName(name);
        setDescription(description);
    }

    /* GETTERS */
    public String getDescription() {
        return description;
    }
    /* SETTERS */
    public void setDescription(String description) {
        this.description = description;
    }
    /* METHODS */
    @Override
    public void acceptVisitor(AbstractVisitor visitor) {
        visitor.visitStage(this);
        super.acceptVisitor(visitor);
    }
}
