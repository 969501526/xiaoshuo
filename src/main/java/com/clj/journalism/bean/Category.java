package com.clj.journalism.bean;

import java.util.List;

public class Category {
    private Integer cId;

    private String name;

    private List<Article> article;

    private List<Novel> novel;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public List<Article> getArticle() {
        return article;
    }

    public void setArticle(List<Article> article) {
        this.article = article;
    }

    public List<Novel> getNovel() {
        return novel;
    }

    public void setNovel(List<Novel> novel) {
        this.novel = novel;
    }
}