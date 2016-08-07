package com.yihoyoung.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;

/**
 * Created by hoyounglee on 2016. 8. 6..
 */
@Data
@Entity
public class UsersRole {
    @Id
    long id;
    long userId;
    int roleId;
    @Temporal(TemporalType.TIMESTAMP)
    java.util.Calendar createdAt;
}
