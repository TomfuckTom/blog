package com.chen.service;


import com.chen.vo.CategoryVo;
import com.chen.vo.Result;

public interface CategoryService {

    CategoryVo findCategoryById(Long id);

    Result findAll();

    Result findAllDetail();

    Result categoriesDetailById(Long id);
}
