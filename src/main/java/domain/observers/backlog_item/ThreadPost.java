package domain.observers.backlog_item;

import java.time.LocalDateTime;

public class ThreadPost {
    /* ATTRIBUTES */
    private final String content;
    private final String originalPoster;
    private final LocalDateTime dateTimePosted;

    /* CONSTRUCTORS */
    public ThreadPost(String content, String originalPoster, LocalDateTime dateTimePosted) {
        this.content = content;
        this.originalPoster = originalPoster;
        this.dateTimePosted = dateTimePosted;
    }

    /* GETTERS */
    public String getContent() {
        return content;
    }
    public String getOriginalPoster() {
        return originalPoster;
    }
    public LocalDateTime getDateTimePosted() {
        return dateTimePosted;
    }

    /* SETTERS */

    /* METHODS */
}
