package domain;

import domain.states.sprint.AbstractSprintState;
import domain.states.sprint.NotStartedState;
import domain.strategies.sprint.IFinishBehaviour;

import java.util.ArrayList;

public class Sprint {
    /* ATTRIBUTES */
    private String title;
    private String description;
    private AbstractSprintState state = new NotStartedState(this);
    private final ArrayList<BacklogItem> backlogItems = new ArrayList<>();
    private final ArrayList<Developer> developers = new ArrayList<>();
    private IFinishBehaviour finishBehaviour;
    private int duration;
    private Developer scrumMaster;

    /* CONSTRUCTORS */

    public Sprint() {}
    /* GETTERS */
    public String getTitle() {
        return title;
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
    public void setState(AbstractSprintState state) {
        if (this.state != null) {
            this.state.dispose();
        }
        this.state = state;
    }
    public void setTitle(String title) {
        this.title=title;
    }
    public void setTitle_State(String title){
        this.state.setTitle(title);
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void  setDescription_State(String description){
        this.state.setDescription(description);
    }

    public void addBacklogItem(BacklogItem backlogItem) {
        this.state.addBacklogItem(backlogItem);
    }
    public void removeBacklogItem(BacklogItem backlogItem) {
        this.state.removeBacklogItem(backlogItem);
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
        state.start();
    }
    public void performFinish() {
        state.performFinish();
    }
}
