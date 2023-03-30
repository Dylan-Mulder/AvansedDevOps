package domain.states.backlogItem;

import domain.BacklogItem;
import domain.Developer;
import domain.Task;

import java.util.ArrayList;
import java.util.logging.Level;

public class TestingState extends AbstractBacklogItemState {
    /* ATTRIBUTES */


    /* CONSTRUCTORS */
    public TestingState() {}

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
        logger.log(Level.INFO, "Moved " + backlogItem.getName() + " to: Tested");
        backlogItem.setState(new TestedState());
    }

    public void moveBackward(BacklogItem backlogItem) {
        logger.log(Level.INFO, "Moved " + backlogItem.getName() + " to: ToDo");
        setUpReceiversToDo(backlogItem);
        backlogItem.setState(new ToDoState());
    }

    public void setUpReceiversToDo(BacklogItem backlogItem){
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
