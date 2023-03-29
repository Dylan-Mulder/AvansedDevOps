package domain.states.backlogItem;

import domain.BacklogItem;
import domain.Task;

public interface IBacklogItemState {
    /* METHODS */
    void setName(BacklogItem backlogItem, String name);
    void setDescription(BacklogItem backlogItem, String description);
    void addTask(BacklogItem backlogItem, Task task);
    void removeTask(BacklogItem backlogItem, Task task);
    void moveForward(BacklogItem backlogItem);
    void moveBackward(BacklogItem backlogItem);
}
