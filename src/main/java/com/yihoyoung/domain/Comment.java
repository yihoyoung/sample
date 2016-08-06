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
public class Comment {
    @Id
    String commentId;
    long parentId;
    long userId;
    String content;
    int likes;
    Timestamp createdAt;
    Timestamp updatedAt;

    public Comment(){
        UUID uuid = UUID.randomUUID();
        this.commentId = "c" + uuid.toString();
    }
}
