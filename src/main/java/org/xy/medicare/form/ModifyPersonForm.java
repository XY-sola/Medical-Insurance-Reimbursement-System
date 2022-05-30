package org.xy.medicare.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @description:修改个人信息的表单
 * @author: XY-GYL
 * @time: 2022/5/30 13:36
 */

@Data
public class ModifyPersonForm {

    //账号
    @NotBlank
    @Length(min=6,max=16)
    private String account;

    //银行卡号
    @NotBlank
    @Length(min=15,max=20)
    private String bankAccount;

    //电话
    private String telephone;

    //家庭地址
    private String address;

}
