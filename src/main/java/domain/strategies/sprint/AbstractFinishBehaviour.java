package domain.strategies.sprint;

import domain.builders.cicd.PipelineBuilder;
import domain.builders.cicd.PipelineDirector;
import domain.states.backlogItem.InBacklogState;
import domain.visitors.cicd.ExecuteVisitor;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractFinishBehaviour {
    /* ATTRIBUTES */
    private final Logger logger = Logger.getLogger(InBacklogState.class.getName());
    private PipelineDirector director;
    private PipelineBuilder builder;
    private ExecuteVisitor visitor;

    /* CONSTRUCTORS */
    public AbstractFinishBehaviour() {
        logger.setLevel(Level.CONFIG);
        director = new PipelineDirector();
        builder = new PipelineBuilder();
        visitor = new ExecuteVisitor();
    }

    /* GETTERS */
    public PipelineDirector getDirector() {
        return director;
    }
    public PipelineBuilder getBuilder() {
        return builder;
    }
    public ExecuteVisitor getVisitor() {
        return visitor;
    }

    /* SETTERS */

    /* METHODS */
    abstract public void performFinish();
}
