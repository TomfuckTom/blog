package com.chen.service;


import com.chen.vo.Result;
import com.chen.vo.params.CommentParam;

public interface CommentsService {


    Result commentsByArticleId(Long articleId);

    Result comment(CommentParam commentParam);
}
