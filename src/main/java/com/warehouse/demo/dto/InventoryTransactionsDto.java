package com.warehouse.demo.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "INVENTORY_TRANSACTIONS")
public class InventoryTransactionsDto implements Serializable {

    private Long transactionId;


    private Long furnitureId;


    private Long staffId;


    private String transactionType;


    private Long quantity;


    private Date transactionDate;

    private static final long serialVersionUID = 1L;


}