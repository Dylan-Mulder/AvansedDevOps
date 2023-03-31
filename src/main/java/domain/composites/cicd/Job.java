package domain.composites.cicd;

import domain.visitors.cicd.AbstractVisitor;

public class Job extends CompositeComponent {
    /* ATTRIBUTES */
    private String description;

    /* CONSTRUCTORS */
    public Job(String name) {
        setName(name);
        setDescription("");
    }
    public Job(String name, String description) {
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
        visitor.visitJob(this);
        super.acceptVisitor(visitor);
    }
}
