package com.chingchou.sso.rest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author: zhoujing
 * @Date: 2021/3/2 18:07
 * @Description:
 * @Version: 1.0
 */

@Controller
@EnableAutoConfiguration
public class TestController {

    @Value("${casClientLogoutUrl}")
    String casClientLogoutUrl;

    @RequestMapping("/ssob/test")
    @ResponseBody
    public String test(){
        return "sso-b....";
    }

    @RequestMapping("/ssob/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:"+casClientLogoutUrl;
    }

    @RequestMapping("/logoutSuccess")
    @ResponseBody
    public String logoutSuccess() {
        return "sso-b登出成功";
    }
}
