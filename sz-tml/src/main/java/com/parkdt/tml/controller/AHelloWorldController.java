package com.parkdt.tml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by guojianhua on 2017/12/20.
 */
@Controller
@RequestMapping(value = "/hello")
public class AHelloWorldController {

    @RequestMapping("world")
    public String helloWorld(Model model, HttpServletRequest req) {
        model.addAttribute("username", "000");
        return "helloWorld";
    }
}
