package domain.observers.backlog_item;

import domain.BacklogItem;

public interface ISubscriber {
    /* METHODS */
    void update(BacklogItem item);
}
