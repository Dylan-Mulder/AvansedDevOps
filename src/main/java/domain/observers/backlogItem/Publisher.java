package domain.observers.backlogItem;

import domain.BacklogItem;

import java.util.ArrayList;

public class Publisher {
    /* ATTRIBUTES */
    private final ArrayList<ISubscriber> subscribers = new ArrayList<>();

    /* CONSTRUCTORS */
    public Publisher() {}

    /* GETTERS */

    public ArrayList<ISubscriber> getSubscribers() {
        return subscribers;
    }
    /* SETTERS */

    /* METHODS */
    public void subscribe(ISubscriber subscriber) {
        if (!subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
        }
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
