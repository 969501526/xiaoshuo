package com.clj.journalism.controller;

import com.clj.journalism.bean.Msg;
import com.clj.journalism.bean.User;
import com.clj.journalism.service.UserService;
import com.clj.journalism.util.OpenIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public Msg login(User user,String code){
        String openId = OpenIdUtil.oauth2GetOpenid(code);
        List<User> list = userService.getOpenId(openId);
        if(list.isEmpty()){
            user.setOpenid(openId);
            userService.insert(user);
        }
        return Msg.success().add("success",openId);
    }

}
