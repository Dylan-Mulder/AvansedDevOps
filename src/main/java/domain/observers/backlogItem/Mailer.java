package domain.observers.backlogItem;

import domain.BacklogItem;
import domain.Developer;
import domain.Task;

import java.util.ArrayList;

public class Mailer implements ISubscriber {
    /* ATTRIBUTES */
    private BacklogItem backlogItem;
    private ArrayList<Developer> receivers = new ArrayList<>();
    /* CONSTRUCTORS */
    public Mailer(BacklogItem item) {
        this.backlogItem=item;
    }
    /* GETTERS */

    public ArrayList<Developer> getReceivers() {
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
