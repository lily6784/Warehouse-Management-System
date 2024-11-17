package com.warehouse.demo.controller;

import com.warehouse.demo.po.ProductPo;
import com.warehouse.demo.po.UsersPo;
import com.warehouse.demo.service.ProductService;
import com.warehouse.demo.service.UsersService;
import com.warehouse.demo.util.WebResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    //查看商品信息
    @ApiOperation(value = "查询商品" , notes = "查询商品" , httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "query", dataType = "String", value = "id", example = "1"),
            @ApiImplicitParam(name = "name", paramType = "query", dataType = "String", value = "姓名", example = "1"),
            @ApiImplicitParam(name = "type", paramType = "query", dataType = "String", value = "类型", example = "1"),
            @ApiImplicitParam(name = "price", paramType = "query", dataType = "BigDecimal", value = "价格", example = "1"),
    })
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public WebResponse<List<ProductPo>> select(@RequestParam(required = false) String id,
                                               @RequestParam(required = false) String name,
                                               @RequestParam(required = false) String type,
                                               @RequestParam(required = false) BigDecimal price) {
        try {
            List<ProductPo> list = productService.select(id,name,type,price);
            return new WebResponse<List<ProductPo>>().success(list);
        } catch (Exception e) {
            return new WebResponse<List<ProductPo>>().failure(e.getMessage());
        }
    }


    @ApiOperation(value = "添加商品(返回1代表成功，返回0失败)" , notes = "添加商品(返回1代表成功，返回0失败)" , httpMethod = "POST")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public WebResponse<String> insert(@RequestBody ProductPo productPo) {
        try {
            int i = productService.insert(productPo);
            return new WebResponse<String>().success(String.valueOf(i));
        } catch (Exception e) {
            return new WebResponse<String>().failure(e.getMessage());
        }
    }

    @ApiOperation(value = "根据主键更改商品(返回1代表成功，返回0失败)" , notes = "根据主键更改商品(返回1代表成功，返回0失败)" , httpMethod = "POST")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public WebResponse<String> updateById(@RequestBody ProductPo productPo) {
        try {
            int i = productService.update(productPo);
            return new WebResponse<String>().success(String.valueOf(i));
        } catch (Exception e) {
            return new WebResponse<String>().failure(e.getMessage());
        }
    }

    @ApiOperation(value = "根据主键批量删除商品" , notes = "根据主键批量删除商品" , httpMethod = "POST")
    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public WebResponse<Object> deleteByMulti(@RequestBody List<Long> ids) {
        try {
            int i = productService.deleteByMulti(ids);
            return new WebResponse<Object>().success(i);
        } catch (Exception e) {
            return new WebResponse<Object>().failure(e.getMessage());
        }
    }
}
