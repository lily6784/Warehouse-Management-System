package com.warehouse.demo.controller;

import com.warehouse.demo.po.ProductPo;
import com.warehouse.demo.po.SalesPo;
import com.warehouse.demo.po.UsersPo;
import com.warehouse.demo.service.SalesService;
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
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    //查看用户信息
    @ApiOperation(value = "查询订单（支持模糊查询）" , notes = "查询订单（支持模糊查询）" , httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", paramType = "query", dataType = "String", value = "订单id", example = "1"),
            @ApiImplicitParam(name = "productId", paramType = "query", dataType = "String", value = "商品id", example = "1"),
            @ApiImplicitParam(name = "productName", paramType = "query", dataType = "String", value = "商品名称", example = "1"),
            @ApiImplicitParam(name = "customer", paramType = "query", dataType = "String", value = "顾客名称", example = "1"),
    })
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public WebResponse<List<SalesPo>> select(@RequestParam(required = false) String orderId,
                                             @RequestParam(required = false) String productId,
                                             @RequestParam(required = false) String productName,
                                             @RequestParam(required = false) String customer) {
        try {
            List<SalesPo> list = salesService.select(orderId,productId,productName,customer);
            return new WebResponse<List<SalesPo>>().success(list);
        } catch (Exception e) {
            return new WebResponse<List<SalesPo>>().failure(e.getMessage());
        }
    }

    @ApiOperation(value = "添加订单(返回1代表成功，返回0失败)" , notes = "添加订单(返回1代表成功，返回0失败)" , httpMethod = "POST")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public WebResponse<String> insert(@RequestBody SalesPo salesPo) {
        try {
            int i = salesService.insert(salesPo);
            return new WebResponse<String>().success(String.valueOf(i));
        } catch (Exception e) {
            return new WebResponse<String>().failure(e.getMessage());
        }
    }

    @ApiOperation(value = "根据主键批量删除订单" , notes = "根据主键批量删除订单" , httpMethod = "POST")
    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public WebResponse<Object> deleteByMulti(@RequestBody List<Long> ids) {
        try {
            int i = salesService.deleteByMulti(ids);
            return new WebResponse<Object>().success(i);
        } catch (Exception e) {
            return new WebResponse<Object>().failure(e.getMessage());
        }
    }
}
