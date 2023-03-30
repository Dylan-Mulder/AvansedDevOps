import domain.composites.cicd.Command;
import domain.composites.cicd.Job;
import domain.composites.cicd.Pipeline;
import domain.composites.cicd.Stage;
import domain.visitors.cicd.ExecuteVisitor;

public class Main {
    public static void main(String[] args) {
        Pipeline pipeline = new Pipeline("Pipeline 1");

        Stage stage1 = new Stage("Stage 1");
        pipeline.addComponent(stage1);
        Stage stage2 = new Stage("Stage 2");
        pipeline.addComponent(stage2);

        Job job1 = new Job("Job 1");
        stage1.addComponent(job1);
        Job job2 = new Job("Job 2");
        stage1.addComponent(job2);

        Job job3 = new Job("Job 3");
        stage2.addComponent(job3);
        Job job4 = new Job("Job 4");
        stage2.addComponent(job4);

        job1.addComponent(new Command("Command 1", "This is skrrrtt"));
        job1.addComponent(new Command("Command 2", "This is braaap"));

        job2.addComponent(new Command("Command 3", "This is prguguu"));
        job2.addComponent(new Command("Command 4", "This is 81239876124"));

        job3.addComponent(new Command("Command 5", "This is [][][][][][]]"));
        job3.addComponent(new Command("Command 6", "This is AA@W#!@#!@"));

        job4.addComponent(new Command("Command 7", "This is jup"));
        job4.addComponent(new Command("Command 8", "This is verse noten"));

        ExecuteVisitor visitor = new ExecuteVisitor();
        pipeline.acceptVisitor(visitor);
    }
}
