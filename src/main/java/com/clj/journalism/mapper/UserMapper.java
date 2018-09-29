package com.clj.journalism.mapper;

import com.clj.journalism.bean.User;
import com.clj.journalism.bean.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    Integer insert(User user);

    Integer getOpenId(String openId);

    List<User> getUserAndBook(Integer userId);

    List<User> getUser(String openId);

}