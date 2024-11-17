package com.warehouse.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.warehouse.demo.mapper.UsersMapper;
import com.warehouse.demo.po.UsersPo;
import com.warehouse.demo.service.UsersService;
import com.warehouse.demo.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.warehouse.demo.mapper.SalesMapper;
import com.warehouse.demo.po.SalesPo;
import com.warehouse.demo.service.SalesService;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class SalesServiceImpl extends ServiceImpl<SalesMapper, SalesPo> implements SalesService{

    @Autowired
    private SalesService salesService;

    @Autowired
    private SalesMapper salesMapper;


    @Override
    public List<SalesPo> select(String orderId, String productId, String productName, String customer) {
        LambdaQueryWrapper<SalesPo> salesPoLambdaQueryWrapper = new LambdaQueryWrapper<SalesPo>()
                .like(!StringUtils.isEmpty(productName), SalesPo::getProductName, productName)
                .like(!StringUtils.isEmpty(customer), SalesPo::getCustomer, customer)
                .in(!StringUtils.isEmpty(orderId), SalesPo::getProductId, productId)
                .in(!StringUtils.isEmpty(productId), SalesPo::getOrderId, orderId);
//                .orderByDesc(FurniturePo::getCreatedAt);
        List<SalesPo> list = salesService.list(salesPoLambdaQueryWrapper);
        return list;
    }

    @Override
    public int insert(SalesPo salesPo) {
        //设置主键id
        Long ruleId = IdWorker.getNextId();
        salesPo.setProductId(String.valueOf(ruleId));
        int insert = salesMapper.insert(salesPo);
        return insert;
    }

    @Override
    public int deleteByMulti(List<Long> ids) {
        int i = salesMapper.deleteBatchIds(ids);
        return i;
    }
}
