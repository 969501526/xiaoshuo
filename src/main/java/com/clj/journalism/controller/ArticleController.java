package com.clj.journalism.controller;

import com.clj.journalism.bean.Article;
import com.clj.journalism.bean.Msg;
import com.clj.journalism.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ArticleController {

//    @Autowired
//    private ArticleService articleService;
//
//    @RequestMapping("addArticle")
//    public Msg addArticle() throws Exception{
//       articleService.addArticle();
//
//       return Msg.success().add("success","成功");
//    }
//
//    @RequestMapping("addIn")
//    public Msg addIn() throws Exception{
//        articleService.introduction();
//        return Msg.success().add("success","成功");
//    }
//
//    @RequestMapping("getArticle")
//    public Msg getArticle(@RequestParam("id") Integer id){
//
//        return Msg.success().add("success",articleService.getArticle(id));
//    }
//
//    @RequestMapping("getArticleAll")
//    public Msg getArticleAll(@RequestParam("id") Integer id){
//        List<Article> list=articleService.getArticleAll();
//        for(Article article:list){
//            String content = article.getContent();
//            String pcontent=content.replaceAll("view","text");
//            article.setContent(pcontent);
//            System.out.println(article);
//            articleService.update(article);
//        }
//
//        return Msg.success().add("success",list);
//    }
}
