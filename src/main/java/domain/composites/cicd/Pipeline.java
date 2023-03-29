package domain.composites.cicd;

import domain.visitors.cicd.AbstractVisitor;

public class Pipeline extends CompositeComponent {
    /* ATTRIBUTES */

    /* CONSTRUCTORS */
    public Pipeline() {}

    /* GETTERS */

    /* SETTERS */

    /* METHODS */
    @Override
    public void acceptVisitor(AbstractVisitor visitor) {
        super.acceptVisitor(visitor);
    }
}
