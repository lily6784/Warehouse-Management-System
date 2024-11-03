package com.warehouse.demo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName(value = "STAFF")
public class StaffPo implements Serializable {
    @TableId(value = "STAFF_ID", type = IdType.INPUT)
    private Long staffId;

    @TableField(value = "STAFF_NAME")
    private String staffName;

    @TableField(value = "ROLE_ID")
    private Long roleId;

    private static final long serialVersionUID = 1L;

}