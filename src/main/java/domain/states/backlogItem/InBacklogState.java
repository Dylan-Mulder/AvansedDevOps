package domain.states.backlogItem;

import domain.BacklogItem;
import domain.Task;

public class InBacklogState implements IBacklogItemState {
    /* ATTRIBUTES */


    /* CONSTRUCTORS */
    public InBacklogState() {
    }

    /* GETTERS */


    /* SETTERS */


    /* METHODS */
    @Override
    public void setName(BacklogItem backlogItem, String name) {
        backlogItem.setName(name);
    }

    @Override
    public void setDescription(BacklogItem backlogItem, String description) {

    }

    @Override
    public void addTask(BacklogItem backlogItem, Task task) {

    }

    @Override
    public void removeTask(BacklogItem backlogItem, Task task) {

    }

    @Override
    public void moveForward(BacklogItem backlogItem) {

    }

    @Override
    public void moveBackward(BacklogItem backlogItem) {

    }
}
