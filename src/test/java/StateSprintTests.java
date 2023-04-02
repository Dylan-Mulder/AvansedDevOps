import domain.BacklogItem;
import domain.Sprint;
import domain.builders.sprint.SprintBuilder;
import domain.builders.sprint.SprintDirector;
import domain.states.sprint.AbstractSprintState;
import domain.states.sprint.FinishedState;
import domain.states.sprint.NotStartedState;
import domain.states.sprint.OngoingState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StateSprintTests {
    /* ATTRIBUTES */
    private SprintDirector director;
    private SprintBuilder sprintBuilder;

    /* DATA MANAGEMENT */
    @BeforeAll
    public void setupMockData() {
        director = new SprintDirector();
        sprintBuilder = new SprintBuilder();
    }

    @AfterEach
    public void resetMockData() {
        sprintBuilder.reset();
    }


    /* TESTS */

    //State Changes
    @Test
    void checkIfDefaultStateIsNotStarted(){
        Sprint sprint = sprintBuilder.build();
        AbstractSprintState state = sprint.getState();
        assertEquals(NotStartedState.class, state.getClass());
    }

    @Test
    void checkStateChanges_NotStartedToOngoing(){
        director.buildStandardReleaseSprint(sprintBuilder);
        Sprint sprint = sprintBuilder.build();
        sprint.start();
        AbstractSprintState state = sprint.getState();
        assertEquals(OngoingState.class, state.getClass());
    }

    @Test
    void checkStateChanges_OngoingToFinished(){
        director.buildStandardReleaseSprint(sprintBuilder);
        Sprint sprint = sprintBuilder.build();
        sprint.setState(new OngoingState(sprint));
        sprint.performFinish();

        AbstractSprintState state = sprint.getState();
        assertEquals(FinishedState.class, state.getClass());
    }

    @Test
    void checkStateChanges_FinishedToOngoing(){
        director.buildStandardReleaseSprint(sprintBuilder);
        Sprint sprint = sprintBuilder.build();
        sprint.setState(new FinishedState(sprint));
        sprint.start();

        AbstractSprintState state = sprint.getState();
        assertEquals(FinishedState.class, state.getClass());
    }


    //setTitle()
    @Test
    void checkSetTitle_NotStarted(){
        director.buildStandardReleaseSprint(sprintBuilder);
        Sprint sprint = sprintBuilder.build();
        sprint.setNameState("Test123");

        assertEquals("Test123", sprint.getName());
    }

    @Test
    void checkSetTitle_Ongoing(){
        director.buildStandardReleaseSprint(sprintBuilder);
        Sprint sprint = sprintBuilder.build();
        sprint.setState(new OngoingState(sprint));
        sprint.setName("Test321");
        sprint.setNameState("Test123");

        assertEquals("Test321", sprint.getName());
    }

    @Test
    void checkSetTitle_Finished(){
        director.buildStandardReleaseSprint(sprintBuilder);
        Sprint sprint = sprintBuilder.build();
        sprint.setState(new FinishedState(sprint));
        sprint.setName("Test321");
        sprint.setNameState("Test123");

        assertEquals("Test321", sprint.getName());
    }

    //setDescription()
    @Test
    void checkSetDescription_NotStarted(){
        director.buildStandardReleaseSprint(sprintBuilder);
        Sprint sprint = sprintBuilder.build();
        sprint.setDescriptionState("Test123");

        assertEquals("Test123", sprint.getDescription());
    }

    @Test
    void checkSetDescription_Ongoing(){
        director.buildStandardReleaseSprint(sprintBuilder);
        Sprint sprint = sprintBuilder.build();
        sprint.setState(new OngoingState(sprint));
        sprint.setDescription("Test321");
        sprint.setDescriptionState("Test123");

        assertEquals("Test321", sprint.getDescription());
    }

    @Test
    void checkSetDescription_Finished(){
        director.buildStandardReleaseSprint(sprintBuilder);
        Sprint sprint = sprintBuilder.build();
        sprint.setState(new FinishedState(sprint));
        sprint.setDescription("Test321");
        sprint.setDescriptionState("Test123");

        assertEquals("Test321", sprint.getDescription());
    }

    //addBacklogItem()
    @Test
    void checkAddBacklogItem_NotStarted(){
        director.buildStandardReleaseSprint(sprintBuilder);
        Sprint sprint = sprintBuilder.build();
        BacklogItem backlogItem = new BacklogItem("Test","123");
        sprint.addBacklogItem(backlogItem);

        assertEquals(sprint.getBacklogItems().size(),1);
    }

    @Test
    void checkAddBacklogItem_Ongoing(){
        director.buildStandardReleaseSprint(sprintBuilder);
        Sprint sprint = sprintBuilder.build();
        sprint.setState(new OngoingState(sprint));
        BacklogItem backlogItem = new BacklogItem("Test","123");
        sprint.addBacklogItem(backlogItem);

        assertEquals(sprint.getBacklogItems().size(),0);
    }

    @Test
    void checkAddBacklogItem_Finished(){
        director.buildStandardReleaseSprint(sprintBuilder);
        Sprint sprint = sprintBuilder.build();
        sprint.setState(new FinishedState(sprint));
        BacklogItem backlogItem = new BacklogItem("Test","123");
        sprint.addBacklogItem(backlogItem);

        assertEquals(sprint.getBacklogItems().size(),0);
    }

    //removeBacklogItem()
    @Test
    void checkRemoveBacklogItem_NotStarted(){
        director.buildStandardReleaseSprint(sprintBuilder);
        Sprint sprint = sprintBuilder.build();
        BacklogItem backlogItem = new BacklogItem("Test","123");
        sprint.addBacklogItem(backlogItem);
        sprint.removeBacklogItem(backlogItem);

        assertEquals(sprint.getBacklogItems().size(),0);
    }

    @Test
    void checkRemoveBacklogItem_Ongoing(){
        director.buildStandardReleaseSprint(sprintBuilder);
        Sprint sprint = sprintBuilder.build();
        BacklogItem backlogItem = new BacklogItem("Test","123");
        sprint.addBacklogItem(backlogItem);
        sprint.setState(new OngoingState(sprint));
        sprint.removeBacklogItem(backlogItem);

        assertEquals(sprint.getBacklogItems().size(),1);
    }

    @Test
    void checkRemoveBacklogItem_Finished(){
        director.buildStandardReleaseSprint(sprintBuilder);
        Sprint sprint = sprintBuilder.build();
        BacklogItem backlogItem = new BacklogItem("Test","123");
        sprint.addBacklogItem(backlogItem);
        sprint.setState(new FinishedState(sprint));
        sprint.removeBacklogItem(backlogItem);

        assertEquals(sprint.getBacklogItems().size(),1);
    }

    //performFinish()
    @Test
    void checkFinish_NotStarted(){
        director.buildStandardReleaseSprint(sprintBuilder);
        Sprint sprint = sprintBuilder.build();
        sprint.performFinish();
        AbstractSprintState state = sprint.getState();

        assertEquals(NotStartedState.class, state.getClass());
    }

    @Test
    void checkFinish_Ongoing(){
        director.buildStandardReleaseSprint(sprintBuilder);
        Sprint sprint = sprintBuilder.build();
        sprint.setState(new OngoingState(sprint));

        sprint.performFinish();
        AbstractSprintState state = sprint.getState();

        assertEquals(FinishedState.class, state.getClass());
    }

    @Test
    void checkFinish_Finished(){
        director.buildStandardReleaseSprint(sprintBuilder);
        Sprint sprint = sprintBuilder.build();
        sprint.setState(new FinishedState(sprint));

        sprint.performFinish();
        AbstractSprintState state = sprint.getState();

        assertEquals(FinishedState.class, state.getClass());
    }
}
