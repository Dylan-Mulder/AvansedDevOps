package domain;

public class Task {
    /* ATTRIBUTES */
    private String name;
    private String description;
    private Developer currentDeveloper;
    private boolean isFinished;

    /* CONSTRUCTORS */
    public Task(String name, String description, Developer currentDeveloper, boolean finished) {
        this.name = name;
        this.description = description;
        this.currentDeveloper = currentDeveloper;
        this.isFinished = finished;
    }

    /* GETTERS */
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Developer getCurrentDeveloper() {
        return currentDeveloper;
    }
    public boolean isFinished() {
        return isFinished;
    }

    /* SETTERS */
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCurrentDeveloper(Developer currentDeveloper) {
        this.currentDeveloper = currentDeveloper;
    }
    public void setFinished(boolean finished) {
        this.isFinished = finished;
    }

    /* METHODS */
}
