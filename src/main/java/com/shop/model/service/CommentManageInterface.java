package com.shop.model.service;

import com.shop.model.domain.Comment_table;

import java.util.List;

public interface CommentManageInterface {
    public static String cacheName = "commentCache";

    List<Comment_table> getCommentByGoodsId(Long goodsId);
    void addComment(Comment_table comment);

}
