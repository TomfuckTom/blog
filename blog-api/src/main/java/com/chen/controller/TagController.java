package com.chen.controller;

import com.chen.service.TagsService;
import com.chen.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tags")
public class TagController {
    @Autowired
    private TagsService tagsService;

    @GetMapping("/hot")
    public Result hot(){
        int limit = 6;
        return tagsService.hot(limit);
    }

    @GetMapping
    public Result findAll(){
        return tagsService.findAll();
    }

    @GetMapping("detail")
    public Result findAllDetail(){
        return tagsService.findAllDetail();
    }

    @GetMapping("detail/{id}")
    public Result findDetailById(@PathVariable("id") Long id){
        return tagsService.findDetailById(id);
    }
}
