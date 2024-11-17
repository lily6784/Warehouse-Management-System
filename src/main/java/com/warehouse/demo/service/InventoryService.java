package com.warehouse.demo.service;

import com.warehouse.demo.po.InventoryPo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface InventoryService extends IService<InventoryPo>{


    List<InventoryPo> select(String inventoryId, String productId);

    int update(InventoryPo inventoryPo);
}
