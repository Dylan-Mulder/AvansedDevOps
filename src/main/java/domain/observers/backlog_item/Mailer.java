package domain.observers.backlog_item;

import domain.BacklogItem;
import domain.Developer;

import java.util.ArrayList;
import java.util.List;

public class Mailer implements ISubscriber {
    /* ATTRIBUTES */
    private BacklogItem backlogItem;
    private List<Developer> receivers = new ArrayList<>();

    /* CONSTRUCTORS */
    public Mailer(BacklogItem item) {
        this.backlogItem=item;
    }

    /* GETTERS */
    public List<Developer> getReceivers() {
        return receivers;
    }

    /* SETTERS */

    /* METHODS */
    @Override
    public void update(BacklogItem backlogItem) {

        this.backlogItem = backlogItem;
        //Set up receivers
        receivers = this.backlogItem.getDevelopersToNotify();
        //Send mail based on new BacklogItem
    }
}
