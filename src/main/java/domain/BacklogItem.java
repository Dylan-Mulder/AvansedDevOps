package domain;

import domain.states.backlogItem.IBacklogItemState;
import domain.states.backlogItem.InBacklogState;

import java.util.ArrayList;

public class BacklogItem {
    /* ATTRIBUTES */
    private String name;
    private String description;
    private IBacklogItemState state = new InBacklogState();
    private ArrayList<Task> tasks = new ArrayList<>();

    /* CONSTRUCTORS */
    public BacklogItem(String name, String description) {
        this.name = name;
        this.description = description;
    }
    /* GETTERS */
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public IBacklogItemState getState() {
        return state;
    }
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /* SETTERS */
    public void setName(String name) {
        state.setName(this, name);
    }
    public void setDescription(String description) {
        state.setDescription(this, description);
    }
    public void setState(IBacklogItemState state) {
        this.state = state;
    }
    public void addTask(Task task) {
        state.addTask(this, task);
    }
    public void removeTask(Task task) {
        state.removeTask(this, task);
    }

    /* METHODS */
    public void moveForward() {
        state.moveForward(this);
    }
    public void moveBackward() {
        state.moveBackward((this));
    }
}
