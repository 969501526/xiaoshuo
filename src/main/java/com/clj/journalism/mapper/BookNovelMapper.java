package com.clj.journalism.mapper;

import com.clj.journalism.bean.BookNovel;
import com.clj.journalism.bean.BookNovelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookNovelMapper {
    long countByExample(BookNovelExample example);

    int deleteByExample(BookNovelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BookNovel record);

    int insertSelective(BookNovel record);

    List<BookNovel> selectByExample(BookNovelExample example);

    BookNovel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BookNovel record, @Param("example") BookNovelExample example);

    int updateByExample(@Param("record") BookNovel record, @Param("example") BookNovelExample example);

    int updateByPrimaryKeySelective(BookNovel record);

    int updateByPrimaryKey(BookNovel record);
}