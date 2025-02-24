package com.wanbang.common;

import java.util.Date;
import lombok.Data;

/**
 * 角色表
 * @TableName sys_role
 */
@Data
public class SysRole {
    /**
     * 角色ID
     */
    private Long id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色标识
     */
    private String roleKey;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 删除标记
     */
    private Integer isDeleted;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;


}