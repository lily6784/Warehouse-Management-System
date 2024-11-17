package com.warehouse.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.warehouse.demo.mapper.UsersMapper;
import com.warehouse.demo.po.UsersPo;
import com.warehouse.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.warehouse.demo.mapper.InventoryhistoryMapper;
import com.warehouse.demo.po.InventoryhistoryPo;
import com.warehouse.demo.service.InventoryhistoryService;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class InventoryhistoryServiceImpl extends ServiceImpl<InventoryhistoryMapper, InventoryhistoryPo> implements InventoryhistoryService{

    @Autowired
    private InventoryhistoryService inventoryhistoryService;

    @Autowired
    private InventoryhistoryMapper inventoryhistoryMapper;

    @Override
    public List<InventoryhistoryPo> select(String historyId, String inventoryId) {
        LambdaQueryWrapper<InventoryhistoryPo> inventoryhistoryPoLambdaQueryWrapper = new LambdaQueryWrapper<InventoryhistoryPo>()
                .in(!StringUtils.isEmpty(historyId), InventoryhistoryPo::getHistoryId, historyId)
                .in(!StringUtils.isEmpty(inventoryId), InventoryhistoryPo::getInventoryId, inventoryId);
//                .orderByDesc(FurniturePo::getCreatedAt);
        List<InventoryhistoryPo> list = inventoryhistoryService.list(inventoryhistoryPoLambdaQueryWrapper);
        return list;

    }
}
