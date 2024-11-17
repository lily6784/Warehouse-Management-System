package com.warehouse.demo.service;

import com.warehouse.demo.po.InventoryhistoryPo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface InventoryhistoryService extends IService<InventoryhistoryPo>{


    List<InventoryhistoryPo> select(String historyId, String inventoryId);
}
