package com.clj.journalism.service;

import com.clj.journalism.bean.Category;
import com.clj.journalism.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> getCategroyArticleAll(){
        return categoryMapper.getCategroyArticleAll();
    }

    public List<Category> getCategroyArticleByCid(Integer cId){
        return categoryMapper.getCategroyArticleByCid(cId);
    }


}
