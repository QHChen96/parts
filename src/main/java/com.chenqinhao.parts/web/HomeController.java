package com.chenqinhao.parts.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/1/5.
 */
@RestController
public class HomeController {
    @Autowired
    private String aa;
    @RequestMapping("/home")
    public String Home() {
        return aa;
    }
}
