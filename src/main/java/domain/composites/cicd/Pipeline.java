package domain.composites.cicd;

import domain.visitors.cicd.AbstractVisitor;

public class Pipeline extends CompositeComponent {
    /* ATTRIBUTES */

    /* CONSTRUCTORS */
    public Pipeline() {
        // Builder Pattern
    }

    /* GETTERS */

    /* SETTERS */

    /* METHODS */
    @Override
    public void acceptVisitor(AbstractVisitor visitor) {
        visitor.visitPipeline(this);
        super.acceptVisitor(visitor);
    }
}
