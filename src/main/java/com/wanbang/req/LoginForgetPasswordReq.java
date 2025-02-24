package com.wanbang.req;

import lombok.Data;
//忘记密码Req
@Data
public class LoginForgetPasswordReq {
    private String username;
    private String phone;
    private String newPassword;
}
