package com.clj.journalism.service;

import com.clj.journalism.bean.Article;
import com.clj.journalism.mapper.ArticleMapper;
import com.clj.journalism.mapper.BookMapper;
import com.clj.journalism.util.JsoutUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private BookMapper bookMapper;

    public Integer addArticle() throws Exception{
        return articleMapper.addArticle(JsoutUtil.pc());
    }

    public List<Article> addArticles(List<Article> articles){
        articleMapper.addArticle(articles);
        return articles;
    }

    public  Integer introduction() throws Exception{
        return articleMapper.addArticle(JsoutUtil.introduction());
    }

    public Article getArticle(Integer id){
        return articleMapper.getArticle(id);
    }
    public List<Article> getArticleAll(){
        return articleMapper.getArticleAll();
    }

    public int update(Article article){
        return articleMapper.update(article);
    }
}
