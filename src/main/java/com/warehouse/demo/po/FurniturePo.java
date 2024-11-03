package com.warehouse.demo.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * (Furniture)表实体类
 *
 * @author makejava
 * @since 2024-11-03 02:14:34
 */
@Data
@TableName(value = "furniture")
public class FurniturePo implements Serializable {
    @TableId("furniture_id")
    private BigDecimal furnitureId;

    @TableField("furniture_name")
    private String furnitureName;

    @TableField("furniture_category")
    private String furnitureCategory;

    @TableField("furniture_material")
    private String furnitureMaterial;

    @TableField("furniture_color")
    private String furnitureColor;

    @TableField("furniture_dimensions")
    private String furnitureDimensions;

    @TableField("furniture_weight")
    private Long furnitureWeight;

    @TableField("furniture_price")
    private String furniturePrice;

    @TableField("furniture_manufacturer")
    private String furnitureManufacturer;

    @TableField("stock_quantity")
    private Long stockQuantity;

    @TableField("furniture_description")
    private String furnitureDescription;

    @TableField("created_at")
    private Date createdAt;

    @TableField("created_at")
    private Date updatedAt;

}

