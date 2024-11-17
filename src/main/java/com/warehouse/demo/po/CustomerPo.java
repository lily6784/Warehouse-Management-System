package com.warehouse.demo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description="CUSTOMER")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "CUSTOMER")
public class CustomerPo implements Serializable {
    /**
     * 客户ID主键
     */
    @TableId(value = "CUSTOMER_ID", type = IdType.INPUT)
    @ApiModelProperty(value="客户ID主键")
    private String customerId;

    /**
     * 客户名字
     */
    @TableField(value = "CUSTOMER")
    @ApiModelProperty(value="客户名字")
    private String customer;

    /**
     * 客户邮箱
     */
    @TableField(value = "EMAIL")
    @ApiModelProperty(value="客户邮箱")
    private String email;

    private static final long serialVersionUID = 1L;
}