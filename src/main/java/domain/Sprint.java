package domain;

import domain.states.sprint.AbstractSprintState;
import domain.states.sprint.NotStartedState;
import domain.strategies.sprint.AbstractFinishBehaviour;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Sprint {
    /* ATTRIBUTES */
    private String name;
    private String description;
    private AbstractSprintState state = new NotStartedState(this);
    private final ArrayList<BacklogItem> backlogItems = new ArrayList<>();
    private final ArrayList<Developer> developers = new ArrayList<>();
    private AbstractFinishBehaviour finishBehaviour;
    private int duration;
    private LocalDate startDate;
    private LocalDate endDate;
    private Developer scrumMaster;

    /* CONSTRUCTORS */
    public Sprint() {
        // Builder Pattern
    }

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
    public List<BacklogItem> getBacklogItems() {
        return backlogItems;
    }
    public List<Developer> getDevelopers() {
        return developers;
    }
    public AbstractFinishBehaviour getFinishBehaviour() {
        return finishBehaviour;
    }
    public int getDuration() {
        return duration;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
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
    public void setName(String name) {
        this.name = name;
    }
    public void setNameState(String name){
        this.state.setName(name);
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDescriptionState(String description){
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
    public void setFinishBehaviour(AbstractFinishBehaviour finishBehaviour) {
        this.finishBehaviour = finishBehaviour;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                performFinish();
            }
        }, Date.from(endDate
            .atStartOfDay(ZoneId.systemDefault())
            .toInstant()));
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
