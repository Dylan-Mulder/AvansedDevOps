import domain.*;
import domain.builders.cicd.PipelineBuilder;
import domain.builders.cicd.PipelineDirector;
import domain.builders.sprint.SprintBuilder;
import domain.builders.sprint.SprintDirector;
import domain.composites.cicd.Pipeline;
import domain.observers.backlog_item.ForumThread;
import domain.observers.backlog_item.Mailer;
import domain.visitors.cicd.ExecuteVisitor;

public class Main {
    public static void main(String[] args) {
        Developer developer1 = new Developer("Tim", "Project Leader", true, false);
        Developer developer2 = new Developer("Dylan", "Tester", false, true);

        Task task1 = new Task("Feature 1", "Lead Item");
        Task task2 = new Task("Feature 2", "Use JUnit");

        task1.setCurrentDeveloper(developer1);
        task2.setCurrentDeveloper(developer2);

        BacklogItem backlogItem = new BacklogItem("Test1", "TestDesc1");
        backlogItem.changeTasksAdd(task1);
        backlogItem.changeTasksAdd(task2);

        Project project = new Project(developer1);
        project.addDeveloper(developer1);
        project.addDeveloper(developer2);
        project.addBacklogItem(backlogItem);

        //Sprint
        SprintBuilder sprintBuilder = new SprintBuilder();
        SprintDirector sprintDirector = new SprintDirector();
        sprintDirector.buildStandardReleaseSprint(sprintBuilder);
        Sprint sprint = sprintBuilder.build();
        sprint.addDeveloper(developer1);
        sprint.addDeveloper(developer2);

        //Project
        project.addSprint(sprint);
        sprint = project.getSprints().get(0);
        backlogItem= project.getBacklogItems().get(0);

        sprint.addBacklogItem(backlogItem);
        project.getBacklogItems().remove(backlogItem);
        backlogItem.moveForward();

        //Observer subscribers:
        Mailer mailer = new Mailer(backlogItem);
        ForumThread forumThread = new ForumThread(backlogItem);
        backlogItem.getPublisher().subscribe(mailer);
        backlogItem.getPublisher().subscribe(forumThread);

        String report = project.sprintReport(sprint,"Avans");
        project.exportReport(report,"System");

        //Sprint states
        System.out.println("Current Sprint State: ");
        System.out.println(sprint.getState().getStateName());
        sprint.setNameState("FirstRelease");
        System.out.println("Sprint name set to: "+sprint.getName());
        sprint.start();
        sprint.setNameState("Oops I forgot something!");

        backlogItem.moveForward();//Doing
        backlogItem.getTasks().get(0).setIsFinished(true);
        backlogItem.getTasks().get(1).setIsFinished(true);
        backlogItem.moveForward();//ReadyForTesting --> subscribers are called

        System.out.println("Amount of mails sent to testers: "+mailer.getReceivers().size());
        System.out.println("Post added to ForumThread: "+forumThread.getThreadPosts().get(0).getContent());

        backlogItem.moveForward();//Testing
        backlogItem.moveForward();//Tested
        backlogItem.moveForward();//Done

        sprint.performFinish();
    }
}
