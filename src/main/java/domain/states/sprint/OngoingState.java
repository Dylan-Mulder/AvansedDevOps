package domain.states.sprint;

import domain.BacklogItem;
import domain.Sprint;

import java.util.logging.Level;

public class OngoingState extends AbstractSprintState {
    /* ATTRIBUTES */

    /* CONSTRUCTORS */
    public OngoingState(Sprint sprint) {
        super(sprint);
    }



    /* GETTERS */
    public String getStateName(){
        return "Ongoing";
    }
    /* SETTERS */
    @Override
    public void setName(String name) {
        logger.log(Level.WARNING, "Can't update information of a sprint after it's started!");
    }
    @Override
    public void setDescription(String description) {
        logger.log(Level.WARNING, "Can't update information of a sprint after it's started!");
    }
    @Override
    public void addBacklogItem(BacklogItem backlogItem) {
        logger.log(Level.WARNING, "Can't add backlog items to a sprint after it's started!");
    }

    @Override
    public void removeBacklogItem(BacklogItem backlogItem) {
        logger.log(Level.WARNING, "Can't remove backlog items from a sprint after it's started!");
    }

    /* METHODS */
    public void start() {
        logger.log(Level.WARNING, "Sprint has already started!");
    }

    public void performFinish() {
        sprint.getFinishBehaviour().performFinish();
        sprint.setState(new FinishedState(sprint));
    }
}
