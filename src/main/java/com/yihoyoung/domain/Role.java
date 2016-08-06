package com.yihoyoung.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by hoyounglee on 2016. 8. 6..
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role {
    @Id
    int roleId;
    String roleName;
}
