package com.clj.journalism.controller;

import com.clj.journalism.bean.Msg;
import com.clj.journalism.bean.Novel;
import com.clj.journalism.bean.User;
import com.clj.journalism.bean.UserBook;
import com.clj.journalism.service.NovelService;
import com.clj.journalism.service.UserService;
import com.clj.journalism.util.OpenIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private NovelService novelService;

    /**
     * 书架列表
     * @param code
     * @return
     */
    @GetMapping("getUserAndBook")
    public Msg getUserAndBook(String code){
        String openId = OpenIdUtil.oauth2GetOpenid(code);
       Integer userId = userService.getOpenId(openId);
        return Msg.success().add("success",userService.getUserAndBook(userId));
    }

    /**
     * 添加书架
     * @param code
     * @param bId
     * @return
     */
    @RequestMapping("saveShelf")
    public Msg saveShelf(String code,Integer bId){
        UserBook userBook = new UserBook();
        String openId = OpenIdUtil.oauth2GetOpenid(code);
        Integer userId = userService.getOpenId(openId);
        if(userId==null){
            return Msg.success().add("success","已存在");
        }
        userBook.setUserId(userId);
        userBook.setbId(bId);
        Integer nId = novelService.getNid(bId);
        userBook.setnId(nId);
        Integer count = userService.getShelf(userBook);
        if(count<=0){
            userService.saveShelf(userBook);
            return Msg.success().add("success","添加成功");
        }else{
            return Msg.success().add("success","已存在");
        }

    }

    /**
     * 自动修改书架章节
     * @param userBook
     * @param code
     * @return
     */
    @RequestMapping("updateChapter")
    public Msg update(UserBook userBook,String code){
        String openId = OpenIdUtil.oauth2GetOpenid(code);
        Integer userId = userService.getOpenId(openId);
        userBook.setUserId(userId);
        Integer count = userService.getShelf(userBook);
        if(count>0){
            userService.update(userBook);
            return Msg.success().add("success","章节修改");
        }else{
            userService.saveShelf(userBook);
            return Msg.success().add("success","已经添加到书架");
        }
    }

    /**
     * 获取用户信息
     * @param code
     * @return
     */
    @RequestMapping("getUser")
    public Msg getUser(String code){
        String openId = OpenIdUtil.oauth2GetOpenid(code);
        return Msg.success().add("success",userService.getUser(openId));
    }

    /**
     * 清理书架
     */
    @RequestMapping("deleteShelf")
    public Msg deleteShelf(Integer userId){
       Integer result = userService.deleteShelt(userId);
        return Msg.success().add("success","书架清理成功");
    }
}
