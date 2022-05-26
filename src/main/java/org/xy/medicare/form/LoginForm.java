package org.xy.medicare.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @description:Login页面的表单
 * @author: XY-GYL
 * @time: 2022/5/24 11:07
 */

@Data
public class LoginForm {

    //用户名
    @NotBlank
    @Length(min =3 ,max = 16)
    private String account;

    //密码
    @NotBlank
    @Length(min = 8,max = 20)
    private String password;
}
