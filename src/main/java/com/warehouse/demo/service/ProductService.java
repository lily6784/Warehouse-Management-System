package com.warehouse.demo.service;

import com.warehouse.demo.po.ProductPo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService extends IService<ProductPo>{

    //查看商品信息
    List<ProductPo> select(String id, String name, String type, BigDecimal price);

    int insert(ProductPo productPo);

    int update(ProductPo productPo);

    int deleteByMulti(List<Long> ids);
}
