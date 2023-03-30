package domain.composites.cicd;

import domain.visitors.cicd.AbstractVisitor;

public class Job extends CompositeComponent {
    /* ATTRIBUTES */

    /* CONSTRUCTORS */
    public Job(String name) {
        setName(name);
        setContent("");
    }
    public Job(String name, String content) {
        setName(name);
        setContent(content);
    }

    /* GETTERS */

    /* SETTERS */

    /* METHODS */
    @Override
    public void acceptVisitor(AbstractVisitor visitor) {
        visitor.visitJob(this);
        super.acceptVisitor(visitor);
    }
}
