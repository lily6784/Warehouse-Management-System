package com.warehouse.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.warehouse.demo.dto.UsersDto;
import com.warehouse.demo.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.warehouse.demo.mapper.UsersMapper;
import com.warehouse.demo.po.UsersPo;
import com.warehouse.demo.service.UsersService;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.rmi.ServerException;
import java.util.List;

@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, UsersPo> implements UsersService{

    @Autowired
    private UsersService usersService;

    @Autowired
    private UsersMapper usersMapper;

    //查看用户信息
    @Override
    public List<UsersPo> select(BigDecimal id, String name, String role) {
        LambdaQueryWrapper<UsersPo> usersPoLambdaQueryWrapper = new LambdaQueryWrapper<UsersPo>()
                .like(!StringUtils.isEmpty(name), UsersPo::getName, name)
                .in(!StringUtils.isEmpty(id), UsersPo::getUserId, id)
                .in(!StringUtils.isEmpty(role), UsersPo::getRole, role);
//                .orderByDesc(FurniturePo::getCreatedAt);
        List<UsersPo> list = usersService.list(usersPoLambdaQueryWrapper);
        return list;
    }

    @Override
    public int insert(UsersPo userPo) {
        //设置主键id
        Long ruleId = IdWorker.getNextId();
        userPo.setUserId(BigDecimal.valueOf(ruleId));
        int insert = usersMapper.insert(userPo);
        return insert;
    }

    @Override
    public int update(UsersPo usersPo) {
        if (usersPo.getUserId() == null) {
            throw new RuntimeException("userId不能为空");
        }
        int update = usersMapper.updateById(usersPo);
        return update;
    }

    @Override
    public int deleteByMulti(List<Long> ids) {
        int i = usersMapper.deleteBatchIds(ids);
        return i;
    }
}
