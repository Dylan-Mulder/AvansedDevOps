package domain.strategies.sprint;

import domain.builders.cicd.PipelineBuilder;
import domain.builders.cicd.PipelineDirector;
import domain.composites.cicd.Pipeline;
import domain.visitors.cicd.ExecuteVisitor;

public class FinishRelease extends AbstractFinishBehaviour {
    /* ATTRIBUTES */

    /* CONSTRUCTORS */
    public FinishRelease() {
        super();
    }

    /* GETTERS */

    /* SETTERS */

    /* METHODS */
    public void performFinish() {
        PipelineDirector director = getDirector();
        PipelineBuilder builder = getBuilder();
        ExecuteVisitor visitor = getVisitor();

        director.buildReleasePipeline(builder);
        Pipeline pipeline = builder.build();
        pipeline.acceptVisitor(visitor);
    }
}
