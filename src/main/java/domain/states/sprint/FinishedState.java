package domain.states.sprint;

import domain.BacklogItem;
import domain.Sprint;

import java.util.logging.Level;

public class FinishedState extends AbstractSprintState {
    /* ATTRIBUTES */

    /* CONSTRUCTORS */
    public FinishedState(Sprint sprint) {
        super(sprint);
    }



    /* GETTERS */
    public String getStateName(){
        return "Finished";
    }
    /* SETTERS */

    /* METHODS */
    public void start() {
        logger.log(Level.WARNING, "Can't restart a finished sprint!");
    }

    public void performFinish() {
        logger.log(Level.WARNING, "Sprint has already finished.");
    }
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
}
