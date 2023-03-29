package domain.builders.sprint;

import domain.strategies.sprint.FinishRelease;
import domain.strategies.sprint.FinishReview;

public class Director {
    /* ATTRIBUTES */

    /* CONSTRUCTORS */
    public Director() {}

    /* METHODS */
    public void buildShortReleaseSprint(IBuilder builder) {
        builder.reset();
        builder.setType(new FinishRelease());
        builder.setDuration(2);
    }

    public void buildMediumReleaseSprint(IBuilder builder) {
        builder.reset();
        builder.setType(new FinishRelease());
        builder.setDuration(4);
    }

    public void buildLongReleaseSprint(IBuilder builder) {
        builder.reset();
        builder.setType(new FinishRelease());
        builder.setDuration(6);
    }

    public void buildShortReviewSprint(IBuilder builder) {
        builder.reset();
        builder.setType(new FinishReview());
        builder.setDuration(2);
    }

    public void buildMediumReviewSprint(IBuilder builder) {
        builder.reset();
        builder.setType(new FinishReview());
        builder.setDuration(4);
    }

    public void buildLongReviewSprint(IBuilder builder) {
        builder.reset();
        builder.setType(new FinishReview());
        builder.setDuration(6);
    }
}
