package org.example;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ChatMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    private String user;
    private String message;
    private LocalDateTime timestamp;

    public ChatMessage(String user, String message) {
        this.user = user;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public String getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + user + ": " + message;
    }
}
