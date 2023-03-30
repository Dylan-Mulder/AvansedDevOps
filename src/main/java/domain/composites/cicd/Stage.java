package domain.composites.cicd;

import domain.visitors.cicd.AbstractVisitor;

public class Stage extends CompositeComponent {
    /* ATTRIBUTES */

    /* CONSTRUCTORS */
    public Stage(String name) {
        setName(name);
        setDescription("No description provided");
    }
    public Stage(String name, String description) {
        setName(name);
        setDescription(description);
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
