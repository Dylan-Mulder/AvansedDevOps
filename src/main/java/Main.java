import domain.composites.cicd.Command;
import domain.composites.cicd.Job;
import domain.composites.cicd.Pipeline;
import domain.composites.cicd.Stage;

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

        job1.addComponent(new Command("Command 1"));
        job1.addComponent(new Command("Command 2"));

        job2.addComponent(new Command("Command 3"));
        job2.addComponent(new Command("Command 4"));

        job3.addComponent(new Command("Command 5"));
        job3.addComponent(new Command("Command 6"));

        job4.addComponent(new Command("Command 7"));
        job4.addComponent(new Command("Command 8"));

        System.out.println(pipeline.getComponent(0).getName());
    }
}
