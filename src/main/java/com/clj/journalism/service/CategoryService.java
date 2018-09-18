package com.clj.journalism.service;

import com.clj.journalism.bean.Category;
import com.clj.journalism.mapper.CategoryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    protected static Logger logger = LoggerFactory.getLogger(CategoryService.class);
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> getCategroyArticleAll(){
        return categoryMapper.getCategroyArticleAll();
    }

    public List<Category> getCategroyArticleByCid(Integer cId){
        return categoryMapper.getCategroyArticleByCid(cId);
    }

    public Integer insert(String cName){
        return categoryMapper.insert(cName);
    }

    public List<Category> getCategoryAll(){
        return categoryMapper.getCategoryAll();
    }
}
