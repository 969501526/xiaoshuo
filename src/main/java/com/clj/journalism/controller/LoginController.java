package com.clj.journalism.controller;

import com.clj.journalism.bean.Msg;
import com.clj.journalism.util.OpenIdUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping("login")
    public Msg login(String code,String classify){
        String openId = OpenIdUtil.oauth2GetOpenid(code);
        return Msg.success().add("success",openId);
    }

}
