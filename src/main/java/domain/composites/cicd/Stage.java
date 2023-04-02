package domain.composites.cicd;

import domain.visitors.cicd.AbstractVisitor;

public class Stage extends CompositeComponent {
    /* ATTRIBUTES */

    /* CONSTRUCTORS */
    public Stage() {
        // Builder Pattern
    }

    /* GETTERS */

    /* SETTERS */

    /* METHODS */
    @Override
    public void acceptVisitor(AbstractVisitor visitor) {
        visitor.visitStage(this);
        super.acceptVisitor(visitor);
    }
}
