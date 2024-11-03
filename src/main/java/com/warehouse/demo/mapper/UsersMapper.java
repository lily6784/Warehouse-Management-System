package com.warehouse.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.warehouse.demo.po.UsersPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper extends BaseMapper<UsersPo> {
}