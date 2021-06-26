package com.qizhang.service_goods.service;

import com.qizhang.service_goods_api.pojo.Brand;

import java.util.List;

public interface BrandService {

    /**
     * 查询所有品牌的列表
     *
     * @return 品牌列表
     */
    List<Brand> findList();

    /**
     * 根据id查询品牌数据
     *
     * @param id 品牌id
     * @return 单个品牌数据
     */
    Brand findById(Integer id);

    /**
     * 添加品牌
     *
     * @param brand 新增品牌对象
     */
    void add(Brand brand);

    /**
     * 品牌修改
     *
     * @param brand 被修改的品牌对象
     */
    void update(Brand brand);
}
