package domain.composites.cicd;

import domain.visitors.cicd.AbstractVisitor;

public class CompositeComponent extends AbstractComponent {
    /* ATTRIBUTES */

    /* CONSTRUCTORS */
    public CompositeComponent() {}

    /* GETTERS */

    /* SETTERS */

    /* METHODS */

    @Override
    public void acceptVisitor(AbstractVisitor visitor) {

    }

    public void addComponent(AbstractComponent component) {

    }

    public AbstractComponent getComponent(int position) {
        return null;
    }
}
