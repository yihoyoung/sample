package com.yihoyoung.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created by hoyounglee on 2016. 8. 6..
 */
@Data
@Entity
@Table(name = "Users")
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long userId;
    String email;
    String password;
    Timestamp createdAt;
    Timestamp updatedAt;
}
