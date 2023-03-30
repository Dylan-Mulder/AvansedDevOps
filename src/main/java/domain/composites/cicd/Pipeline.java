package domain.composites.cicd;

import domain.visitors.cicd.AbstractVisitor;

public class Pipeline extends CompositeComponent {
    /* ATTRIBUTES */

    /* CONSTRUCTORS */
    public Pipeline(String name) {
        setName(name);
        setDescription("No description provided");
    }
    public Pipeline(String name, String description) {
        setName(name);
        setDescription(description);
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
