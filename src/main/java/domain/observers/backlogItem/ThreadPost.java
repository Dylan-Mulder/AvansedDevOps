package domain.observers.backlogItem;

import java.time.LocalDateTime;

public class ThreadPost {
    /* ATTRIBUTES */
    private String content;
    private String originalPoster;
    private LocalDateTime dateTimePosted;

    /* CONSTRUCTORS */
    public ThreadPost(String content, String originalPoster, LocalDateTime dateTimePosted) {
        this.content = content;
        this.originalPoster = originalPoster;
        this.dateTimePosted = dateTimePosted;
    }

    /* GETTERS */

    /* SETTERS */

    /* METHODS */
}
