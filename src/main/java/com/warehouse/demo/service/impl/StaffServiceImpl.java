package com.warehouse.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.warehouse.demo.mapper.StaffMapper;
import com.warehouse.demo.po.StaffPo;
import com.warehouse.demo.service.StaffService;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, StaffPo> implements StaffService {

}