import domain.Sprint;
import domain.builders.sprint.Director;
import domain.builders.sprint.SprintBuilder;
import domain.strategies.sprint.FinishRelease;
import domain.strategies.sprint.FinishReview;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BuilderTests {
    /* ATTRIBUTES */
    private Director director;
    private SprintBuilder sprintBuilder;

    /* DATA MANAGEMENT */
    @BeforeAll
    public void setupMockData() {
        director = new Director();
        sprintBuilder = new SprintBuilder();
    }

    @AfterEach
    public void resetMockData() {
        sprintBuilder.reset();
    }

    /* TESTS */
    @Test
    public void checkIfSprintIsStandardRelease() {
        director.buildStandardReleaseSprint(sprintBuilder);
        Sprint sprint = sprintBuilder.build();

        assertAll(
                "Grouped assertions of Standard Release Sprint",
                () -> assertEquals("New Standard Release Sprint", sprint.getName()),
                () -> assertEquals("A Release Sprint of 2 weeks", sprint.getDescription()),
                () -> assertInstanceOf(FinishRelease.class, sprint.getFinishBehaviour()),
                () -> assertEquals(2, sprint.getDuration()),
                () -> assertEquals(LocalDate.now().plusWeeks(1), sprint.getStartDate()),
                () -> assertEquals(LocalDate.now().plusWeeks(1 + sprint.getDuration()), sprint.getEndDate())
        );
    }

    @Test
    public void checkIfSprintIsLongRelease() {
        director.buildLongReleaseSprint(sprintBuilder);
        Sprint sprint = sprintBuilder.build();

        assertAll(
                "Grouped assertions of Long Release Sprint",
                () -> assertEquals("New Long Release Sprint", sprint.getName()),
                () -> assertEquals("A Release Sprint of 4 weeks", sprint.getDescription()),
                () -> assertInstanceOf(FinishRelease.class, sprint.getFinishBehaviour()),
                () -> assertEquals(4, sprint.getDuration()),
                () -> assertEquals(LocalDate.now().plusWeeks(1), sprint.getStartDate()),
                () -> assertEquals(LocalDate.now().plusWeeks(1 + sprint.getDuration()), sprint.getEndDate())
        );
    }

    @Test
    public void checkIfSprintIsStandardReview() {
        director.buildStandardReviewSprint(sprintBuilder);
        Sprint sprint = sprintBuilder.build();

        assertAll(
                "Grouped assertions of Standard Review Sprint",
                () -> assertEquals("New Standard Review Sprint", sprint.getName()),
                () -> assertEquals("A Review Sprint of 2 weeks", sprint.getDescription()),
                () -> assertInstanceOf(FinishReview.class, sprint.getFinishBehaviour()),
                () -> assertEquals(2, sprint.getDuration()),
                () -> assertEquals(LocalDate.now().plusWeeks(1), sprint.getStartDate()),
                () -> assertEquals(LocalDate.now().plusWeeks(1 + sprint.getDuration()), sprint.getEndDate())
        );
    }

    @Test
    public void checkIfSprintIsLongReview() {
        director.buildLongReviewSprint(sprintBuilder);
        Sprint sprint = sprintBuilder.build();

        assertAll(
                "Grouped assertions of Long Review Sprint",
                () -> assertEquals("New Long Review Sprint", sprint.getName()),
                () -> assertEquals("A Review Sprint of 4 weeks", sprint.getDescription()),
                () -> assertInstanceOf(FinishReview.class, sprint.getFinishBehaviour()),
                () -> assertEquals(4, sprint.getDuration()),
                () -> assertEquals(LocalDate.now().plusWeeks(1), sprint.getStartDate()),
                () -> assertEquals(LocalDate.now().plusWeeks(1 + sprint.getDuration()), sprint.getEndDate())
        );
    }
}
