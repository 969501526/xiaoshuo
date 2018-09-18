package com.clj.journalism.controller;

import com.clj.journalism.bean.Book;
import com.clj.journalism.bean.Category;
import com.clj.journalism.bean.Msg;
import com.clj.journalism.bean.Novel;
import com.clj.journalism.service.CategoryService;
import com.clj.journalism.service.NovelService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NovelController {

    @Autowired
    private NovelService novelService;

    /**
     * 单本小说获取
     * @param url
     * @param cId
     * @return
     * @throws Exception
     */
    @RequestMapping("pcNovelOne")
    public String test(String url,Integer cId) throws Exception{
        return novelService.addNovel(url,cId);
    }

    /**
     * 根据小说类型获取
     * @param url
     * @param cId
     * @return
     * @throws Exception
     */
    @RequestMapping("pcNovelAll")
    public Msg pcNovelAll(String url,Integer cId) throws Exception{
        return Msg.success().add("success",novelService.pcNovelAll(url,cId));
    }

    /**
     * 获取所有小说的书名类型章节
     * @return
     */
    @GetMapping("getNovelAll")
    public Msg getNovelAll(Integer pageNum,Integer pageSize){
        return Msg.success().add("success",novelService.getCategoryAndNovelAndBook());
    }

    /**
     * 根据类型获取小说的书名类型章节
     * @param cId
     * @return
     */
    @GetMapping("getNovelBycId")
    public Msg getNovelBycId(Integer cId){

        return Msg.success().add("success",novelService.getCategoryAndNovelAndBookBycId(cId));
    }

    /**
     * 小说详情
     * @param bId
     * @return
     */
    @GetMapping("getBookAndNovelById")
    public Msg getBookAndNovelById(Integer bId){
        return Msg.success().add("success",novelService.getBookAndNovelById(bId));
    }

    /**
     * 小说阅读
     * @param nId
     * @return
     */
    @GetMapping("getNovelRead")
    public Msg getNovelRead(Integer nId){
        return Msg.success().add("success",novelService.getNovelRead(nId));
    }

    /**
     * 小说目录
     * @param bId
     * @return
     */
    @GetMapping("getNovelCatalog")
    public Msg getNovelCatalog(Integer pageNum,Integer pageSize,Integer bId){
        if(pageNum==null||pageNum<=0){
            pageNum=1;
        }
        if(pageSize==null){
            pageSize=20;
        }
        PageHelper.startPage(pageNum,pageSize);
        List<Book> list = novelService.getNovelCatalog(bId);
        PageInfo<Book> result = new PageInfo<Book>(list);
        return Msg.success().add("success",result);
    }

    /**
     * 小说内容分页
     * @param pageNum
     * @param pageSize
     * @param bId
     * @return。
     */
    @GetMapping("getNovelBybId")
    public Msg getNovelByBid(Integer pageNum,Integer pageSize,Integer bId){
        if(pageNum==null){
            pageNum=1;
        }
        if(pageSize==null){
            pageSize=1;
        }
        PageHelper.startPage(pageNum,pageSize);
        List<Novel> list = novelService.getNovelByBid(bId);
        PageInfo<Novel> result = new PageInfo<Novel>(list);
        return Msg.success().add("success",result);
    }
}
