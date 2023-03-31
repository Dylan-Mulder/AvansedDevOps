package domain.visitors.cicd;

import domain.composites.cicd.*;
import domain.utils.ConsoleColours;

public class ExecuteVisitor extends AbstractVisitor {
    /* ATTRIBUTES */

    /* CONSTRUCTORS */
    public ExecuteVisitor() {}

    /* GETTERS */

    /* SETTERS */

    /* METHODS */
    @Override
    public void visitPipeline(Pipeline pipeline) {
        System.out.println(ConsoleColours.YELLOW_BOLD + "/\\/\\/\\ " + ConsoleColours.BLUE_UNDERLINED + "EXECUTING PIPELINE: " + pipeline.getName().toUpperCase() + ConsoleColours.RESET + ConsoleColours.YELLOW_BOLD + " /\\/\\/\\");
        System.out.print("\n");
    }

    @Override
    public void visitStage(Stage stage) {
        System.out.print("\n");
        System.out.print(ConsoleColours.YELLOW_BRIGHT + "[ " + ConsoleColours.BLUE_BRIGHT + stage.getName() + ConsoleColours.YELLOW_BRIGHT + " ]");
        if (!stage.getDescription().isEmpty()) System.out.print(" | " + stage.getDescription());
        System.out.print("\n");
    }

    @Override
    public void visitJob(Job job) {
        System.out.print("\n");
        System.out.print(ConsoleColours.PURPLE_BRIGHT + "JOB --> " + ConsoleColours.RESET + job.getName());
        if (!job.getDescription().isEmpty()) System.out.println(" | " + job.getDescription());
        System.out.print("\n");
    }

    @Override
    public void visitCommand(Command command) {
        System.out.println("~~ EXECUTING COMMAND: " + command.getName());
        for (String outputLine : command.getOutputLines()) {
            System.out.println("~~ " + outputLine);
        }
        System.out.print("\n");
    }
}
