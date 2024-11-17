package com.warehouse.demo.service;

import com.warehouse.demo.po.CustomerPo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface CustomerService extends IService<CustomerPo>{


    List<CustomerPo> select(String id, String name, String email);
}
