package com.example.topvideo.domain.vote;

import java.time.LocalDateTime;

public class Vote {
    private Integer userId;
    private Integer DiscoveryId;
    private Type type;
    private LocalDateTime dateAdded;

    public Vote(Integer userId, Integer discoveryId, Type type, LocalDateTime dateAdded) {
        this.userId = userId;
        DiscoveryId = discoveryId;
        this.type = type;
        this.dateAdded = dateAdded;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getDiscoveryId() {
        return DiscoveryId;
    }

    public Type getType() {
        return type;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public enum Type{
        UP,DOWN;
    }
}
