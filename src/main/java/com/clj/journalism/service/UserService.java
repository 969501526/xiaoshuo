package com.clj.journalism.service;

import com.clj.journalism.bean.User;
import com.clj.journalism.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public Integer insert(User user){
        return userMapper.insert(user);
    }

    public List<User> getOpenId(String openId){
        return userMapper.getOpenId(openId);
    }
}
