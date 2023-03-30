package domain.observers.backlogItem;

import domain.BacklogItem;

import java.util.ArrayList;

public class Publisher {
    /* ATTRIBUTES */
    private final ArrayList<ISubscriber> subscribers = new ArrayList<>();

    /* CONSTRUCTORS */
    public Publisher() {}

    /* GETTERS */

    /* SETTERS */

    /* METHODS */
    public void subscribe(ISubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(ISubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(BacklogItem backlogItem){
        for (ISubscriber subscriber: subscribers){
            subscriber.update(backlogItem);
        }
    }
}
