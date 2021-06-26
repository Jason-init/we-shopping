package com.qizhang.service_goods.service.impl;

import com.qizhang.service_goods.dao.BrandMapper;
import com.qizhang.service_goods.service.BrandService;
import com.qizhang.service_goods_api.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private BrandMapper brandMapper;

    @Autowired
    public void setBrandMapper(BrandMapper brandMapper) {
        this.brandMapper = brandMapper;
    }

    /**
     * 查询所有品牌的列表
     *
     * @return 品牌列表
     */
    @Override
    public List<Brand> findList() {
        return brandMapper.selectAll();
    }

    /**
     * 根据id查询品牌数据
     *
     * @param id 品牌id
     * @return 单个品牌数据
     */
    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    /**
     * 添加品牌
     *
     * @param brand 新增品牌对象
     */
    @Override
    @Transactional
    public void add(Brand brand) {
        brandMapper.insertSelective(brand);
    }

    /**
     * 品牌修改
     *
     * @param brand 被修改的品牌对象
     */
    @Override
    @Transactional
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKey(brand);
    }
}
