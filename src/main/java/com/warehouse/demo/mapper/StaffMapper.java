package com.warehouse.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.warehouse.demo.po.StaffPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StaffMapper extends BaseMapper<StaffPo> {
}