package com.yihoyoung.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hoyounglee on 2016. 7. 27..
 */
@RestController
public class MainPageController {
    @ResponseBody
    @RequestMapping("/")
    public String MainPage(){
        return "Hello, World";
    }
}
