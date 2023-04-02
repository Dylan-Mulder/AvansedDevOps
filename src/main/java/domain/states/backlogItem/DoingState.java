package domain.states.backlogItem;

import domain.BacklogItem;
import domain.Developer;
import domain.Task;

import java.util.ArrayList;
import java.util.logging.Level;

public class DoingState extends AbstractBacklogItemState {
    /* ATTRIBUTES */


    /* CONSTRUCTORS */
    public DoingState() {
    }

    /* GETTERS */


    /* SETTERS */


    /* METHODS */
    public void changeName(BacklogItem backlogItem, String name) {
        logger.log(Level.WARNING, "Can't change name!");
    }

    public void changeDescription(BacklogItem backlogItem, String description) {
        logger.log(Level.WARNING, "Can't change description!");
    }

    public void changeTasksAdd(BacklogItem backlogItem, Task task) {
        logger.log(Level.WARNING, "Can't add tasks now!");
    }

    public void changeTasksRemove(BacklogItem backlogItem, Task task) {
        logger.log(Level.WARNING, "Can't remove tasks now!");
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
            setUpReceivers(backlogItem);
            //update state
            backlogItem.setState(new ReadyForTestingState());
        }
        else  logger.log(Level.WARNING, "Not all tasks are finished!");
    }

    public void moveBackward(BacklogItem backlogItem) {
        logger.log(Level.WARNING, "Can't move backwards now!");
    }
    public void setUpReceivers(BacklogItem backlogItem){
        ArrayList<Task> tasks = backlogItem.getTasks();
        ArrayList<Developer> receivers = new ArrayList<>();
        Developer d;
        for (Task task: tasks){
            d = task.getCurrentDeveloper();
            if(!receivers.contains(d)&&d.isTester()){
                receivers.add(d);
            }
        }
        backlogItem.setDevelopersToNotify(receivers);
    }

}
