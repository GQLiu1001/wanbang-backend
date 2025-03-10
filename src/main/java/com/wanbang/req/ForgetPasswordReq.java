package com.wanbang.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
//忘记密码Req
@Data
public class ForgetPasswordReq {
    private String username;
    private String phone;
    @JsonProperty("newPassword")
    private String newPassword;
}
