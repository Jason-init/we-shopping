package com.qizhang.service_goods.controller;

import com.qizhang.common.pojo.Result;
import com.qizhang.common.pojo.StatusCode;
import com.qizhang.service_goods.service.BrandService;
import com.qizhang.service_goods_api.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/brand")
@RestController
public class BrandController {

    private BrandService brandService;

    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public Result<List<Brand>> findList() {
        return new Result<>(true, StatusCode.OK, "查询成功", brandService.findList());
    }

    @GetMapping("/{id}")
    public Result<Brand> findById(@PathVariable("id") Integer id) {
        return new Result<>(true, StatusCode.OK, "查询成功", brandService.findById(id));
    }

    @PostMapping
    public Result<Void> add(@RequestBody Brand brand) {
        brandService.add(brand);
        return new Result<>(true, StatusCode.OK, "添加成功");
    }

    @PutMapping("/{id}")
    public Result<Void> update(@PathVariable("id") Integer id, @RequestBody Brand brand) {
        brand.setId(id);
        brandService.update(brand);
        return new Result<>(true, StatusCode.OK, "修改成功");
    }
}
