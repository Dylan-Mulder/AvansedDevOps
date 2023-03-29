package domain.states.backlogItem;

import domain.BacklogItem;
import domain.Task;

public class DoneState implements IBacklogItemState {
    /* ATTRIBUTES */


    /* CONSTRUCTORS */
    public DoneState() {
    }

    /* GETTERS */


    /* SETTERS */


    /* METHODS */
    @Override
    public void setName(BacklogItem backlogItem, String name) {

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
