package com.wanbang.common;

import lombok.Data;

/**
 * 用户角色关联表
 * @TableName sys_user_role
 */
@Data
public class SysUserRole {
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;



}