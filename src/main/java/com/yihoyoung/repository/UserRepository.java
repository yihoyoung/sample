package com.yihoyoung.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yihoyoung.domain.User;
/**
 * Created by hoyounglee on 2016. 8. 6..
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
