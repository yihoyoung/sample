package com.yihoyoung.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;
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

    public Article(){
        UUID uuid = UUID.randomUUID();
        this.articleId = "a" + uuid.toString();
    }
}
