package com.luckchen.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: chenyawei
 * @Date: 2019-12-22 13:54
 */
@Controller
@Slf4j
public class HelloWorldController {


    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "hello chen";
    }

}
