package com.warehouse.demo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName(value = "ROLES")
public class RolesPo implements Serializable {
    @TableId(value = "ROLE_ID", type = IdType.INPUT)
    private Long roleId;

    @TableField(value = "ROLE_NAME")
    private String roleName;

}