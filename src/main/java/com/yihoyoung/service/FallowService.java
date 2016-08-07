package com.yihoyoung.service;

import com.yihoyoung.domain.Fallow;
import com.yihoyoung.domain.User;
import com.yihoyoung.repository.FallowRepository;
import com.yihoyoung.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * Created by hoyounglee on 2016. 8. 7..
 */
@Service
public class FallowService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FallowRepository fallowRepository;

    public void addFallow(User user, Long falloweeId) {
        User user1 = userRepository.getOne(falloweeId);
        if(ObjectUtils.isEmpty(user1)){
            throw new RuntimeException("해당 사용자가 존재 하지 않습니다.");
        }

        Fallow fallow = new Fallow();
        fallow.setUser(user);
        fallow.setFallow(user1);
        Fallow fallow2 = fallowRepository.save(fallow);
    }
}
