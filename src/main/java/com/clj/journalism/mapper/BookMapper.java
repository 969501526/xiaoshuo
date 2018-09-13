package com.clj.journalism.mapper;

import com.clj.journalism.bean.Book;
import com.clj.journalism.bean.BookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookMapper {

    int insert(Book record);

    List<Book> getNovelAll();

}