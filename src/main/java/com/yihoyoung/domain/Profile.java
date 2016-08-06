package com.yihoyoung.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by hoyounglee on 2016. 8. 6..
 */
@Data
@Entity
public class Profile {
    @Id
    long userId;
    String name;
    String school;
    String company;
    String message;
    Timestamp createdAt;
    Timestamp updatedAt;
}
