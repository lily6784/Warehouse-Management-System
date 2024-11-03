package com.warehouse.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.warehouse.demo.mapper.InventoryTransactionsMapper;
import com.warehouse.demo.po.InventoryTransactionsPo;
import com.warehouse.demo.service.InventoryTransactionsService;
import org.springframework.stereotype.Service;

@Service
public class InventoryTransactionsServiceImpl extends ServiceImpl<InventoryTransactionsMapper, InventoryTransactionsPo> implements InventoryTransactionsService {

}
