package com.qizhang.service_goods.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qizhang.service_goods.dao.BrandMapper;
import com.qizhang.service_goods.service.BrandService;
import com.qizhang.service_goods_api.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

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

    /**
     * 品牌删除
     *
     * @param id 要删除品牌的id
     */
    @Override
    @Transactional
    public void deleteById(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    /**
     * 品牌列表条件查询
     *
     * @param searchMap 查询条件
     * @return 品牌列表
     */
    @Override
    public List<Brand> list(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return brandMapper.selectByExample(example);
    }

    /**
     * 品牌列表分页查询
     *
     * @param page 当前页码
     * @param size 每页数据数量
     * @return Page对象
     */
    @Override
    public Page<Brand> findPage(int page, int size) {
        PageHelper.startPage(page, size);
        return (Page<Brand>) brandMapper.selectAll();
    }

    /**
     * 品牌列表条件查询 + 品牌列表分页查询
     *
     * @param searchMap 查询条件
     * @param page      当前页码
     * @param size      每页数据数量
     * @return Page对象
     */
    @Override
    public Page<Brand> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page, size);
        Example example = createExample(searchMap);
        return (Page<Brand>) brandMapper.selectByExample(example);

    }

    /**
     * 根据分类名称查询品牌列表
     *
     * @param categoryName
     * @return
     */
    @Override
    public List<Map> findBrandListByCategoryName(String categoryName) {
        List<Map> brandList = brandMapper.findBrandListByCategoryName(categoryName);
        return brandList;
    }

    private Example createExample(Map<String, Object> searchMap) {
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if (searchMap != null) {
            // 品牌名称
            if (searchMap.get("name") != null && !"".equals(searchMap.get("name"))) {
                criteria.andLike("name", "%" + searchMap.get("name") + "%");
            }
            // 品牌图片地址
            if (searchMap.get("image") != null && !"".equals(searchMap.get("image"))) {
                criteria.andLike("image", "%" + searchMap.get("image") + "%");
            }
            // 品牌的首字母
            if (searchMap.get("letter") != null && !"".equals(searchMap.get("letter"))) {
                criteria.andLike("letter", "%" + searchMap.get("letter") + "%");
            }

            // 品牌id
            if (searchMap.get("id") != null) {
                criteria.andEqualTo("id", searchMap.get("id"));
            }
            // 排序
            if (searchMap.get("seq") != null) {
                criteria.andEqualTo("seq", searchMap.get("seq"));
            }

        }
        return example;
    }
}
