package com.warehouse.demo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description="INVENTORYHISTORY")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "INVENTORYHISTORY")
public class InventoryhistoryPo implements Serializable {
    /**
     * 库存历史ID主键
     */
    @TableId(value = "HISTORY_ID", type = IdType.INPUT)
    @ApiModelProperty(value="库存历史ID主键")
    private String historyId;

    /**
     * 相关的库存ID
     */
    @TableField(value = "INVENTORY_ID")
    @ApiModelProperty(value="相关的库存ID")
    private String inventoryId;

    /**
     * 变更的数量
     */
    @TableField(value = "CHANGE_QUANTITY")
    @ApiModelProperty(value="变更的数量")
    private BigDecimal changeQuantity;

    /**
     * 几号员工变更的
     */
    @TableField(value = "UPDATED_BY")
    @ApiModelProperty(value="几号员工变更的")
    private BigDecimal updatedBy;

    /**
     * 变更的日期
     */
    @TableField(value = "UPDATE_DATE")
    @ApiModelProperty(value="变更的日期")
    private Date updateDate;

    /**
     * 更新的原因
     */
    @TableField(value = "REASON")
    @ApiModelProperty(value="更新的原因")
    private String reason;

    private static final long serialVersionUID = 1L;
}