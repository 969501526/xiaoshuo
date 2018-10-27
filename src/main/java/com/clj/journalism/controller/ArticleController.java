package com.clj.journalism.controller;

import com.clj.journalism.bean.ArtiCate;
import com.clj.journalism.bean.Article;
import com.clj.journalism.bean.Msg;
import com.clj.journalism.service.ArticleService;
import com.clj.journalism.util.FileUtils;
import com.clj.journalism.util.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ArticleController {

   @Autowired
   private ArticleService articleService;
//
    @RequestMapping("addArticle")
    public Msg addArticle() throws Exception{
       articleService.addArticle();

       return Msg.success().add("success","成功");
    }

    @RequestMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception{
        String contentType = file.getContentType();   //图片文件类型
        System.out.println(contentType);
        String fileName = file.getOriginalFilename();  //图片名字
        String path=FileUtils.upload(file, fileName);
        //获取excel表数据
        List<Article> list=FileUtils.excel(path);
        //将excel表数据添加到数据库
        List<Article> a=articleService.addArticles(list);
        List<ArtiCate> zjb = new ArrayList<ArtiCate>();
        ArtiCate artiCate = null;
        for(int i=0;i<list.size();i++){
           Integer cId= list.get(i).getcId();
           if (cId!=null){
               artiCate = new ArtiCate();
               artiCate.setcId(cId);
               artiCate.setaId(a.get(i).getId());
               zjb.add(artiCate);
           }
        }
        articleService.addArtiCate(zjb);
            return "上传成功";
    }

    @RequestMapping("aa")
    public List<Article> getArticleAll(){
        return articleService.getArticleAll();
    }
}
