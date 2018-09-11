package com.clj.journalism.util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.clj.journalism.bean.Article;
import com.clj.journalism.mapper.ArticleMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

public class JsoutUtil {


    public static List<Article> pc() throws Exception{
        Document document = Jsoup.connect("http://news.163.com/domestic/").get();

        //body > div > div.second2016_content > div.ns_area.second2016_main.clearfix > div.second_right > div.mt23.mod_jsxw > ul
        Elements elements=document.select("body").select("div").select("div.second2016_content").select("div.ns_area.second2016_main.clearfix")
                .select("div.second_right").select("div.mt23.mod_jsxw").select("ul").select("li").select("a");
        Article article = null;
        List<Article> articleList = new ArrayList<Article>();
        for (Element element : elements) {
            article = new Article();
            String url = element.attr("abs:href");
            Document document2 = Jsoup.connect(url).get();
            //#epContentLeft > h1
            Elements title = document2.select("#epContentLeft").select("h1");
            //#endText > p:nth-child(2)
            Elements content = document2.select("#endText").select("p");
            article.setUrl(url);
            String str = content.toString().replaceAll("p","view");
            article.setContent(str);
            article.setTitle(title.text());
            article.setcId(1);
            articleList.add(article);

        }
        return articleList;
    }

    public static List<Article> introduction() throws Exception{
        Document document = Jsoup.connect("http://news.163.com/domestic/").get();
        //body > div > div.second2016_content > div.ns_area.top_news.clearfix > div.today_news > ul
        Elements elements=document.select("body").select("div").select("div.second2016_content").select("div.ns_area.top_news.clearfix")
                .select("div.today_news").select("ul").select("li").select("a");
        Article article = null;
        List<Article> articleList = new ArrayList<Article>();
        for (Element element:elements){
            article = new Article();
            String url = element.attr("abs:href");
            Document document1 = Jsoup.connect(url).get();
            //#epContentLeft > h1
            Elements title = document1.select("#epContentLeft").select("h1");
            Elements content = document1.select("#endText").select("p");
            String str = content.toString().replaceAll("p","view");
            article.setTitle(title.text());
            article.setUrl(url);
            article.setcId(2);
            article.setContent(str);
            articleList.add(article);
        }
        return articleList;
    }
}
