package com.wanbang.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private Integer id;
    private String username;
    private String avatar;
    private String phone;
    private Integer roleId;
}
