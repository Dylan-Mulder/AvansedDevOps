package domain.states.sprint;

import domain.BacklogItem;
import domain.Sprint;

import java.util.logging.Level;

public class NotStartedState extends AbstractSprintState {
    /* ATTRIBUTES */

    /* CONSTRUCTORS */
    public NotStartedState(Sprint sprint) {
        super(sprint);
    }





    /* GETTERS */

    /* SETTERS */
    @Override
    public void setName(String name) {
        sprint.setName(name);
    }
    @Override
    public void setDescription(String description) {
        sprint.setName(description);
    }


    @Override
    public void addBacklogItem(BacklogItem backlogItem) {
        backlogItem.setCurrentSprint(sprint);
        sprint.getBacklogItems().add(backlogItem);
    }
    @Override
    public void removeBacklogItem(BacklogItem backlogItem) {
        backlogItem.setCurrentSprint(null);
        sprint.getBacklogItems().remove(backlogItem);
    }

    /* METHODS */
    public void start() {
        sprint.setState(new OngoingState(sprint));
    }

    public void performFinish() {
        logger.log(Level.WARNING, "Can't finish a sprint when it hasn't started yet!");
    }

}
