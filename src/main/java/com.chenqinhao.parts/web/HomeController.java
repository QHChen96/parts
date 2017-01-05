package com.chenqinhao.parts.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/1/5.
 */
@Controller
public class HomeController {
    @RequestMapping("/home")
    public String Home() {
        return "home";
    }
}
