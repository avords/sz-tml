package com.parkdt.tml.controller;

import com.parkdt.tml.domain.Device;
import com.parkdt.tml.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private DeviceService[] deviceService;
    @RequestMapping("world")
    public String helloWorld(Model model, HttpServletRequest req) {
        Device device = deviceService[0].selectByPrimaryKey(1);
        model.addAttribute("username", device.getDevicename());
        return "helloWorld";
    }
}
