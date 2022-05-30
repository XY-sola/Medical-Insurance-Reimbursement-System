package org.xy.medicare.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @description:Medicine的实体类
 * @author: XY-GYL
 * @time: 2022/5/29 17:03
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("medicine")
public class Medicine {

    @TableId("medicine_num")
    private String medicineNum;

    @TableField("medicine_name")
    private String medicineName;

    @TableField("medicine_type")
    private Integer medicineType;

    @TableField("medicine_price")
    private BigDecimal medicinePrice;

    @TableField("medicine_producer")
    private String medicineProducer;

}
