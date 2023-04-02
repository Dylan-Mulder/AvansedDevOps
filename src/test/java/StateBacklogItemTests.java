import domain.BacklogItem;
import domain.Developer;
import domain.Sprint;
import domain.Task;
import domain.builders.sprint.SprintBuilder;
import domain.builders.sprint.SprintDirector;
import domain.states.backlogItem.*;
import domain.states.sprint.AbstractSprintState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StateBacklogItemTests {
    /* ATTRIBUTES */
    BacklogItem backlogItem;
    Task task1;
    Task task2;
    Developer developer1;
    Developer developer2;
    Sprint sprint;
    SprintDirector director;
    SprintBuilder sprintBuilder;

    /* DATA MANAGEMENT */
    @BeforeAll
    public void setupMockData() {
        sprintBuilder = new SprintBuilder();
        director = new SprintDirector();
        director.buildStandardReleaseSprint(sprintBuilder);
        sprint = sprintBuilder.build();

        backlogItem = new BacklogItem("Test", "TestDesc");
        task1 = new Task("Feature 1", "Use Java");
        task2 = new Task("Feature 2", "Use JUnit");
        //task3 = new Task("Feature 3", "Use Anything");
        developer1 = new Developer("developer1","Tester", true, false);
        developer2 = new Developer("developer2","Tester", false, true);

        sprint.addDeveloper(developer1);
        sprint.addDeveloper(developer2);
        sprint.addBacklogItem(backlogItem);
    }

    @AfterEach
    public void resetMockData(){
        setupMockData();
    }

    /* Tests */
    //State changes
    @Test
    public void checkDefaultState(){
        AbstractBacklogItemState state = backlogItem.getState();
        assertEquals(InBacklogState.class, state.getClass());
    }

    @Test
    public void checkStateChanges_Backlog_Forward(){
        backlogItem.moveForward();
        AbstractBacklogItemState state = backlogItem.getState();
        assertEquals(ToDoState.class, state.getClass());
    }
    @Test
    public void checkStateChanges_Backlog_Backward(){
        backlogItem.moveBackward();
        AbstractBacklogItemState state = backlogItem.getState();
        assertEquals(InBacklogState.class, state.getClass());
    }

    @Test
    public void checkStateChanges_ToDo_Forward(){
        backlogItem.setState(new ToDoState());
        backlogItem.moveForward();
        AbstractBacklogItemState state = backlogItem.getState();
        assertEquals(DoingState.class, state.getClass());
    }

    @Test
    public void checkStateChanges_ToDo_Backward(){
        backlogItem.setState(new ToDoState());
        backlogItem.moveBackward();
        AbstractBacklogItemState state = backlogItem.getState();
        assertEquals(InBacklogState.class, state.getClass());
    }

    @Test
    public void checkStateChanges_Doing_Forward_Done(){
        backlogItem.setState(new DoingState());
        backlogItem.addTask(task1);
        backlogItem.addTask(task2);

        task1.setIsFinished(true);
        task2.setIsFinished(true);
        backlogItem.moveForward();
        AbstractBacklogItemState state = backlogItem.getState();
        assertEquals(ReadyForTestingState.class, state.getClass());
    }
    @Test
    public void checkStateChanges_Doing_Forward_NotDone(){
        backlogItem.setState(new DoingState());
        task1.setIsFinished(false);
        task2.setIsFinished(false);
        backlogItem.moveForward();
        AbstractBacklogItemState state = backlogItem.getState();
        assertEquals(DoingState.class, state.getClass());
    }

    @Test
    public void checkStateChanges_Doing_Backward(){
        backlogItem.setState(new DoingState());
        backlogItem.moveBackward();
        AbstractBacklogItemState state = backlogItem.getState();
        assertEquals(DoingState.class, state.getClass());
    }

    @Test
    public void checkStateChanges_ReadyForTesting_Forward(){
        backlogItem.setState(new ReadyForTestingState());
        backlogItem.moveForward();
        AbstractBacklogItemState state = backlogItem.getState();
        assertEquals(TestingState.class, state.getClass());
    }

    @Test
    public void checkStateChanges_ReadyForTesting_Backward(){
        backlogItem.setState(new ReadyForTestingState());
        backlogItem.moveBackward();
        AbstractBacklogItemState state = backlogItem.getState();
        assertEquals(ReadyForTestingState.class, state.getClass());
    }

    @Test
    public void checkStateChanges_Testing_Forward(){
        backlogItem.setState(new TestingState());
        backlogItem.moveForward();
        AbstractBacklogItemState state = backlogItem.getState();
        assertEquals(TestedState.class, state.getClass());
    }

    @Test
    public void checkStateChanges_Testing_Backward(){
        backlogItem.setState(new TestingState());
        backlogItem.moveBackward();
        AbstractBacklogItemState state = backlogItem.getState();
        assertEquals(ToDoState.class, state.getClass());
    }


    @Test
    public void checkStateChanges_Tested_Forward(){
        backlogItem.setState(new TestedState());
        backlogItem.moveForward();
        AbstractBacklogItemState state = backlogItem.getState();
        assertEquals(DoneState.class, state.getClass());
    }

    @Test
    public void checkStateChanges_Tested_Backward(){
        backlogItem.setState(new TestedState());
        backlogItem.moveBackward();
        AbstractBacklogItemState state = backlogItem.getState();
        assertEquals(ReadyForTestingState.class, state.getClass());
    }

    @Test
    public void checkStateChanges_Done_Forward(){
        backlogItem.setState(new DoneState());
        backlogItem.moveForward();
        AbstractBacklogItemState state = backlogItem.getState();
        assertEquals(DoneState.class, state.getClass());
    }

    @Test
    public void checkStateChanges_Done_Backward(){
        backlogItem.setState(new DoneState());
        backlogItem.moveBackward();
        AbstractBacklogItemState state = backlogItem.getState();
        assertEquals(DoneState.class, state.getClass());
    }

    //Info Changes

    @Test
    public void checkInfoChanges_InBacklog(){
        backlogItem.setState(new InBacklogState());
        backlogItem.changeName("Lorem");
        backlogItem.changeDescription("Ipsum");
        assertEquals("Lorem",backlogItem.getName());
        assertEquals("Ipsum", backlogItem.getDescription());
    }

    @Test
    public void checkInfoChanges_ToDo(){
        backlogItem.setState(new ToDoState());
        backlogItem.changeName("Lorem");
        backlogItem.changeDescription("Ipsum");
        assertEquals("Test",backlogItem.getName());
        assertEquals("Ipsum", backlogItem.getDescription());
    }

    @Test
    public void checkInfoChanges_Doing(){
        backlogItem.setState(new DoingState());
        backlogItem.changeName("Lorem");
        backlogItem.changeDescription("Ipsum");
        assertEquals("Test",backlogItem.getName());
        assertEquals("TestDesc", backlogItem.getDescription());
    }

    @Test
    public void checkInfoChanges_ReadyForTesting(){
        backlogItem.setState(new ReadyForTestingState());
        backlogItem.changeName("Lorem");
        backlogItem.changeDescription("Ipsum");
        assertEquals("Test",backlogItem.getName());
        assertEquals("TestDesc", backlogItem.getDescription());
    }

    @Test
    public void checkInfoChanges_Testing(){
        backlogItem.setState(new TestingState());
        backlogItem.changeName("Lorem");
        backlogItem.changeDescription("Ipsum");
        assertEquals("Test",backlogItem.getName());
        assertEquals("TestDesc", backlogItem.getDescription());
    }

    @Test
    public void checkInfoChanges_Tested(){
        backlogItem.setState(new TestedState());
        backlogItem.changeName("Lorem");
        backlogItem.changeDescription("Ipsum");
        assertEquals("Test",backlogItem.getName());
        assertEquals("TestDesc", backlogItem.getDescription());
    }

    @Test
    public void checkInfoChanges_Done(){
        backlogItem.setState(new DoneState());
        backlogItem.changeName("Lorem");
        backlogItem.changeDescription("Ipsum");
        assertEquals("Test",backlogItem.getName());
        assertEquals("TestDesc", backlogItem.getDescription());
    }

    //Change Tasks

    @Test
    public void checkTaskAdded_InBacklog(){
        backlogItem.setState(new InBacklogState());
        backlogItem.changeTasksAdd(task1);
        backlogItem.changeTasksAdd(task2);
        assertEquals(2, backlogItem.getTasks().size());
        assertTrue(backlogItem.getTasks().contains(task1));
        assertTrue(backlogItem.getTasks().contains(task2));
    }

    @Test
    public void checkTaskAdded_ToDo(){
        backlogItem.setState(new ToDoState());
        backlogItem.changeTasksAdd(task1);
        backlogItem.changeTasksAdd(task2);
        assertEquals(2, backlogItem.getTasks().size());
        assertTrue(backlogItem.getTasks().contains(task1));
        assertTrue(backlogItem.getTasks().contains(task2));
    }

    @Test
    public void checkTaskAdded_Doing(){
        backlogItem.setState(new DoingState());
        backlogItem.changeTasksAdd(task1);
        backlogItem.changeTasksAdd(task2);
        assertEquals(0, backlogItem.getTasks().size());
        assertFalse(backlogItem.getTasks().contains(task1));
        assertFalse(backlogItem.getTasks().contains(task2));
    }

    @Test
    public void checkTaskAdded_ReadyForTesting(){
        backlogItem.setState(new ReadyForTestingState());
        backlogItem.changeTasksAdd(task1);
        backlogItem.changeTasksAdd(task2);
        assertEquals(0, backlogItem.getTasks().size());
        assertFalse(backlogItem.getTasks().contains(task1));
        assertFalse(backlogItem.getTasks().contains(task2));
    }

    @Test
    public void checkTaskAdded_Testing(){
        backlogItem.setState(new TestingState());
        backlogItem.changeTasksAdd(task1);
        backlogItem.changeTasksAdd(task2);
        assertEquals(0, backlogItem.getTasks().size());
        assertFalse(backlogItem.getTasks().contains(task1));
        assertFalse(backlogItem.getTasks().contains(task2));
    }

    @Test
    public void checkTaskAdded_Tested(){
        backlogItem.setState(new TestedState());
        backlogItem.changeTasksAdd(task1);
        backlogItem.changeTasksAdd(task2);
        assertEquals(0, backlogItem.getTasks().size());
        assertFalse(backlogItem.getTasks().contains(task1));
        assertFalse(backlogItem.getTasks().contains(task2));
    }

    @Test
    public void checkTaskAdded_Done(){
        backlogItem.setState(new DoneState());
        backlogItem.changeTasksAdd(task1);
        backlogItem.changeTasksAdd(task2);
        assertEquals(0, backlogItem.getTasks().size());
        assertFalse(backlogItem.getTasks().contains(task1));
        assertFalse(backlogItem.getTasks().contains(task2));
    }

    @Test
    public void checkTaskRemoved_InBacklog(){
        backlogItem.setState(new InBacklogState());
        backlogItem.addTask(task1);
        backlogItem.addTask(task2);
        assertTrue(backlogItem.getTasks().contains(task1));
        assertTrue(backlogItem.getTasks().contains(task2));

        backlogItem.changeTasksRemove(task1);
        backlogItem.changeTasksRemove(task2);
        assertEquals(0, backlogItem.getTasks().size());
        assertFalse(backlogItem.getTasks().contains(task1));
        assertFalse(backlogItem.getTasks().contains(task2));
    }

    @Test
    public void checkTaskRemoved_ToDo(){
        backlogItem.setState(new ToDoState());
        backlogItem.addTask(task1);
        backlogItem.addTask(task2);
        assertTrue(backlogItem.getTasks().contains(task1));
        assertTrue(backlogItem.getTasks().contains(task2));

        backlogItem.changeTasksRemove(task1);
        backlogItem.changeTasksRemove(task2);
        assertEquals(0, backlogItem.getTasks().size());
        assertFalse(backlogItem.getTasks().contains(task1));
        assertFalse(backlogItem.getTasks().contains(task2));
    }

    @Test
    public void checkTaskRemoved_Doing(){
        backlogItem.setState(new DoingState());
        backlogItem.addTask(task1);
        backlogItem.addTask(task2);

        backlogItem.changeTasksRemove(task1);
        backlogItem.changeTasksRemove(task2);
        assertEquals(2, backlogItem.getTasks().size());
        assertTrue(backlogItem.getTasks().contains(task1));
        assertTrue(backlogItem.getTasks().contains(task2));
    }

    @Test
    public void checkTaskRemoved_ReadyForTesting(){
        backlogItem.setState(new ReadyForTestingState());
        backlogItem.addTask(task1);
        backlogItem.addTask(task2);

        backlogItem.changeTasksRemove(task1);
        backlogItem.changeTasksRemove(task2);
        assertEquals(2, backlogItem.getTasks().size());
        assertTrue(backlogItem.getTasks().contains(task1));
        assertTrue(backlogItem.getTasks().contains(task2));
    }

    @Test
    public void checkTaskRemoved_Testing(){
        backlogItem.setState(new TestingState());
        backlogItem.addTask(task1);
        backlogItem.addTask(task2);

        backlogItem.changeTasksRemove(task1);
        backlogItem.changeTasksRemove(task2);
        assertEquals(2, backlogItem.getTasks().size());
        assertTrue(backlogItem.getTasks().contains(task1));
        assertTrue(backlogItem.getTasks().contains(task2));
    }

    @Test
    public void checkTaskRemoved_Tested(){
        backlogItem.setState(new TestedState());
        backlogItem.addTask(task1);
        backlogItem.addTask(task2);

        backlogItem.changeTasksRemove(task1);
        backlogItem.changeTasksRemove(task2);
        assertEquals(2, backlogItem.getTasks().size());
        assertTrue(backlogItem.getTasks().contains(task1));
        assertTrue(backlogItem.getTasks().contains(task2));
    }

    @Test
    public void checkTaskRemoved_Done(){
        backlogItem.setState(new DoneState());
        backlogItem.addTask(task1);
        backlogItem.addTask(task2);

        backlogItem.changeTasksRemove(task1);
        backlogItem.changeTasksRemove(task2);
        assertEquals(2, backlogItem.getTasks().size());
        assertTrue(backlogItem.getTasks().contains(task1));
        assertTrue(backlogItem.getTasks().contains(task2));
    }

    @Test
    public void checkGetDevelopersToNotify(){
        task1.setIsFinished(true);
        task2.setIsFinished(true);
        task1.setCurrentDeveloper(developer1);
        task2.setCurrentDeveloper(developer2);

        backlogItem.addTask(task1);
        backlogItem.addTask(task2);
        //InBacklog

        assertFalse(backlogItem.getDevelopersToNotify().contains(developer2));
        assertFalse(backlogItem.getDevelopersToNotify().contains(developer1));

        backlogItem.moveForward();
        //ToDoState
        assertFalse(backlogItem.getDevelopersToNotify().contains(developer2));
        assertFalse(backlogItem.getDevelopersToNotify().contains(developer1));

        //Backstep
        backlogItem.moveBackward();
        assertFalse(backlogItem.getDevelopersToNotify().contains(developer2));
        assertFalse(backlogItem.getDevelopersToNotify().contains(developer1));
        backlogItem.moveForward();
        backlogItem.moveForward();
        //Doing
        assertFalse(backlogItem.getDevelopersToNotify().contains(developer2));
        assertFalse(backlogItem.getDevelopersToNotify().contains(developer1));
        backlogItem.moveForward();

        //ReadyForTesting
        assertTrue(backlogItem.getDevelopersToNotify().contains(developer2));
        assertFalse(backlogItem.getDevelopersToNotify().contains(developer1));
        backlogItem.moveForward();
        //Testing
        assertFalse(backlogItem.getDevelopersToNotify().contains(developer2));
        assertFalse(backlogItem.getDevelopersToNotify().contains(developer1));
        //Backstep
        backlogItem.moveBackward();
        assertFalse(backlogItem.getDevelopersToNotify().contains(developer2));
        assertTrue(backlogItem.getDevelopersToNotify().contains(developer1));
        backlogItem.moveForward();
        backlogItem.moveForward();
        backlogItem.moveForward();
        backlogItem.moveForward();

        //Tested
        assertFalse(backlogItem.getDevelopersToNotify().contains(developer2));
        assertFalse(backlogItem.getDevelopersToNotify().contains(developer1));

        //Backstep
        backlogItem.moveBackward();
        assertFalse(backlogItem.getDevelopersToNotify().contains(developer2));
        assertTrue(backlogItem.getDevelopersToNotify().contains(developer1));
        backlogItem.moveForward();
        backlogItem.moveForward();
        backlogItem.moveForward();
        //Done
        assertFalse(backlogItem.getDevelopersToNotify().contains(developer2));
        assertFalse(backlogItem.getDevelopersToNotify().contains(developer1));
    }



}
