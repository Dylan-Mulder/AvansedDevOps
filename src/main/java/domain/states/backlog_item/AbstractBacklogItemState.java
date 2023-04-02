package domain.states.backlog_item;

import domain.BacklogItem;
import domain.Developer;
import domain.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractBacklogItemState {
    /* ATTRIBUTES */
    Logger logger = Logger.getLogger(AbstractBacklogItemState.class.getName());

    /* CONSTRUCTORS */
    protected AbstractBacklogItemState() {
        logger.setLevel(Level.CONFIG);
    }

    /* METHODS */
    public abstract void changeName(BacklogItem backlogItem, String name);
    public abstract void changeDescription(BacklogItem backlogItem, String description);
    public abstract void changeTasksAdd(BacklogItem backlogItem, Task task);
    public abstract void changeTasksRemove(BacklogItem backlogItem, Task task);
    public abstract void moveForward(BacklogItem backlogItem);
    public abstract void moveBackward(BacklogItem backlogItem);
    protected void setUpReceivers(BacklogItem backlogItem,String receiverClasses){
        List<Task> tasks = backlogItem.getTasks();
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
