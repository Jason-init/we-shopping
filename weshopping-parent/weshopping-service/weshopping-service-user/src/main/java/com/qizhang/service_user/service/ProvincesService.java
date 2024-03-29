package com.qizhang.service_user.service;

import com.github.pagehelper.Page;
import com.qizhang.service_user_api.pojo.Provinces;

import java.util.List;
import java.util.Map;

public interface ProvincesService {

    /***
     * 查询所有
     * @return
     */
    List<Provinces> findAll();

    /**
     * 根据ID查询
     * @param provinceid
     * @return
     */
    Provinces findById(String provinceid);

    /***
     * 新增
     * @param provinces
     */
    void add(Provinces provinces);

    /***
     * 修改
     * @param provinces
     */
    void update(Provinces provinces);

    /***
     * 删除
     * @param provinceid
     */
    void delete(String provinceid);

    /***
     * 多条件搜索
     * @param searchMap
     * @return
     */
    List<Provinces> findList(Map<String, Object> searchMap);

    /***
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    Page<Provinces> findPage(int page, int size);

    /***
     * 多条件分页查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    Page<Provinces> findPage(Map<String, Object> searchMap, int page, int size);




}
