package domain.composites.cicd;

import domain.visitors.cicd.AbstractVisitor;

import java.util.ArrayList;

public class Command extends AbstractComponent {
    /* ATTRIBUTES */
    private ArrayList<String> outputLines = new ArrayList<>();

    /* CONSTRUCTORS */
    public Command(String name) {
        setName(name);
    }

    /* GETTERS */
    public ArrayList<String> getOutputLines() {
        return outputLines;
    }
    /* SETTERS */
    public void addOutputLine(String outputLine) {
        outputLines.add(outputLine);
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
