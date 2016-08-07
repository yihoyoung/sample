package com.yihoyoung.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by hoyounglee on 2016. 8. 6..
 */
@Entity
@Data
@Table(name = "Fallows")
public class Fallow {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    long fallowId;
    @Temporal(TemporalType.TIMESTAMP)
    java.util.Calendar createdAt;
    @ManyToOne
    @JoinColumn(name = "userId")
    User user;
    @OneToOne
    @JoinColumn(name = "falloweeId")
    User fallow;
}
