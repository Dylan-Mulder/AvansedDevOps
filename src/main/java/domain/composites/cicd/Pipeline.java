package domain.composites.cicd;

import domain.visitors.cicd.AbstractVisitor;

public class Pipeline extends CompositeComponent {
    /* ATTRIBUTES */
    private String description;

    /* CONSTRUCTORS */
    public Pipeline(String name) {
        setName(name);
        setDescription("");
    }
    public Pipeline(String name, String description) {
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
        visitor.visitPipeline(this);
        super.acceptVisitor(visitor);
    }
}
