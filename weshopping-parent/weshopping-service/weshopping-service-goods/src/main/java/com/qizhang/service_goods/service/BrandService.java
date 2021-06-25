package com.qizhang.service_goods.service;

import com.qizhang.service_goods_api.pojo.Brand;

import java.util.List;

public interface BrandService {

    /**
     * 查询所有品牌的列表
     * @return 品牌列表
     */
    List<Brand> findList();
}
