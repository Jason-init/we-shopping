package com.qizhang.service_goods.service.impl;

import com.qizhang.service_goods.dao.BrandMapper;
import com.qizhang.service_goods.service.BrandService;
import com.qizhang.service_goods_api.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
