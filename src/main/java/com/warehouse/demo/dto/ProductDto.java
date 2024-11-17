package com.warehouse.demo.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(description="PRODUCT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "PRODUCT")
public class ProductDto implements Serializable {
    /**
     * 商品ID主键
     */
    @TableId(value = "PRODUCT_ID", type = IdType.INPUT)
    @ApiModelProperty(value="商品ID主键")
    private String productId;

    /**
     * 商品名称
     */
    @TableField(value = "\"NAME\"")
    @ApiModelProperty(value="商品名称")
    private String name;

    /**
     * 商品类型
     */
    @TableField(value = "\"TYPE\"")
    @ApiModelProperty(value="商品类型")
    private String type;

    /**
     * 商品价格
     */
    @TableField(value = "PRICE")
    @ApiModelProperty(value="商品价格")
    private BigDecimal price;

    private static final long serialVersionUID = 1L;
}