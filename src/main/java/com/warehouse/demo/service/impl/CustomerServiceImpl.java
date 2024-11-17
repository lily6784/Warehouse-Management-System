package com.warehouse.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.warehouse.demo.mapper.UsersMapper;
import com.warehouse.demo.po.UsersPo;
import com.warehouse.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.warehouse.demo.mapper.CustomerMapper;
import com.warehouse.demo.po.CustomerPo;
import com.warehouse.demo.service.CustomerService;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, CustomerPo> implements CustomerService{

    @Autowired
    private CustomerService customerService;


    @Override
    public List<CustomerPo> select(String id, String name, String email) {
        LambdaQueryWrapper<CustomerPo> customerPoLambdaQueryWrapper = new LambdaQueryWrapper<CustomerPo>()
                .like(!StringUtils.isEmpty(name), CustomerPo::getCustomer, name)
                .in(!StringUtils.isEmpty(id), CustomerPo::getCustomerId, id)
                .in(!StringUtils.isEmpty(email), CustomerPo::getEmail, email);
//                .orderByDesc(FurniturePo::getCreatedAt);
        List<CustomerPo> list = customerService.list(customerPoLambdaQueryWrapper);
        return list;
    }
}
