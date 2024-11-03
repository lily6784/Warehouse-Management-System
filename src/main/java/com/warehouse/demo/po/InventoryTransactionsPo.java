package com.warehouse.demo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "INVENTORY_TRANSACTIONS")
public class InventoryTransactionsPo implements Serializable {
    @TableId(value = "TRANSACTION_ID", type = IdType.INPUT)
    private Long transactionId;

    @TableField(value = "FURNITURE_ID")
    private Long furnitureId;

    @TableField(value = "STAFF_ID")
    private Long staffId;

    @TableField(value = "TRANSACTION_TYPE")
    private String transactionType;

    @TableField(value = "QUANTITY")
    private Long quantity;

    @TableField(value = "TRANSACTION_DATE")
    private Date transactionDate;

    private static final long serialVersionUID = 1L;


}