package com.clj.journalism.bean;

import java.io.Serializable;

public class Novel implements Serializable {
    private Integer nId;

    private Integer cId;

    private String title;

    private Integer bId;

    private String content;

    private Integer startTitle;

    public Integer getnId() {
        return nId;
    }

    public void setnId(Integer nId) {
        this.nId = nId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getStartTitle() {
        return startTitle;
    }

    public void setStartTitle(Integer startTitle) {
        this.startTitle = startTitle;
    }

    @Override
    public String toString() {
        return "Novel{" +
                "nId=" + nId +
                ", cId=" + cId +
                ", title='" + title + '\'' +
                ", bId=" + bId +
                ", content='" + content + '\'' +
                '}';
    }
}