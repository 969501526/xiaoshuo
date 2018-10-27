import com.clj.journalism.bean.Article;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception{
        // 创建输入流
        InputStream stream = new FileInputStream("F:\\ac.xls");
        // 获取Excel文件对象
        Workbook rwb = Workbook.getWorkbook(stream);
        // 获取文件的指定工作表 默认的第一个
        Sheet sheet = rwb.getSheet(0);
        List<Article> list = new ArrayList<Article>();
        Article article =null;
        // 行数(表头的目录不需要，从1开始)
        for (int i = 1; i < sheet.getRows(); i++) {
            // 创建一个数组 用来存储每一列的值
            String[] str = new String[sheet.getColumns()];
            Cell cell = null;
            String name=null;
            String content=null;
            // 列数
            article = new Article();
            for (int j = 0; j < sheet.getColumns(); j++) {
                article.setTitle(sheet.getCell(0, i).getContents());
                article.setContent(sheet.getCell(1, i).getContents());
                article.setUrl(sheet.getCell(2, i).getContents());
                article.setAddtime(sheet.getCell(3, i).getContents());
                article.setId(Integer.parseInt(sheet.getCell(4, i).getContents()));
            }
            list.add(article);
        }
        for(Article article1:list){
            System.out.println(article1);
        }
    }
}
