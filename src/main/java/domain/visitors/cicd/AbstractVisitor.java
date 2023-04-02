package domain.visitors.cicd;

import domain.composites.cicd.Command;
import domain.composites.cicd.Job;
import domain.composites.cicd.Pipeline;
import domain.composites.cicd.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractVisitor {
    /* ATTRIBUTES */
    Logger logger = Logger.getLogger(AbstractVisitor.class.getName());

    /* CONSTRUCTORS */
    protected AbstractVisitor() {
        logger.setLevel(Level.CONFIG);
    }

    /* GETTERS */

    /* SETTERS */

    /* METHODS */
    public abstract void visitPipeline(Pipeline pipeline);
    public abstract void visitStage(Stage stage);
    public abstract void visitJob(Job job);
    public abstract void visitCommand(Command command);
}
