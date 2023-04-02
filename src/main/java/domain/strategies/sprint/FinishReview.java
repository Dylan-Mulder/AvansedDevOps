package domain.strategies.sprint;

import domain.builders.cicd.PipelineBuilder;
import domain.builders.cicd.PipelineDirector;
import domain.composites.cicd.Pipeline;
import domain.visitors.cicd.ExecuteVisitor;

public class FinishReview extends AbstractFinishBehaviour {
    /* ATTRIBUTES */

    /* CONSTRUCTORS */
    public FinishReview() {
        super();
    }

    /* GETTERS */

    /* SETTERS */

    /* METHODS */
    public void performFinish() {
        PipelineDirector director = getDirector();
        PipelineBuilder builder = getBuilder();
        ExecuteVisitor visitor = getVisitor();

        director.buildReviewPipeline(builder);
        Pipeline pipeline = builder.build();
        pipeline.acceptVisitor(visitor);
    }
}
