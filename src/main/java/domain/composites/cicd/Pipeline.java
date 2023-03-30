package domain.composites.cicd;

import domain.visitors.cicd.AbstractVisitor;

public class Pipeline extends CompositeComponent {
    /* ATTRIBUTES */

    /* CONSTRUCTORS */
    public Pipeline(String name) {
        setName(name);
        setContent("");
    }
    public Pipeline(String name, String content) {
        setName(name);
        setContent(content);
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
