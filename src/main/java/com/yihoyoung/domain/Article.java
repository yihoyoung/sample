package com.yihoyoung.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
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
    Timestamp createdAt;
    Timestamp updatedAt;

    public Article(){
        UUID uuid = UUID.randomUUID();
        this.articleId = "a" + uuid.toString();
    }
}
