package com.qizhang.service_goods.controller;

import com.qizhang.common.pojo.Result;
import com.qizhang.common.pojo.StatusCode;
import com.qizhang.service_goods.service.BrandService;
import com.qizhang.service_goods_api.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
