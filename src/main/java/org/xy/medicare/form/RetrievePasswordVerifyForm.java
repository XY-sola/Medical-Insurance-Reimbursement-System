package org.xy.medicare.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @description:RetrievePasswordVerify页面的表单
 * @author: XY-GYL
 * @time: 2022/5/26 17:43
 */

@Data
public class RetrievePasswordVerifyForm {

    //账号
    @NotBlank
    @Length(min = 6, max = 16)
    private String account;

    //身份证号
    @NotBlank
    @Length(min = 18, max = 18)
    private String identityCardNum;
}
