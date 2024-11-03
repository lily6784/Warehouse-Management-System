package com.warehouse.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.warehouse.demo.po.FurniturePo;

import java.util.List;

public interface FurnitureService extends IService<FurniturePo> {

    //查看家具信息
    List<FurniturePo> select(Long furnitureId,String furnitureName,String furnitureColor,String furnitureCategory);
}
