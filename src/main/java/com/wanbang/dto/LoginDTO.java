package com.wanbang.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginDTO {
    private Integer id;
    private String username;
    private String avatar;
    private String phone;
    @JsonProperty("role_id")
    private Integer roleId;
}
