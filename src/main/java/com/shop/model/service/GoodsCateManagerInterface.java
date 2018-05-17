package com.shop.model.service;

import org.apache.ibatis.annotations.Param;

public interface GoodsCateManagerInterface {
    int getCateIdByGoodsId(int goodsId);
    int getGoodsIdByCateId(int cateId);
}
