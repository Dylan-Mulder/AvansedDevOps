package domain;

import domain.states.backlogItem.AbstractBacklogItemState;
import domain.states.backlogItem.InBacklogState;
import domain.states.sprint.AbstractSprintState;
import domain.states.sprint.NotStartedState;
import domain.strategies.sprint.IFinishBehaviour;

import java.util.ArrayList;

public class Sprint {
    /* ATTRIBUTES */
    private String name;
    private String description;
    private AbstractSprintState state = new NotStartedState();
    private ArrayList<BacklogItem> backlogItems = new ArrayList<>();
    private ArrayList<Developer> developers = new ArrayList<>();
    private IFinishBehaviour finishBehaviour;
    private int duration;
    private Developer scrumMaster;

    /* CONSTRUCTORS */

    public Sprint() {}
    /* GETTERS */
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public AbstractSprintState getState() {
        return state;
    }
    public ArrayList<BacklogItem> getBacklogItems() {
        return backlogItems;
    }
    public ArrayList<Developer> getDevelopers() {
        return developers;
    }
    public IFinishBehaviour getFinishBehaviour() {
        return finishBehaviour;
    }
    public int getDuration() {
        return duration;
    }
    public Developer getScrumMaster() {
        return scrumMaster;
    }

    /* SETTERS */
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setState(AbstractSprintState state) {
        this.state = state;
    }
    public void addBacklogItem(BacklogItem backlogItem) {
        backlogItems.add(backlogItem);
    }
    public void removeBacklogItem(BacklogItem backlogItem) {
        backlogItems.remove(backlogItem);
    }
    public void addDeveloper(Developer developer) {
        developers.add(developer);
    }
    public void removeDeveloper(Developer developer) {
        developers.remove(developer);
    }
    public void setFinishBehaviour(IFinishBehaviour finishBehaviour) {
        this.finishBehaviour = finishBehaviour;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setScrumMaster(Developer scrumMaster) {
        this.scrumMaster = scrumMaster;
    }

    /* METHODS */
    // State Methods
    public void start() {
        state.start(this);
    }
    public void performFinish() {
        state.performFinish(this);
    }
}
