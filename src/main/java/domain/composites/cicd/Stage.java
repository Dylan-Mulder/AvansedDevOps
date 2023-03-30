package domain.composites.cicd;

import domain.visitors.cicd.AbstractVisitor;

public class Stage extends CompositeComponent {
    /* ATTRIBUTES */

    /* CONSTRUCTORS */
    public Stage(String name) {
        setName(name);
        setContent("");
    }
    public Stage(String name, String content) {
        setName(name);
        setContent(content);
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
