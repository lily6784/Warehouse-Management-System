package com.warehouse.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.warehouse.demo.mapper.FurnitureMapper;
import com.warehouse.demo.po.FurniturePo;
import com.warehouse.demo.service.FurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class FurnitureServiceImpl extends ServiceImpl<FurnitureMapper, FurniturePo> implements FurnitureService {

    @Autowired
    private FurnitureService furnitureService;

    @Autowired
    private FurnitureMapper furnitureMapper;

    //查看家具信息
    @Override
    public List<FurniturePo> select(Long furnitureId,String furnitureName,String furnitureColor,String furnitureCategory) {
        LambdaQueryWrapper<FurniturePo> furniturePoLambdaQueryWrapper = new LambdaQueryWrapper<FurniturePo>()
                .like(!StringUtils.isEmpty(furnitureName), FurniturePo::getFurnitureName, furnitureName)
                .in(!StringUtils.isEmpty(furnitureId), FurniturePo::getFurnitureId, furnitureId)
                .in(!StringUtils.isEmpty(furnitureCategory), FurniturePo::getFurnitureCategory, furnitureCategory)
                .in(!StringUtils.isEmpty(furnitureColor), FurniturePo::getFurnitureColor, furnitureColor);
//                .orderByDesc(FurniturePo::getCreatedAt);
        List<FurniturePo> list = furnitureService.list(furniturePoLambdaQueryWrapper);
        return list;
    }
}
