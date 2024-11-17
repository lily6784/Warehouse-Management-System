package com.warehouse.demo.controller;

import com.warehouse.demo.po.InventoryPo;
import com.warehouse.demo.po.ProductPo;
import com.warehouse.demo.po.UsersPo;
import com.warehouse.demo.service.InventoryService;
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
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    //查看用户信息
    @ApiOperation(value = "根据商品id查询库存" , notes = "根据商品id查询库存" , httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "inventoryId", paramType = "query", dataType = "String", value = "库存id", example = "1"),
            @ApiImplicitParam(name = "productId", paramType = "query", dataType = "String", value = "商品id", example = "1"),
    })
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public WebResponse<List<InventoryPo>> select(@RequestParam(required = false) String inventoryId,
                                                 @RequestParam(required = false) String productId) {
        try {
            List<InventoryPo> list = inventoryService.select(inventoryId,productId);
            return new WebResponse<List<InventoryPo>>().success(list);
        } catch (Exception e) {
            return new WebResponse<List<InventoryPo>>().failure(e.getMessage());
        }
    }

    @ApiOperation(value = "根据商品主键更改库存(返回1代表成功，返回0失败)" , notes = "根据商品主键更改库存(返回1代表成功，返回0失败)" , httpMethod = "POST")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public WebResponse<String> updateById(@RequestBody InventoryPo inventoryPo) {
        try {
            int i = inventoryService.update(inventoryPo);
            return new WebResponse<String>().success(String.valueOf(i));
        } catch (Exception e) {
            return new WebResponse<String>().failure(e.getMessage());
        }
    }
}
