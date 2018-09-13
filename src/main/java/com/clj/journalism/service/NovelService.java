package com.clj.journalism.service;

import com.clj.journalism.bean.Book;
import com.clj.journalism.bean.Novel;
import com.clj.journalism.mapper.BookMapper;
import com.clj.journalism.mapper.NovelMapper;
import com.clj.journalism.util.NovelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NovelService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private NovelMapper novelMapper;

    public String addNovel(String url) throws Exception{
        Book book = NovelUtil.bookpc(url);
        bookMapper.insert(book);
        List<Novel> novel = NovelUtil.novelpc(url);
        List<Novel> novelList = new ArrayList<Novel>();
        Novel n = null;
        for(Novel novel1:novel){
            n=new Novel();
            n.setContent(novel1.getContent());
            n.setbId(book.getbId());
            n.setTitle(novel1.getTitle());
            n.setcId(1);
            novelList.add(n);
        }

        novelMapper.insert(novelList);
        System.out.println(book.getbId());
        return "success";
    }
    public List<Book> getNovelAll(){
        return bookMapper.getNovelAll();
    }
}
