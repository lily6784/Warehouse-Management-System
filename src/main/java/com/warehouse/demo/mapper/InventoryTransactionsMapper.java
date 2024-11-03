package com.warehouse.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.warehouse.demo.po.InventoryTransactionsPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InventoryTransactionsMapper extends BaseMapper<InventoryTransactionsPo> {
}