package com.clj.journalism.bean;

import java.util.List;

public class Book {
    private Integer bId;

    private String name;

    private String state;

    private String headurl;

    private String brief;

    private List<Novel> novel;

    private String author;

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getHeadurl() {
        return headurl;
    }

    public void setHeadurl(String headurl) {
        this.headurl = headurl == null ? null : headurl.trim();
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    public List<Novel> getNovel() {
        return novel;
    }

    public void setNovel(List<Novel> novel) {
        this.novel = novel;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bId=" + bId +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", headurl='" + headurl + '\'' +
                ", brief='" + brief + '\'' +
                ", novel=" + novel +
                ", author='" + author + '\'' +
                '}';
    }
}