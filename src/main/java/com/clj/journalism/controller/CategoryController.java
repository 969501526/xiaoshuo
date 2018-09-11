package com.clj.journalism.controller;

import com.clj.journalism.bean.Category;
import com.clj.journalism.bean.Msg;
import com.clj.journalism.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("getCategroyArticleAll")
    public Msg getCategroyArticleAll(){
        List<Category> list = categoryService.getCategroyArticleAll();
        return Msg.success().add("success",list);
    }

    @GetMapping("getCategroyArticleById")
    public Msg getCategroyArticleById(@RequestParam("cId") Integer cId){
        return Msg.success().add("success",categoryService.getCategroyArticleByCid(cId));
    }
}
