package org.xy.medicare.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @description:Treatment的实体类
 * @author: XY-GYL
 * @time: 2022/5/29 22:05
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("treatment_project")
public class Treatment {

    @TableId("treatment_project_num")
    private String treatmentNum;

    @TableField("treatment_project_name")
    private String treatmentName;

    @TableField("treatment_project_type")
    private Integer treatmentType;

    @TableField("treatment_project_price")
    private BigDecimal treatmentPrice;

    @TableField("treatment_project_percentage")
    private double treatmentPercentage;

}
