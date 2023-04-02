package domain.composites.cicd;

import domain.visitors.cicd.AbstractVisitor;

public class Job extends CompositeComponent {
    /* ATTRIBUTES */

    /* CONSTRUCTORS */
    public Job() {
        // Builder Pattern
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
