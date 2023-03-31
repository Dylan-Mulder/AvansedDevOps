package domain.observers.backlogItem;

import domain.BacklogItem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ForumThread implements ISubscriber {
    /* ATTRIBUTES */
    private BacklogItem backlogItem;
    private ArrayList<ThreadPost> threadPosts = new ArrayList<>();


    /* CONSTRUCTORS */
    public ForumThread(BacklogItem item) {
        this.backlogItem=item;
    }

    /* GETTERS */

    public BacklogItem getBacklogItem() {
        return backlogItem;
    }

    public void setBacklogItem(BacklogItem backlogItem) {
        this.backlogItem = backlogItem;
    }

    public ArrayList<ThreadPost> getThreadPosts() {
        return threadPosts;
    }

    /* SETTERS */

    /* METHODS */
    public void addPost(BacklogItem backlogItem){
        threadPosts.add(new ThreadPost(
                "BacklogItem updated to new state: "
                        +backlogItem.getState()+".",
                "System", LocalDateTime.now()));
    }
    @Override
    public void update(BacklogItem backlogItem) {
        if (backlogItem.getName() == this.backlogItem.getName()){
            addPost(backlogItem);
            this.backlogItem=backlogItem;
        }
    }
}
