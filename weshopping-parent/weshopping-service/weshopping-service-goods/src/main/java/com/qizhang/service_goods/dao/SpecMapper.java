package com.qizhang.service_goods.dao;


import com.qizhang.service_goods_api.pojo.Spec;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SpecMapper extends Mapper<Spec> {

    @Select("SELECT s.`name`, s.`options` FROM tb_spec s, tb_category c WHERE s.template_id = c.template_id AND c.`name` = #{categoryName}")
    public List<Map> findSpecListByCategoryName(@Param("categoryName") String categoryName);
}
