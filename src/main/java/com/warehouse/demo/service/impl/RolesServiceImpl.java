package com.warehouse.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.warehouse.demo.mapper.RolesMapper;
import com.warehouse.demo.po.RolesPo;
import com.warehouse.demo.service.RolesService;
import org.springframework.stereotype.Service;

@Service
public class RolesServiceImpl extends ServiceImpl<RolesMapper, RolesPo> implements RolesService {

}
