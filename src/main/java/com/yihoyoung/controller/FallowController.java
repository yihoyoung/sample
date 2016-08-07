package com.yihoyoung.controller;

import com.yihoyoung.domain.Fallow;
import com.yihoyoung.domain.User;
import com.yihoyoung.service.FallowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hoyounglee on 2016. 8. 7..
 */
@RestController
public class FallowController {
    @Autowired
    FallowService fallowService;

    @RequestMapping(value = "/user/fallow/{Id}", method = RequestMethod.POST)
    @ResponseBody
    public User create(@PathVariable("Id") Long falloweeId, @RequestBody User user) {
        fallowService.addFallow(user, falloweeId);
        return user;
    }
}
