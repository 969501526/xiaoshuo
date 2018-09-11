package com.clj.journalism.mapper;

import com.clj.journalism.bean.Article;
import com.clj.journalism.bean.ArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleMapper {

    Integer addArticle(List<Article> list);

    Integer deleteArticle(Integer cId);

    Article getArticle(Integer id);

    List<Article> getArticleAll();

    int update(Article article);
}