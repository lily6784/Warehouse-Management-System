package com.warehouse.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.warehouse.demo.mapper.UsersMapper;
import com.warehouse.demo.po.UsersPo;
import com.warehouse.demo.service.UsersService;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, UsersPo> implements UsersService {

}