package com.clj.journalism.service;

import com.clj.journalism.bean.User;
import com.clj.journalism.bean.UserBook;
import com.clj.journalism.mapper.UserBookMapper;
import com.clj.journalism.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserBookMapper userBookMapper;


    public Integer insert(User user){
        return userMapper.insert(user);
    }

    public Integer getOpenId(String openId){
        return userMapper.getOpenId(openId);
    }

    public List<User> getUserAndBook(Integer userId){
        return userMapper.getUserAndBook(userId);
    }

    public Integer saveShelf(UserBook userBook){
        return userBookMapper.saveShelf(userBook);
    }

    public Integer update(UserBook userBook){
        return userBookMapper.update(userBook);
    }

    public Integer getShelf(UserBook userBook){
        return  userBookMapper.getShelf(userBook);
    }

    public List<User> getUser(String openId){
        return userMapper.getUser(openId);
    }

    public Integer deleteShelt(Integer userId){
        return userBookMapper.deleteShelt(userId);
    }
}
