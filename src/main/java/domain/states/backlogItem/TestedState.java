package domain.states.backlogItem;

import domain.BacklogItem;
import domain.Developer;
import domain.Task;

import java.util.ArrayList;
import java.util.logging.Level;

public class TestedState extends AbstractBacklogItemState {
    /* ATTRIBUTES */


    /* CONSTRUCTORS */
    public TestedState() {
        // Only create the Object
    }

    /* GETTERS */


    /* SETTERS */


    /* METHODS */
    public void changeName(BacklogItem backlogItem, String name) {
        logger.log(Level.WARNING, "Can't change name while in state: Tested");
    }

    public void changeDescription(BacklogItem backlogItem, String description) {
        logger.log(Level.WARNING, "Can't change description while in state: Tested");
    }

    public void changeTasksAdd(BacklogItem backlogItem, Task task) {
        logger.log(Level.WARNING, "Can't add tasks now while in state: Tested");
    }

    public void changeTasksRemove(BacklogItem backlogItem, Task task) {
        logger.log(Level.WARNING, "Can't remove tasks now while in state: Tested");
    }

    public void moveForward(BacklogItem backlogItem) {
        logger.log(Level.INFO, "Moved " + backlogItem.getName() + " to: Done");
        backlogItem.setDevelopersToNotify(new ArrayList<Developer>());
        backlogItem.setState(new DoneState());
    }

    public void moveBackward(BacklogItem backlogItem) {
        logger.log(Level.INFO, "Moved " + backlogItem.getName() + " to: Ready For Testing");
        setUpReceivers(backlogItem);
        backlogItem.setState(new ReadyForTestingState());
    }
    public void setUpReceivers(BacklogItem backlogItem){
        ArrayList<Developer> developers = backlogItem.getCurrentSprint().getDevelopers();
        ArrayList<Task> tasks = backlogItem.getTasks();
        ArrayList<Developer> receivers = new ArrayList<>();
        Developer d;
        for (Task task: tasks){
            d = task.getCurrentDeveloper();
            if(!receivers.contains(d)&&d.isLeadDeveloper()){
                receivers.add(d);
            }
        }
        backlogItem.setDevelopersToNotify(receivers);
    }
}
