package com.vulcan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello {

    @RequestMapping("/he")
    @ResponseBody
    public String sss(){
        return "Hello World!";
    }
}
