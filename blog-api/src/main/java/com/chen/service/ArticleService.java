package com.chen.service;

import com.chen.vo.ArticleVo;
import com.chen.vo.Result;
import com.chen.vo.params.ArticleParam;
import com.chen.vo.params.PageParams;

import java.util.List;

public interface ArticleService {
    Result listArticle(PageParams pageParams);

    Result hotArticle(int limit);

    Result newArticle(int limit);

    Result listArchives();

    Result findArticleById(Long id);

    Result publish(ArticleParam articleParam);
}
