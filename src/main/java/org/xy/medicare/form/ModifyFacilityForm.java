package org.xy.medicare.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @description:修改服务设施的表单
 * @author: XY-GYL
 * @time: 2022/5/30 8:33
 */

@Data
public class ModifyFacilityForm {

    //服务设施编号
    @NotBlank
    @Length(min=36,max=36)
    private String facilityNum;

    //服务设施名称
    @NotBlank
    private String facilityName;

    //服务设施类别
    @NotNull
    private Integer facilityType;

    //服务设施价格
    @NotNull
    private BigDecimal facilityPrice;

    //个人自费比例
    @NotNull
    private double facilityPercentage;
}
