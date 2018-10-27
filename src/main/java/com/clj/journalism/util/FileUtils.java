package com.clj.journalism.util;

import com.clj.journalism.bean.Article;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    /**
     *
     * @param file 文件
     * @param path   文件存放路径
     * @param fileName 原文件名
     * @return
     */
    public static String upload(MultipartFile file,  String fileName) throws Exception{
        File path = new File(ResourceUtils.getURL("classpath:").getPath());


        // 生成新的文件名
        String realPath = path.getAbsolutePath()+"/static/file" + "/" + Upload.getFileName(fileName);
        System.out.println(Upload.getFileName(fileName));

        //使用原文件名
        // String realPath = path + "/" + fileName;

        File dest = new File(realPath);
        if(!dest.getName().endsWith(".xls")||dest.getName().endsWith(".xlsx")){
            return "格式错误";
        }
        //判断文件父目录是否存在
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }

        try {
            //保存文件
            file.transferTo(dest);
            return realPath;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return "error";
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }

    /**
     *
     * 解析excel
     */
    public static List<Article> excel(String path) throws Exception{
        // 创建输入流
        InputStream stream = new FileInputStream(path);
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
       return list;
    }
}
