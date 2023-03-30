package domain.composites.cicd;

import domain.visitors.cicd.AbstractVisitor;

public class Command extends AbstractComponent {
    /* ATTRIBUTES */

    /* CONSTRUCTORS */
    public Command(String name) {
        setName(name);
        setDescription("No description provided");
    }
    public Command(String name, String description) {
        setName(name);
        setDescription(description);
    }

    /* GETTERS */

    /* SETTERS */

    /* METHODS */
    @Override
    public void acceptVisitor(AbstractVisitor visitor) {
        visitor.visitCommand(this);
    }
}
