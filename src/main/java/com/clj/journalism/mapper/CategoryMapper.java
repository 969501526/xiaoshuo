package com.clj.journalism.mapper;

import com.clj.journalism.bean.Category;
import java.util.List;

public interface CategoryMapper {

    List<Category> getCategroyArticleAll();

    List<Category> getCategroyArticleByCid(Integer cId);
}