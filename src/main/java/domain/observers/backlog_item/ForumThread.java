package domain.observers.backlog_item;

import domain.BacklogItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ForumThread implements ISubscriber {
    /* ATTRIBUTES */
    private BacklogItem backlogItem;
    private final ArrayList<ThreadPost> threadPosts = new ArrayList<>();

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
    public List<ThreadPost> getThreadPosts() {
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
        if (Objects.equals(backlogItem.getName(), this.backlogItem.getName())){
            addPost(backlogItem);
            this.backlogItem=backlogItem;
        }
    }
}
