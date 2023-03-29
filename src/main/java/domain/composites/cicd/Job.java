package domain.composites.cicd;

import domain.visitors.cicd.AbstractVisitor;

public class Job extends CompositeComponent {
    /* ATTRIBUTES */

    /* CONSTRUCTORS */
    public Job() {}

    /* GETTERS */

    /* SETTERS */

    /* METHODS */
    @Override
    public void acceptVisitor(AbstractVisitor visitor) {
        super.acceptVisitor(visitor);
    }
}
