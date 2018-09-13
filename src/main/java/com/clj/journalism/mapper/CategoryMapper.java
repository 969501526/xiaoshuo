package com.clj.journalism.mapper;

import com.clj.journalism.bean.Category;
import java.util.List;

public interface CategoryMapper {

    List<Category> getCategroyArticleAll();

    List<Category> getCategroyArticleByCid(Integer cId);

    List<Category> getNovelAll();

    List<Category> getCategoryAndNovelAndBook();

    List<Category> getCategoryAndNovelAndBookBycId(Integer cId);

    List<Category> getBookAndNovelById(Integer bId);
}