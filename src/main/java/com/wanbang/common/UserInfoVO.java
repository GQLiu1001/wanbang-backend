package com.wanbang.common;

import lombok.Data;

@Data
public class UserInfoVO {
    private int id;
    private String username;
    private String phone;
    private String role_key;
    private String description;
}
