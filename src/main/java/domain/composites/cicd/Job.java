package domain.composites.cicd;

import domain.visitors.cicd.AbstractVisitor;

public class Job extends CompositeComponent {
    /* ATTRIBUTES */

    /* CONSTRUCTORS */
    public Job(String name) {
        setName(name);
        setDescription("No description provided");
    }
    public Job(String name, String description) {
        setName(name);
        setDescription(description);
    }

    /* GETTERS */

    /* SETTERS */

    /* METHODS */
    @Override
    public void acceptVisitor(AbstractVisitor visitor) {
        visitor.visitJob(this);
        super.acceptVisitor(visitor);
    }
}
