import domain.*;
import domain.builders.sprint.SprintBuilder;
import domain.builders.sprint.SprintDirector;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProjectTests {
    /* ATTRIBUTES */
    private Project project;
    private BacklogItem backlogItem1;
    private BacklogItem backlogItem2;
    private Developer developer1;
    private Developer developer2;

    private SprintDirector director;
    private SprintBuilder sprintBuilder;

    /* DATA MANAGEMENT */
    @BeforeAll
    public void setupMockData() {
        developer1 = new Developer("developer1","Tester", true, true);
        developer2 = new Developer("developer2","Tester", true, true);

        project = new Project(developer1);
        backlogItem1 = new BacklogItem("Feature 1", "Use JUnit");
        backlogItem2 = new BacklogItem("Feature 2", "Use Java");

        director = new SprintDirector();
        sprintBuilder = new SprintBuilder();
    }

    @AfterEach
    public void resetMockData() {
        sprintBuilder.reset();
        developer1 = new Developer("developer1","Tester", true, true);
        developer2 = new Developer("developer2","Tester", true, true);

        project = new Project(developer1);
        backlogItem1 = new BacklogItem("Feature 1", "Use JUnit");
        backlogItem2 = new BacklogItem("Feature 2", "Use Java");
    }

    /* TESTS */
    @Test
    void testAddBacklogItem() {
        project.addBacklogItem(backlogItem1);
        project.addBacklogItem(backlogItem2);

        List<BacklogItem> backlogItems = project.getBacklogItems();

        assertEquals(2, backlogItems.size());
        assertTrue(backlogItems.contains(backlogItem1));
        assertTrue(backlogItems.contains(backlogItem2));
    }
    @Test
    void testAddSprint() {
        director.buildStandardReleaseSprint(sprintBuilder);
        Sprint sprint = sprintBuilder.build();
        project.addSprint(sprint);
        List<Sprint> sprints = project.getSprints();

        assertEquals(1, sprints.size());
        assertTrue(sprints.contains(sprint));
    }

    @Test
    void testAddDeveloper() {
        project.addDeveloper(developer1);
        project.addDeveloper(developer2);

        List<Developer> developers = project.getDevelopers();

        assertEquals(2, developers.size());
        assertTrue(developers.contains(developer1));
        assertTrue(developers.contains(developer2));
    }

    @Test
    void testRemoveBacklogItem() {
        project.addBacklogItem(backlogItem1);
        project.addBacklogItem(backlogItem2);

        project.removeBacklogItem(backlogItem1);

        List<BacklogItem> backlogItems = project.getBacklogItems();

        assertEquals(1, backlogItems.size());
        assertFalse(backlogItems.contains(backlogItem1));
        assertTrue(backlogItems.contains(backlogItem2));
    }
    @Test
    void testRemoveSprint() {
        Sprint sprint = sprintBuilder.build();
        project.addSprint(sprint);
        List<Sprint> sprints = project.getSprints();

        assertEquals(1, sprints.size());
        assertTrue(sprints.contains(sprint));
        sprints.remove(sprint);
        assertEquals(0, sprints.size());
        assertFalse(sprints.contains(sprint));
    }

    @Test
    void testRemoveDeveloper() {
        project.addDeveloper(developer1);
        project.addDeveloper(developer2);

        project.removeDeveloper(developer1);

        List<Developer> developers = project.getDevelopers();

        assertEquals(1, developers.size());
        assertFalse(developers.contains(developer1));
        assertTrue(developers.contains(developer2));
    }

    @Test
    void testSprintReport() {
        sprintBuilder.setName("TestName");
        sprintBuilder.setDescription("TestDesc");
        sprintBuilder.setDuration(1);
        sprintBuilder.setStartDate(LocalDate.of(2023,4,1));
        Sprint sprint = sprintBuilder.build();
        Task task = new Task("Task 1", "Beam me up!");
        task.setIsFinished(true);
        backlogItem1.addTask(task);
        sprint.addBacklogItem(backlogItem1);
        sprint.addDeveloper(developer1);

        project.addSprint(sprint);

        List<Sprint> sprints = project.getSprints();
        String report = project.sprintReport(sprints.get(0), "Avans");
        assertEquals(report, "Sprint Report generated for: Avans\n" +
                "State of sprint: Not Started\n" +
                "Total number of Developers: 1\n" +
                "Total number of BacklogItems: 1\n" +
                "Containing a total of 1 tasks,\n" +
                "of which 1 have been completed.\n" +
                "The end date of this sprint is: 2023-04-08");
    }

}
