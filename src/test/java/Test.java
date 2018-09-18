import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import redis.clients.jedis.Jedis;


public class Test {

    public static void main(String[] args) throws Exception{
        //设置ip和接口
        Jedis jedis = new Jedis("134.175.57.67",6379);
        //保存数据
        jedis.set("name", "ddd");
        //获取数据
        String name = jedis.get("name");
        System.out.println(name);
        //关闭资源
        jedis.close();
    }
}
