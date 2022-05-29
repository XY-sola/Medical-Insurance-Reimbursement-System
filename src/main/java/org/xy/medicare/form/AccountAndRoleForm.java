package org.xy.medicare.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @description:记录了account和userRole的表单
 * @author: XY-GYL
 * @time: 2022/5/28 20:17
 */

@Data
public class AccountAndRoleForm {

    //账号
    @NotBlank
    @Length(min=6,max=16)
    private String account;

    //用户角色
    @NotNull
    private Integer userRole;

}
