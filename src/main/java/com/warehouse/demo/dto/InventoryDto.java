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

@ApiModel(description="INVENTORY")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "INVENTORY")
public class InventoryDto implements Serializable {
    /**
     * 库存ID主键
     */
    @TableId(value = "INVENTORY_ID", type = IdType.INPUT)
    @ApiModelProperty(value="库存ID主键")
    private String inventoryId;

    /**
     * 商品ID
     */
    @TableField(value = "PRODUCT_ID")
    @ApiModelProperty(value="商品ID")
    private String productId;

    /**
     * 库存数量
     */
    @TableField(value = "QUANTITY")
    @ApiModelProperty(value="库存数量")
    private BigDecimal quantity;

    /**
     * 几号员工更新了库存
     */
    @TableField(value = "UPDATED_BY")
    @ApiModelProperty(value="几号员工更新了库存")
    private BigDecimal updatedBy;

    /**
     * 是否还有库存 (1 for yes, 0 for no)
     */
    @TableField(value = "IS_IN_STORE")
    @ApiModelProperty(value="是否还有库存 (1 for yes, 0 for no)")
    private BigDecimal isInStore;

    private static final long serialVersionUID = 1L;
}