package com.green.greengram2.feed.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FeedCommentInsDto {
    private int ifeed;
    private int iuser;
    private String comment;
}
