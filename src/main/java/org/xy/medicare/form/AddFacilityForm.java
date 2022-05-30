package org.xy.medicare.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @description:添加服务设施的表单
 * @author: XY-GYL
 * @time: 2022/5/30 8:32
 */

@Data
public class AddFacilityForm {

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
