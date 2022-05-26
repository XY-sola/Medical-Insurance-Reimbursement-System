package org.xy.medicare.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @description:
 * @author: XY-GYL
 * @time: 2022/5/26 14:31
 */

@Data
public class RegisterForm {

    //用户名
    @NotBlank
    @Length(min=6,max=16)
    private String account;

    //密码
    @NotBlank
    @Length(min=8,max=20)
    private String password;

    //确认密码
    @NotBlank
    @Length(min=8,max=20)
    private String passwordRepeat;

    //用户角色
    @NotNull
    private Integer userRole;
}
