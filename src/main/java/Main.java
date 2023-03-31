import domain.composites.cicd.Command;
import domain.composites.cicd.Job;
import domain.composites.cicd.Pipeline;
import domain.composites.cicd.Stage;
import domain.visitors.cicd.ExecuteVisitor;

public class Main {
    public static void main(String[] args) {
        Pipeline pipeline = new Pipeline("Pipeline 1");

        Stage stage1 = new Stage("Stage 1", "Testing Stage");
        pipeline.addComponent(stage1);
        Stage stage2 = new Stage("Stage 2", "Deployment Stage");
        pipeline.addComponent(stage2);

        Job job1 = new Job("Job 1");
        stage1.addComponent(job1);
        Job job2 = new Job("Job 2");
        stage1.addComponent(job2);

        Job job3 = new Job("Job 3", "Both Commands!");
        stage2.addComponent(job3);
        Job job4 = new Job("Job 4", "Really weird Job....");
        stage2.addComponent(job4);

        Command command1 = new Command("Alphabet");
        command1.addOutputLine("a");
        command1.addOutputLine("b");
        command1.addOutputLine("c");
        Command command2 = new Command("Numbers");
        command2.addOutputLine("1");
        command2.addOutputLine("2");
        command2.addOutputLine("3");
        command2.addOutputLine("4");
        command2.addOutputLine("5");
        command2.addOutputLine("6");
        command2.addOutputLine("7");
        command2.addOutputLine("8");
        command2.addOutputLine("9");
        command2.addOutputLine("10");

        job1.addComponent(command1);

        job2.addComponent(command2);

        job3.addComponent(command1);
        job3.addComponent(command2);

        ExecuteVisitor visitor = new ExecuteVisitor();
        pipeline.acceptVisitor(visitor);
    }
}
