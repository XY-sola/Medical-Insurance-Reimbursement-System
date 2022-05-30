package org.xy.medicare.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @description:添加药品信息的表单
 * @author: XY-GYL
 * @time: 2022/5/29 18:02
 */

@Data
public class AddMedicineForm {

    //药品名称
    @NotBlank
    private String medicineName;

    //药品类别
    @NotNull
    private Integer medicineType;

    //药品价格
    @NotNull
    private BigDecimal medicinePrice;

    //药品厂商
    private String medicineProducer;

}
