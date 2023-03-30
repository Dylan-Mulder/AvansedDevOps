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
    public void setTitle(String title) {
        sprint.setTitle(title);
    }
    @Override
    public void setDescription(String description) {
        sprint.setTitle(description);
    }


    @Override
    public void addBacklogItem(BacklogItem backlogItem) {
        sprint.getBacklogItems().add(backlogItem);
    }
    @Override
    public void removeBacklogItem(BacklogItem backlogItem) {
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
