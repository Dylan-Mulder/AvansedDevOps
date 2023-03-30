package domain.composites.cicd;

import domain.visitors.cicd.AbstractVisitor;

public class Command extends AbstractComponent {
    /* ATTRIBUTES */

    /* CONSTRUCTORS */
    public Command(String name, String content) {
        setName(name);
        setContent(content);
    }

    /* GETTERS */

    /* SETTERS */

    /* METHODS */
    @Override
    public void acceptVisitor(AbstractVisitor visitor) {
        visitor.visitCommand(this);
    }
}
