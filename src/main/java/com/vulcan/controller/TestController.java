package com.vulcan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {
    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/")
    @ResponseBody
    public String hello(){
    return "Hello";
    }

    @RequestMapping("/he")
    @ResponseBody
    public String sss(){
        logger.info("Get | /he");
        return "Hello World!";
    }

    @GetMapping("h")
    @ResponseBody
    public String sssssss(){
        return "Hello World!Get";
    }

    @PostMapping("h")
    @ResponseBody
    public String ssss(){
        return "Hello World!Post";
    }

    @PutMapping("h")
    @ResponseBody
    public String sssss(){
        return "Hello World!Put";
    }

    @DeleteMapping("h")
    @ResponseBody
    public String ssssss(){
        return "Hello World!Delete";
    }

}
