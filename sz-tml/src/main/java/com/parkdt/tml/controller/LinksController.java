package com.parkdt.tml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by guojianhua on 2018/01/09.
 *
 * index 立可平台 资源中心
 */
@Controller
@RequestMapping(value = "/links")
public class LinksController {

    @RequestMapping("index")
    public String index(Model model, HttpServletRequest req) {
        return "index";
    }

    @RequestMapping("platform")
    public String platform(Model model, HttpServletRequest req) {
        return "立可平台";
    }

    @RequestMapping("Resources")
    public String Resources(Model model, HttpServletRequest req) {
        return "资源中心";
    }
}
