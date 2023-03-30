import domain.BacklogItem;
import domain.Sprint;
import domain.builders.sprint.Director;
import domain.builders.sprint.IBuilder;
import domain.builders.sprint.SprintBuilder;
import domain.composites.cicd.Command;
import domain.composites.cicd.Job;
import domain.composites.cicd.Pipeline;
import domain.composites.cicd.Stage;

public class Main {
    public static void main(String[] args) {
        Pipeline pipeline = new Pipeline();

        Stage stage1 = new Stage();
        pipeline.addComponent(stage1);
        Stage stage2 = new Stage();
        pipeline.addComponent(stage2);

        Job job1 = new Job();
        stage1.addComponent(job1);
        Job job2 = new Job();
        stage1.addComponent(job2);

        Job job3 = new Job();
        stage2.addComponent(job3);
        Job job4 = new Job();
        stage2.addComponent(job4);

        job1.addComponent(new Command());
        job1.addComponent(new Command());

        job2.addComponent(new Command());
        job2.addComponent(new Command());

        job3.addComponent(new Command());
        job3.addComponent(new Command());

        job4.addComponent(new Command());
        job4.addComponent(new Command());
    }
}
