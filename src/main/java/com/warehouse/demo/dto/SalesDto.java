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
import java.util.Date;

@ApiModel(description="SALES")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "SALES")
public class SalesDto implements Serializable {
    /**
     * 订单ID主键
     */
    @TableId(value = "ORDER_ID", type = IdType.INPUT)
    @ApiModelProperty(value="订单ID主键")
    private String orderId;

    /**
     * 商品名称
     */
    @TableField(value = "PRODUCT_ID")
    @ApiModelProperty(value="商品id")
    private String productId;

    @TableField(value = "PRODUCT_NAME")
    @ApiModelProperty(value="商品名称")
    private String productName;

    /**
     * 对应的客户名字
     */
    @TableField(value = "CUSTOMER")
    @ApiModelProperty(value="对应的客户名字")
    private String customer;

    /**
     * 销售数量
     */
    @TableField(value = "QUANTITY_SOLD")
    @ApiModelProperty(value="销售数量")
    private BigDecimal quantitySold;

    /**
     * 总价 (quantity sold * product price)
     */
    @TableField(value = "TOTAL_SALES")
    @ApiModelProperty(value="总价 (quantity sold * product price)")
    private BigDecimal totalSales;

    /**
     * 销售日期
     */
    @TableField(value = "SALE_DATE")
    @ApiModelProperty(value="销售日期")
    private Date saleDate;

    private static final long serialVersionUID = 1L;
}