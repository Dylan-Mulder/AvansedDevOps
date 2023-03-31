package domain.composites.cicd;

import domain.visitors.cicd.AbstractVisitor;

import java.util.ArrayList;

public class CompositeComponent extends AbstractComponent {
    /* ATTRIBUTES */
    private final ArrayList<AbstractComponent> components = new ArrayList<>();

    /* CONSTRUCTORS */
    public CompositeComponent() {}

    /* GETTERS */
    public AbstractComponent getComponent(int position) {
        return components.get(position);
    }

    /* SETTERS */
    public void addComponent(AbstractComponent component) {
        components.add(component);
    }

    /* METHODS */
    @Override
    public void acceptVisitor(AbstractVisitor visitor) {
        for (AbstractComponent component : components) {
            component.acceptVisitor(visitor);
        }
    }
}
