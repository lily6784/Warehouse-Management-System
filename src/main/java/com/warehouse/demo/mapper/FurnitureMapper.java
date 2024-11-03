package com.warehouse.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.warehouse.demo.po.FurniturePo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FurnitureMapper extends BaseMapper<FurniturePo> {
}
