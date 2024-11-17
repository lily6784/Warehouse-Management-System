package com.warehouse.demo.service;

import com.warehouse.demo.dto.UsersDto;
import com.warehouse.demo.po.UsersPo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;
import java.util.List;

public interface UsersService extends IService<UsersPo>{

    //查看用户信息
    List<UsersPo> select(BigDecimal id, String name, String role);

    int insert(UsersPo usersPo);

    int update(UsersPo usersPo);

    int deleteByMulti(List<Long> ids);
}
