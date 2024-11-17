package com.warehouse.demo.service;

import com.warehouse.demo.po.SalesPo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface SalesService extends IService<SalesPo>{


    List<SalesPo> select(String orderId, String productId, String productName, String customer);

    int insert(SalesPo salesPo);

    int deleteByMulti(List<Long> ids);
}
