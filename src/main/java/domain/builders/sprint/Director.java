package domain.builders.sprint;

import domain.strategies.sprint.FinishRelease;
import domain.strategies.sprint.FinishReview;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Director {
    /* ATTRIBUTES */

    /* CONSTRUCTORS */
    public Director() {}

    /* METHODS */
    public void buildStandardReleaseSprint(IBuilder builder) {
        builder.reset();
        builder.setName("New Standard Release Sprint");
        builder.setDescription("A Release Sprint of 2 weeks");
        builder.setType(new FinishRelease());
        builder.setDuration(2);
        builder.setStartDate(LocalDate.now().plusWeeks(1));
    }

    public void buildLongReleaseSprint(IBuilder builder) {
        builder.reset();
        builder.setName("New Long Release Sprint");
        builder.setDescription("A Release Sprint of 4 weeks");
        builder.setType(new FinishRelease());
        builder.setDuration(4);
        builder.setStartDate(LocalDate.now().plusWeeks(1));
    }

    public void buildStandardReviewSprint(IBuilder builder) {
        builder.reset();
        builder.setName("New Standard Review Sprint");
        builder.setDescription("A Review Sprint of 2 weeks");
        builder.setType(new FinishReview());
        builder.setDuration(2);
        builder.setStartDate(LocalDate.now().plusWeeks(1));
    }

    public void buildLongReviewSprint(IBuilder builder) {
        builder.reset();
        builder.setName("New Long Review Sprint");
        builder.setDescription("A Review Sprint of 4 weeks");
        builder.setType(new FinishReview());
        builder.setDuration(4);
        builder.setStartDate(LocalDate.now().plusWeeks(1));
    }
}
