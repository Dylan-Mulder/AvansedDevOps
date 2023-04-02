package domain.states.backlogItem;

import domain.BacklogItem;
import domain.Developer;
import domain.Task;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractBacklogItemState {
    /* ATTRIBUTES */
    Logger logger = Logger.getLogger(InBacklogState.class.getName());

    /* CONSTRUCTORS */
    public AbstractBacklogItemState() {
        logger.setLevel(Level.CONFIG);
    }

    /* METHODS */
    abstract public void changeName(BacklogItem backlogItem, String name);
    abstract public void changeDescription(BacklogItem backlogItem, String description);
    abstract public void changeTasksAdd(BacklogItem backlogItem, Task task);
    abstract public void changeTasksRemove(BacklogItem backlogItem, Task task);
    abstract public void moveForward(BacklogItem backlogItem);
    abstract public void moveBackward(BacklogItem backlogItem);
    protected void setUpReceivers(BacklogItem backlogItem,String receiverClasses){
        ArrayList<Task> tasks = backlogItem.getTasks();
        ArrayList<Developer> receivers = new ArrayList<>();
            Developer d;
            for (Task task: tasks){
                d = task.getCurrentDeveloper();
                if(!receivers.contains(d)){
                    if (d.isTester()&&receiverClasses.contains("Tester")){
                        receivers.add(d);
                    }
                    if (d.isLeadDeveloper()&&receiverClasses.contains("LeadDeveloper")){
                        receivers.add(d);
                    }
                }
            }
        backlogItem.setDevelopersToNotify(receivers);
    }
}
