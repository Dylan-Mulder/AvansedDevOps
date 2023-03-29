package domain.visitors.cicd;

import domain.composites.cicd.Command;
import domain.composites.cicd.Job;
import domain.composites.cicd.Pipeline;
import domain.composites.cicd.Stage;

public class ExecuteVisitor extends AbstractVisitor {
    /* ATTRIBUTES */

    /* CONSTRUCTORS */
    public ExecuteVisitor() {}

    /* GETTERS */

    /* SETTERS */

    /* METHODS */
    @Override
    public void visitPipeline(Pipeline pipeline) {

    }

    @Override
    public void visitStage(Stage stage) {

    }

    @Override
    public void visitJob(Job job) {

    }

    @Override
    public void visitCommand(Command command) {

    }
}
