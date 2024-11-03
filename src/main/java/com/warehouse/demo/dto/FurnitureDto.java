package com.warehouse.demo.dto;

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
public class FurnitureDto implements Serializable {
    
    private BigDecimal furnitureId;
    
    private String furnitureName;
    
    private String furnitureCategory;
    
    private String furnitureMaterial;
    
    private String furnitureColor;
    
    private String furnitureDimensions;
    
    private Long furnitureWeight;
    
    private String furniturePrice;
    
    private String furnitureManufacturer;
    
    private Long stockQuantity;
    
    private String furnitureDescription;
    
    private Date createdAt;
    
    private Date updatedAt;

}

