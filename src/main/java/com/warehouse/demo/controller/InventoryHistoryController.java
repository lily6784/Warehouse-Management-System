package com.warehouse.demo.controller;

import com.warehouse.demo.po.InventoryPo;
import com.warehouse.demo.po.InventoryhistoryPo;
import com.warehouse.demo.service.InventoryService;
import com.warehouse.demo.service.InventoryhistoryService;
import com.warehouse.demo.util.WebResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inventory-history")
public class InventoryHistoryController {

    @Autowired
    private InventoryhistoryService inventoryhistoryService;

    //查看用户信息
    @ApiOperation(value = "根据库存id查询库存历史" , notes = "根据库存id查询库存历史" , httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "historyId", paramType = "query", dataType = "String", value = "库存历史id", example = "1"),
            @ApiImplicitParam(name = "inventoryId", paramType = "query", dataType = "String", value = "库存id", example = "1"),
    })
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public WebResponse<List<InventoryhistoryPo>> select(@RequestParam(required = false) String historyId,
                                                        @RequestParam(required = false) String inventoryId) {
        try {
            List<InventoryhistoryPo> list = inventoryhistoryService.select(historyId,inventoryId);
            return new WebResponse<List<InventoryhistoryPo>>().success(list);
        } catch (Exception e) {
            return new WebResponse<List<InventoryhistoryPo>>().failure(e.getMessage());
        }
    }
}
