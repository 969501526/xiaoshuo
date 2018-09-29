package com.clj.journalism.service;

import com.clj.journalism.bean.Book;
import com.clj.journalism.bean.Category;
import com.clj.journalism.bean.Novel;
import com.clj.journalism.bean.UserBook;
import com.clj.journalism.mapper.BookMapper;
import com.clj.journalism.mapper.CategoryMapper;
import com.clj.journalism.mapper.NovelMapper;
import com.clj.journalism.util.NovelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class NovelService {

    protected static Logger logger = LoggerFactory.getLogger(NovelService.class);

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private NovelMapper novelMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    public String addNovel(String url,Integer cId) throws Exception{
        Book book = NovelUtil.bookpc(url);
        List<Book> bookName = bookMapper.getBookName(book.getBookName());
        if(bookName.isEmpty()){
            book.setcId(cId);
            bookMapper.insert(book);
            List<Novel> novel = NovelUtil.novelpc(url);
            List<Novel> novelList = new ArrayList<Novel>();
            Novel n = null;
            for(Novel novel1:novel){
                n=new Novel();
                n.setContent(novel1.getContent());
                n.setbId(book.getbId());
                n.setTitle(novel1.getTitle());
                novelList.add(n);
            }

            novelMapper.insert(novelList);
            logger.info("添加"+book.getBookName()+"成功");
            return "success";
        }else{
            return book.getBookName()+"已存在";
        }


    }
    public List<Book> getNovelAll(){
        return bookMapper.getNovelAll();
    }

    public String pcNovelAll(String url,Integer cId) throws Exception{
        List<String> urls = NovelUtil.getUrl(url);
        for(String str : urls){
            System.out.println("url="+str);
            Book book =  NovelUtil.bookpc(str);
        if(book.getBookName()!=null||book.getBookName().equals("")) {
            List<Book> bookName = bookMapper.getBookName(book.getBookName());
            if (bookName.isEmpty()) {
                book.setcId(cId);
                bookMapper.insert(book);
                List<Novel> list = NovelUtil.novelpc(str);
                List<Novel> novelList = new ArrayList<Novel>();
                Novel n = null;
                for (Novel novel1 : list) {
                    n = new Novel();
                    n.setContent(novel1.getContent());
                    n.setbId(book.getbId());
                    n.setTitle(novel1.getTitle());
                    novelList.add(n);
                }
                novelMapper.insert(novelList);
                System.out.println(book.getbId());
            } else {
                System.out.println(book.getBookName() + "已存在");
            }
        }else {
            System.out.println("错误的链接-跳过");
        }
        }
        return "success";
    }

    /**
     * 获取全部小说信息
     * @return
     */
    public List<Category> getCategoryAndNovelAndBook(){

        return categoryMapper.getCategoryAndNovelAndBook();
    }

    /**
     * 根据类型加载小说
     * @param cId
     * @return
     */
    public List<Category> getCategoryAndNovelAndBookBycId(Integer cId){
        return categoryMapper.getCategoryAndNovelAndBookBycId(cId);
    }

    public List<Category> getBookAndNovelById(Integer bId){
        return categoryMapper.getBookAndNovelById(bId);
    }

    public List<Novel> getNovelRead(Integer nId){
        return novelMapper.getNovelRead(nId);
    }

    public List<Book> getNovelCatalog(Integer bId){
        return bookMapper.getNovelCatalog(bId);
    }

    public List<Novel> getNovelByBid(Integer bId){
        return novelMapper.getNovelByBid(bId);
    }

    /**
     * 获取默认章节
     * @param bId
     * @return
     */
    public Integer getNid(Integer bId){
        return novelMapper.getNid(bId);
    }


}
