package domain.observers.backlogItem;

import domain.BacklogItem;

public interface ISubscriber {
    /* METHODS */
    void update(BacklogItem item);
}
