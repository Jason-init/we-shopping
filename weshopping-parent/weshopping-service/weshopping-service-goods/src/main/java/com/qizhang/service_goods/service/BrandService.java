package com.qizhang.service_goods.service;

import com.github.pagehelper.Page;
import com.qizhang.service_goods_api.pojo.Brand;

import java.util.List;
import java.util.Map;

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

    /**
     * 品牌删除
     *
     * @param id 要删除品牌的id
     */
    void deleteById(Integer id);

    /**
     * 品牌列表条件查询
     *
     * @param searchMap 查询条件
     * @return 品牌列表
     */
    List<Brand> list(Map<String, Object> searchMap);

    /**
     * 品牌列表分页查询
     *
     * @param page 当前页码
     * @param size 每页数据数量
     * @return Page对象
     */
    Page<Brand> findPage(int page, int size);

    /**
     * 品牌列表条件查询 + 品牌列表分页查询
     *
     * @param searchMap 查询条件
     * @param page      当前页码
     * @param size      每页数据数量
     * @return Page对象
     */
    Page<Brand> findPage(Map<String, Object> searchMap, int page, int size);
}
