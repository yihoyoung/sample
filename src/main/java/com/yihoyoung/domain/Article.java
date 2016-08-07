package com.yihoyoung.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

/**
 * Created by hoyounglee on 2016. 8. 6..
 */
@Data
@Entity
public class Article {
    @Id
    String articleId;
    long userId;
    String title;
    String context;
    int views;
    int likes;
    @Temporal(TemporalType.TIMESTAMP)
    java.util.Calendar createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    java.util.Calendar updatedAt;
    @ManyToOne
    User user;
    @OneToOne
    Profile profile;
    @OneToMany
    List<Comment> comments;

    public Article(){
        UUID uuid = UUID.randomUUID();
        this.articleId = "a" + uuid.toString();
    }
}
