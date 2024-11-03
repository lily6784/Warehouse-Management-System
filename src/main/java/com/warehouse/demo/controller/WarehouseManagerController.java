package com.warehouse.demo.controller;

import com.warehouse.demo.po.FurniturePo;
import com.warehouse.demo.service.FurnitureService;
import com.warehouse.demo.util.WebResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse-manager")
public class WarehouseManagerController {

    @Autowired
    private FurnitureService furnitureService;

    //查看家具信息
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public WebResponse<List<FurniturePo>> select(@RequestParam(required = false) Long furnitureId,
                                      @RequestParam(required = false) String furnitureName,
                                      @RequestParam(required = false) String furnitureColor,
                                      @RequestParam(required = false) String furnitureCategory) {
        try {
            List<FurniturePo> list = furnitureService.select(furnitureId,furnitureName,furnitureColor,furnitureCategory);
            return new WebResponse<List<FurniturePo>>().success(list);
        } catch (Exception e) {
            return new WebResponse<List<FurniturePo>>().failure(e.getMessage());
        }
    }
}
