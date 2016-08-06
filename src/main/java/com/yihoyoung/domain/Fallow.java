package com.yihoyoung.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by hoyounglee on 2016. 8. 6..
 */
public class Fallow {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    long fallowId;
    long userId;
    long falloweeId;
    Timestamp createdAt;
}
