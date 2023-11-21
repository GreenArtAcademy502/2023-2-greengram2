package com.green.greengram2.feed;

import com.green.greengram2.feed.model.FeedInsProcDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedMapper {
    int insFeed(FeedInsProcDto dto);
    int insFeedPics(FeedInsProcDto dto);
}
