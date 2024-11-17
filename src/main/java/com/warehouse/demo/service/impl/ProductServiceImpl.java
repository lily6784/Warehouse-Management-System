package com.warehouse.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.warehouse.demo.mapper.UsersMapper;
import com.warehouse.demo.po.UsersPo;
import com.warehouse.demo.service.UsersService;
import com.warehouse.demo.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.warehouse.demo.po.ProductPo;
import com.warehouse.demo.mapper.ProductMapper;
import com.warehouse.demo.service.ProductService;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, ProductPo> implements ProductService{

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    //查看商品信息
    @Override
    public List<ProductPo> select(String id, String name, String type, BigDecimal price) {
        LambdaQueryWrapper<ProductPo> productPoLambdaQueryWrapper = new LambdaQueryWrapper<ProductPo>()
                .like(!StringUtils.isEmpty(name), ProductPo::getName, name)
                .in(!StringUtils.isEmpty(id), ProductPo::getProductId, id)
                .in(!StringUtils.isEmpty(type), ProductPo::getType, type)
                .in(!StringUtils.isEmpty(price), ProductPo::getPrice, price);
//                .orderByDesc(FurniturePo::getCreatedAt);
        List<ProductPo> list = productService.list(productPoLambdaQueryWrapper);
        return list;
    }

    @Override
    public int insert(ProductPo productPo) {
        //设置主键id
        Long ruleId = IdWorker.getNextId();
        productPo.setProductId(String.valueOf(ruleId));
        int insert = productMapper.insert(productPo);
        return insert;
    }

    @Override
    public int update(ProductPo productPo) {
        if (productPo.getProductId() == null) {
            throw new RuntimeException("productId不能为空");
        }
        int update = productMapper.updateById(productPo);
        return update;
    }

    @Override
    public int deleteByMulti(List<Long> ids) {
        int i = productMapper.deleteBatchIds(ids);
        return i;
    }
}



























