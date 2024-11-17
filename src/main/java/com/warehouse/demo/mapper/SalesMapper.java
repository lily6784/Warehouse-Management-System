package com.warehouse.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.warehouse.demo.po.SalesPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SalesMapper extends BaseMapper<SalesPo> {
}