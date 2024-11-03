package com.warehouse.demo.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.math.BigDecimal;

@TableName(value = "USERS")
public class UsersDto implements Serializable {
    @TableId(value = "USER_ID", type = IdType.INPUT)
    private BigDecimal userId;

    @TableField(value = "USERNAME")
    private String username;

    @TableField(value = "USER_TYPE")
    private String userType;

    @TableField(value = "USER_PERMISSIONS")
    private String userPermissions;

    @TableField(value = "\"PASSWORD\"")
    private String password;

    private static final long serialVersionUID = 1L;

}