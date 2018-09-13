package com.clj.journalism.controller;

import com.clj.journalism.bean.Msg;
import com.clj.journalism.service.CategoryService;
import com.clj.journalism.service.NovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NovelController {

    @Autowired
    private NovelService novelService;


    @RequestMapping("pcNovelOne")
    public String test(String url,Integer cId) throws Exception{
        return novelService.addNovel(url,cId);
    }

    @GetMapping("getNovelAll")
    public Msg getNovelAll(){
        return Msg.success().add("success",novelService.getNovelAll());
    }

    @RequestMapping("pcNovelAll")
    public Msg pcNovelAll(String url,Integer cId) throws Exception{
        return Msg.success().add("success",novelService.pcNovelAll(url,cId));
    }
}
