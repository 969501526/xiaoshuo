package com.clj.journalism.util;

import com.clj.journalism.bean.Book;
import com.clj.journalism.bean.Novel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class NovelUtil {

    public static Book bookpc(String url) throws Exception{

        Document document = Jsoup.connect(url).get();
        Book book = new Book();
        // >  >  >  >  > h1
        Elements bookName=document.select("#container").select("div.mainnav").select("section")
                .select("div").select("div.b-info").select("h1");
        System.out.println("书名"+bookName.text());
        book.setName(bookName.text());
        Elements author=document.select("#container").select("div.mainnav").select("section").select("div")
                .select("div:nth-child(6)").select("div.bookDetail").select("dl:nth-child(2)").select("dd");
        System.out.println("作者"+author);
        book.setAuthor(author.text());
        //#container > div.mainnav > section > div > a > img
        Elements headUrl=document.select("#container").select("div.mainnav").select("section")
                .select("div").select("a").select("img");
        System.out.println("头像链接"+headUrl.attr("abs:src"));
        book.setHeadurl(headUrl.attr("abs:src"));
        //
        Elements jj = document.select("#waa");
        book.setBrief("简介"+jj.text());
        System.out.println(jj.text());
        Elements state=document.select("#container").select("div.mainnav").select("section")
                .select("div:nth-child(6)").select("div.bookDetail").select("dl:nth-child(1)").select("dd");
        System.out.println("状态"+state.text());
        book.setState(state.text());

        return book;
    }

    public static List<Novel> novelpc(String urls) throws Exception{
        Document document = Jsoup.connect(urls).get();
        //#container > div.mainnav > section > div > div.b-info >  > a.reader
        Elements titleUrl=document.select("#container").select("div.mainnav").select("section")
                .select("div").select("div.b-info").select("div.b-oper").select("a.reader");
        Document document1 = Jsoup.connect(titleUrl.attr("abs:href")).get();
        // >  >  >  > div.clearfix.dirconone
        Elements a=document1.select("#chapter").select("div.chapterSo").select("div.chapterNum").select("ul")
                .select("li").select("a");
        List<Novel> novelList = new ArrayList<Novel>();
        Novel novel = null;
        for(Element element:a){
            novel = new Novel();
            String url = element.attr("abs:href");
            Document document2 = Jsoup.connect(url).get();
            // >  > h1 > strong
            Elements title = document2.select("#directs").select("div.bookInfo").select("h1").select("strong");
            System.out.println("章节"+title.text());
            novel.setTitle(title.text());
            //#content
            Elements content = document2.select("#content");
            System.out.println("内容"+content.text());
            novel.setContent(content.text());
            novelList.add(novel);
        }
        return novelList;
    }
}
