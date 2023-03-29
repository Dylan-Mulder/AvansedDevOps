package domain.visitors.cicd;

import domain.composites.cicd.Command;
import domain.composites.cicd.Job;
import domain.composites.cicd.Pipeline;
import domain.composites.cicd.Stage;
import domain.states.backlogItem.InBacklogState;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractVisitor {
    /* ATTRIBUTES */
    Logger logger = Logger.getLogger(InBacklogState.class.getName());

    /* CONSTRUCTORS */
    public AbstractVisitor() {
        logger.setLevel(Level.CONFIG);
    }

    /* GETTERS */

    /* SETTERS */

    /* METHODS */
    abstract public void visitPipeline(Pipeline pipeline);
    abstract public void visitStage(Stage stage);
    abstract public void visitJob(Job job);
    abstract public void visitCommand(Command command);
}
