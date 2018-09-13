package com.clj.journalism.controller;

import com.clj.journalism.bean.Category;
import com.clj.journalism.bean.Msg;
import com.clj.journalism.service.CategoryService;
import com.clj.journalism.service.NovelService;
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
    public Msg getNovelAll(){
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
}
