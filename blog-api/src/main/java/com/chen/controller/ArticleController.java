package com.chen.controller;

import com.chen.common.aop.LogAnnotation;
import com.chen.service.ArticleService;
import com.chen.vo.ArticleVo;
import com.chen.vo.Result;
import com.chen.vo.params.ArticleParam;
import com.chen.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    /*
    * 首页  文章列表
    * */
    @LogAnnotation(module = "文章",operation = "获取文章列表")
    @PostMapping
    //Result是统一结果返回
    public Result articles(@RequestBody PageParams pageParams) {
        //ArticleVo 页面接收的数据
        Result result = articleService.listArticle(pageParams);
        return result;
    }

    /*
     * 首页  最热文章
     * */
    @PostMapping("/hot")
    public Result hotArticle() {
        int limit = 5;
        Result result = articleService.hotArticle(limit);
        return result;
    }

    /*
     * 首页  最新文章
     * */
    @PostMapping("/new")
    public Result newArticle() {
        int limit = 3;
        Result result = articleService.newArticle(limit);
        return result;
    }

    /*
     * 首页  文章归档
     * */
    @PostMapping("/listArchives")
    public Result listArchives() {
        Result result = articleService.listArchives();
        return result;
    }

    @PostMapping("/view/{id}")
    public Result findArticleById(@PathVariable("id") Long id) {
        Result result = articleService.findArticleById(id);
        return result;
    }

    @PostMapping("/publish")
    public Result publish(@RequestBody ArticleParam articleParam){
        return articleService.publish(articleParam);
    }
}
