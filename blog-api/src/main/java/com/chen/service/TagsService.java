package com.chen.service;

import com.chen.vo.Result;
import com.chen.vo.TagVo;

import java.util.List;

public interface TagsService {
    List<TagVo> findTagsByArticleId(Long articleId);

    Result hot(int limit);

    Result findAll();

    Result findAllDetail();

    Result findDetailById(Long id);
}
