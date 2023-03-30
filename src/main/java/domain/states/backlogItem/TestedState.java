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
        logger.log(Level.INFO, "Moved " + backlogItem.getName() + " to: Done");
        backlogItem.setDevelopersToNotify(null);
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
            if(!receivers.contains(d)){
                receivers.add(d);
            }
        }
        for (Developer developer: developers){
            if (developer.isLeadDeveloper()){
                if(!receivers.contains(developer)){
                    receivers.add(developer);
                }
            }
        }
        backlogItem.setDevelopersToNotify(receivers);
    }
}
