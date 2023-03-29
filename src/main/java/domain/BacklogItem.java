package domain;

import domain.states.backlogItem.AbstractBacklogItemState;
import domain.states.backlogItem.InBacklogState;

import java.util.ArrayList;

public class BacklogItem {
    /* ATTRIBUTES */
    private String name;
    private String description;
    private AbstractBacklogItemState state = new InBacklogState();
    private final ArrayList<Task> tasks = new ArrayList<>();

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
    public AbstractBacklogItemState getState() {
        return state;
    }
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /* SETTERS */
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setState(AbstractBacklogItemState state) {
        this.state = state;
    }
    public void addTask(Task task) {
        tasks.add(task);
    }
    public void removeTask(Task task) {
        tasks.remove(task);
    }

    /* METHODS */
    // State Methods
    public void changeName(String name) {
        state.changeName(this, name);
    }
    public void changeDescription(String description) {
        state.changeDescription(this, name);
    }
    public void changeTasksAdd(Task task) {
        state.changeTasksAdd(this, task);
    }
    public void changeTasksRemove(Task task) {
        state.changeTasksRemove(this, task);
    }
    public void moveForward() {
        state.moveForward(this);
    }
    public void moveBackward() {
        state.moveBackward((this));
    }
}
