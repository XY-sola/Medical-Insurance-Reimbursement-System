package org.xy.medicare.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @description:添加定点机构的表单
 * @author: XY-GYL
 * @time: 2022/5/30 8:32
 */

@Data
public class AddInstitutionForm {

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
