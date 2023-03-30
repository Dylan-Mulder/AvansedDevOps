package domain.visitors.cicd;

import domain.composites.cicd.*;

public class ExecuteVisitor extends AbstractVisitor {
    /* ATTRIBUTES */

    /* CONSTRUCTORS */
    public ExecuteVisitor() {}

    /* GETTERS */

    /* SETTERS */

    /* METHODS */
    @Override
    public void visitPipeline(Pipeline pipeline) {
        execute(pipeline);
    }

    @Override
    public void visitStage(Stage stage) {
        execute(stage);
    }

    @Override
    public void visitJob(Job job) {
        execute(job);
    }

    @Override
    public void visitCommand(Command command) {
        execute(command);
    }

    public void execute(AbstractComponent component) {
        System.out.println("/||\\ EXECUTING: " + component.getClass().getSimpleName() + " | " + component.getName() + " /||\\");
        if (!component.getContent().isEmpty()) System.out.println("~~ " + component.getContent());
        System.out.println("\n");
    }
}
