package com.qizhang.service_user.controller;
import com.github.pagehelper.Page;
import com.qizhang.common.pojo.PageResult;
import com.qizhang.common.pojo.Result;
import com.qizhang.common.pojo.StatusCode;
import com.qizhang.service_user.service.AddressService;
import com.qizhang.service_user_api.pojo.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
@RestController
@CrossOrigin
@RequestMapping("/address")
public class AddressController {


    @Autowired
    private AddressService addressService;

    /**
     * 查询全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        List<Address> addressList = addressService.findAll();
        return new Result(true, StatusCode.OK,"查询成功",addressList) ;
    }

    /***
     * 根据ID查询数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        Address address = addressService.findById(id);
        return new Result(true,StatusCode.OK,"查询成功",address);
    }


    /***
     * 新增数据
     * @param address
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Address address){
        addressService.add(address);
        return new Result(true,StatusCode.OK,"添加成功");
    }


    /***
     * 修改数据
     * @param address
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Address address,@PathVariable Integer id){
        address.setId(id);
        addressService.update(address);
        return new Result(true,StatusCode.OK,"修改成功");
    }


    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        addressService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 多条件搜索品牌数据
     * @param searchMap
     * @return
     */
    @GetMapping(value = "/search" )
    public Result findList(@RequestParam Map searchMap){
        List<Address> list = addressService.findList(searchMap);
        return new Result(true,StatusCode.OK,"查询成功",list);
    }


    /***
     * 分页搜索实现
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestParam Map searchMap, @PathVariable  int page, @PathVariable  int size){
        Page<Address> pageList = addressService.findPage(searchMap, page, size);
        PageResult pageResult=new PageResult(pageList.getTotal(),pageList.getResult());
        return new Result(true,StatusCode.OK,"查询成功",pageResult);
    }


}
