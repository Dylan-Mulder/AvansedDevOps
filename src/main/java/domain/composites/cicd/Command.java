package domain.composites.cicd;

import domain.visitors.cicd.AbstractVisitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Command extends AbstractComponent {
    /* ATTRIBUTES */
    private final ArrayList<String> outputLines = new ArrayList<>();

    /* CONSTRUCTORS */
    public Command(String name, String[] outputLines) {
        setName(name);
        bulkAddOutputLines(outputLines);
    }

    /* GETTERS */
    public List<String> getOutputLines() {
        return outputLines;
    }
    /* SETTERS */
    public void addOutputLine(String outputLine) {
        outputLines.add(outputLine);
    }
    public void bulkAddOutputLines(String[] toBeAddedOutputLines) {
        outputLines.addAll(Arrays.asList(toBeAddedOutputLines));
    }
    public void removeOutputLine(String outputLine) {
        outputLines.remove(outputLine);
    }

    /* METHODS */
    @Override
    public void acceptVisitor(AbstractVisitor visitor) {
        visitor.visitCommand(this);
    }
}
