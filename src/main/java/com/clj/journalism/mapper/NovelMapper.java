package com.clj.journalism.mapper;

import com.clj.journalism.bean.Novel;
import com.clj.journalism.bean.NovelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NovelMapper {

    int insert(List<Novel> list);

    List<Novel> getNovelRead(Integer nId);

    List<Novel> getNovelByBid(Integer bId);

    Integer getNid(Integer bId);

}