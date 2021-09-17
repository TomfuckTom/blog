package com.chen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.pojo.Tag;

import java.util.List;

public interface TagMapper extends BaseMapper<Tag> {
    List<Tag> findTagsByArticleId(Long articleId);

    List<Long> findHotsTagIds(int limit);

    List<Tag> findTagsByIds(List<Long> tagIds);
}
