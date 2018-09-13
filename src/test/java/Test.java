import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Test {

    public static void main(String[] args) throws Exception{
        Document document = Jsoup.connect("https://www.ybdu.com/xiazai/13/13444/").get();
        //#detail-box > div > div.ui_bg6 > div.box_intro > div.pic > img
        Elements headUrl = document.select("#detail-box").select("div").select("div.ui_bg6")
                .select("div.box_intro").select("div.pic").select("img");
        System.out.println(headUrl.attr("abs:src"));
        // >  >  >  >  > table >  >  > td >  > h1
        Elements bookName = document.select("#detail-box").select("div").select("div.ui_bg6").select("div.box_intro")
                .select("div.box_info").select("table").select("tbody").select("tr:nth-child(1)").select("td")
                .select("div:nth-child(1)").select("h1");
        System.out.println(bookName.text());
        // >  >  >  >  >
        Elements status = document.select("#detail-box").select("div").select("div.ui_bg6").select("div.box_intro")
                .select("div.pic").select("div:nth-child(9)");
        System.out.println(status.text());
        //#detail-box > div > div.ui_bg6 > div.box_intro > div.box_info > table > tbody > tr:nth-child(3) > td > div.intro
        Elements jj = document.select("#detail-box").select("div").select("div.ui_bg6").select("div.box_intro")
                .select("div.box_info").select("table").select("tbody").select("tr:nth-child(3)").select("td")
                .select("div.intro");
        System.out.println(jj.text());
        //#detail-box > div > div.ui_bg6 > div.box_intro > div.box_info > div.option > span.btopt > a
        Elements url = document.select("#detail-box").select("div").select("div.ui_bg6").select("div.box_intro")
                .select("div.box_info").select("div.option").select("span.btopt").select("a");
        String urls = url.attr("abs:href");
        Document document1 = Jsoup.connect(urls).get();
        // >  >  > ul > li:nth-child(1)
        Elements zj = document1.select("#header").select("div.warpper").select("div.mu_contain")
                .select("ul").select("li").select("a");
        for(Element e:zj){
           Document document11 = Jsoup.connect(e.attr("abs:href")).get();
           Elements title=document11.select("#content").select("div").select("div.h1title").select("h1");
           System.out.println(title.text());
           //
            Elements content = document11.select("#htmlContent");
            System.out.println(content.text());
        }
    // >  >  > h1

    }
}
