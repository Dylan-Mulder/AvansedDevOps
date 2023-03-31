package domain.composites.cicd;

import domain.visitors.cicd.AbstractVisitor;

import java.util.ArrayList;

public class CompositeComponent extends AbstractComponent {
    /* ATTRIBUTES */
    private final ArrayList<AbstractComponent> components = new ArrayList<>();
    private String description;

    /* CONSTRUCTORS */
    public CompositeComponent() {}

    /* GETTERS */
    public AbstractComponent getComponent(int position) {
        return components.get(position);
    }
    public int getComponentsSize() {
        return components.size();
    }
    public String getDescription() {
        return description;
    }

    /* SETTERS */
    public void addComponent(AbstractComponent component) {
        components.add(component);
    }
    public void setDescription(String description) {
        this.description = description;
    }
    /* METHODS */
    @Override
    public void acceptVisitor(AbstractVisitor visitor) {
        for (AbstractComponent component : components) {
            component.acceptVisitor(visitor);
        }
    }
}
