import domain.BacklogItem;
import domain.Developer;
import domain.Sprint;
import domain.Task;
import domain.builders.sprint.SprintBuilder;
import domain.builders.sprint.SprintDirector;
import domain.observers.backlogItem.ForumThread;
import domain.observers.backlogItem.Mailer;
import domain.observers.backlogItem.Publisher;
import domain.states.backlogItem.DoingState;
import domain.states.backlogItem.ReadyForTestingState;
import domain.states.backlogItem.ToDoState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ObserverBacklogItemTests {
    /* ATTRIBUTES */
    BacklogItem backlogItem;
    Task task1;
    Task task2;
    Developer developer1;
    Developer developer2;
    Sprint sprint;
    SprintDirector director;
    SprintBuilder sprintBuilder;
    Mailer mailer;
    ForumThread forumThread;

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
        developer1 = new Developer("developer1","Tester", true, false);
        developer2 = new Developer("developer2","Tester", false, true);


        mailer = new Mailer(backlogItem);
        forumThread = new ForumThread(backlogItem);

        sprint.addDeveloper(developer1);
        sprint.addDeveloper(developer2);
        sprint.addBacklogItem(backlogItem);

    }

    @AfterEach
    public void resetMockData(){
        setupMockData();
    }

    @Test
    public void checkSubscribe(){
        assertEquals(0,backlogItem.getPublisher().getSubscribers().size());
        backlogItem.getPublisher().subscribe(mailer);
        backlogItem.getPublisher().subscribe(forumThread);
        assertEquals(2,backlogItem.getPublisher().getSubscribers().size());
        assertTrue(backlogItem.getPublisher().getSubscribers().contains(mailer));
        assertTrue(backlogItem.getPublisher().getSubscribers().contains(forumThread));
    }

    @Test public void checkUnsubscribe(){
        backlogItem.getPublisher().subscribe(mailer);
        backlogItem.getPublisher().subscribe(forumThread);
        assertEquals(2,backlogItem.getPublisher().getSubscribers().size());
        backlogItem.getPublisher().unsubscribe(mailer);
        assertEquals(1,backlogItem.getPublisher().getSubscribers().size());
        assertFalse(backlogItem.getPublisher().getSubscribers().contains(mailer));
        assertTrue(backlogItem.getPublisher().getSubscribers().contains(forumThread));
    }

    @Test
    public void checkNotifySubscribers(){
        backlogItem.getPublisher().subscribe(mailer);
        backlogItem.getPublisher().subscribe(forumThread);

        task1.setIsFinished(true);
        task1.setCurrentDeveloper(developer1);
        task2.setIsFinished(true);
        task2.setCurrentDeveloper(developer2);
        backlogItem.addTask(task1);
        backlogItem.addTask(task2);

        assertEquals(0,forumThread.getThreadPosts().size());

        backlogItem.setState(new DoingState());
        backlogItem.moveForward();

        assertEquals(1,mailer.getReceivers().size());
        assertTrue(mailer.getReceivers().contains(developer2));
        assertFalse(mailer.getReceivers().contains(developer1));
        assertEquals(1,forumThread.getThreadPosts().size());
    }



}
