package domain.states.backlogItem;

import domain.BacklogItem;
import domain.Developer;
import domain.Task;

import java.util.ArrayList;
import java.util.logging.Level;

public class DoingState extends AbstractBacklogItemState {

    public DoingState() {
        // Only create the Object
    }

    public void changeName(BacklogItem backlogItem, String name) {
        logger.log(Level.WARNING, "Can't change name while in state: Doing");
    }

    public void changeDescription(BacklogItem backlogItem, String description) {
        logger.log(Level.WARNING, "Can't change description while in state: Doing!");
    }

    public void changeTasksAdd(BacklogItem backlogItem, Task task) {
        logger.log(Level.WARNING, "Can't add tasks now while in state: Doing");
    }

    public void changeTasksRemove(BacklogItem backlogItem, Task task) {
        logger.log(Level.WARNING, "Can't remove tasks now while in state: Doing");
    }

    public void moveForward(BacklogItem backlogItem) {
        logger.log(Level.INFO, "Moved " + backlogItem.getName() + " to: Ready For Testing");
        boolean isFinished = !backlogItem.getTasks().isEmpty();
        for(Task task: backlogItem.getTasks()){
            if (!task.isFinished()) {
                isFinished = false;
                break;
            }
        }
        if (isFinished) {
            setUpReceivers(backlogItem, "Tester");

            backlogItem.setState(new ReadyForTestingState());
        }
        else  logger.log(Level.WARNING, "Not all tasks are finished!");
    }

    public void moveBackward(BacklogItem backlogItem) {
        logger.log(Level.WARNING, "Can't move backwards now!");
    }

}
