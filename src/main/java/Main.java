import domain.BacklogItem;
import domain.Sprint;
import domain.builders.sprint.Director;
import domain.builders.sprint.IBuilder;
import domain.builders.sprint.SprintBuilder;

public class Main {
    public static void main(String[] args) {
        Director director = new Director();

        SprintBuilder builder = new SprintBuilder();
        director.buildLongReleaseSprint(builder);
        Sprint sprint = builder.build();

        System.out.println(sprint.getName() + " | " + sprint.getDescription());
        System.out.println(sprint.getStartDate());
        System.out.println(sprint.getEndDate());
    }
}
