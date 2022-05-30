package org.xy.medicare.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @description:修改诊疗项目的表单
 * @author: XY-GYL
 * @time: 2022/5/30 7:34
 */

@Data
public class ModifyTreatmentForm {

    //诊疗项目编号
    @NotBlank
    @Length(min=36,max=36)
    private String treatmentNum;

    //诊疗项目名称
    @NotBlank
    private String treatmentName;

    //诊疗项目类别
    @NotNull
    private Integer treatmentType;

    //诊疗项目价格
    @NotNull
    private BigDecimal treatmentPrice;

    //个人自费比例
    @NotNull
    private double treatmentPercentage;
}
