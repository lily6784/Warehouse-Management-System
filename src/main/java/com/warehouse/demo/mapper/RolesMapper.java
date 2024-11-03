package com.warehouse.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.warehouse.demo.po.RolesPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RolesMapper extends BaseMapper<RolesPo> {
}