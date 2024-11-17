package com.warehouse.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.warehouse.demo.mapper.InventoryhistoryMapper;
import com.warehouse.demo.mapper.UsersMapper;
import com.warehouse.demo.po.InventoryhistoryPo;
import com.warehouse.demo.po.UsersPo;
import com.warehouse.demo.service.UsersService;
import com.warehouse.demo.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.warehouse.demo.po.InventoryPo;
import com.warehouse.demo.mapper.InventoryMapper;
import com.warehouse.demo.service.InventoryService;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class InventoryServiceImpl extends ServiceImpl<InventoryMapper, InventoryPo> implements InventoryService{

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private InventoryMapper inventoryMapper;

    @Autowired
    private InventoryhistoryMapper inventoryhistoryMapper;

    @Override
    public List<InventoryPo> select(String inventoryId, String productId) {
        LambdaQueryWrapper<InventoryPo> inventoryPoLambdaQueryWrapper = new LambdaQueryWrapper<InventoryPo>()
                .in(!StringUtils.isEmpty(inventoryId), InventoryPo::getInventoryId, inventoryId)
                .in(!StringUtils.isEmpty(productId), InventoryPo::getProductId, productId);
//                .orderByDesc(FurniturePo::getCreatedAt);
        List<InventoryPo> list = inventoryService.list(inventoryPoLambdaQueryWrapper);
        return list;
    }

    @Override
    public int update(InventoryPo inventoryPo) {
        if (inventoryPo.getProductId() == null) {
            throw new RuntimeException("productId不能为空");
        }
        int update = inventoryMapper.updateById(inventoryPo);
        if (update == 0) {
            return 0;
        }
        InventoryhistoryPo inventoryhistoryPo = new InventoryhistoryPo();
        inventoryhistoryPo.setHistoryId(String.valueOf(IdWorker.getNextId()));
        inventoryhistoryPo.setInventoryId(inventoryPo.getInventoryId());
        inventoryhistoryPo.setReason(inventoryPo.getReason());
        inventoryhistoryPo.setUpdateDate(new Date());
        inventoryhistoryMapper.insert(inventoryhistoryPo);
        return update;
    }
}
