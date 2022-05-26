package org.xy.medicare.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @description:RetrievePasswordModify页面的表单
 * @author: XY-GYL
 * @time: 2022/5/26 20:40
 */

@Data
public class RetrievePasswordModifyForm {

    //账号
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
}
