package org.xy.medicare.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @description:修改定点机构的表单
 * @author: XY-GYL
 * @time: 2022/5/30 8:33
 */

@Data
public class ModifyInstitutionForm {

    //定点机构编号
    @NotBlank
    @Length(min=36,max=36)
    private String institutionNum;

    //定点机构名称
    @NotBlank
    private String institutionName;

    //定点机构类别
    @NotNull
    private Integer institutionType;

    //定点机构电话
    private String institutionTelephone;

    //定点机构地址
    private String institutionAddress;

}
