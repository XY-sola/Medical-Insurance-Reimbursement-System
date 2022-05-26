package org.xy.medicare.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.sql.Date;

/**
 * @description:编写医保卡（医保人员）实体
 * @author: XY-GYL
 * @time: 2022/5/26 15:07
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("medicare_card")
public class MedicareCard implements Serializable {

    @TableId("medicare_card_num")
    private String medicareCardNum;

    @TableField("identity_card_num")
    private String identityCardNum;

    @TableField("medicare_type")
    private Integer medicareType;

    @TableField("medicare_status")
    private Integer medicareStatus;

    @TableField("medicare_name")
    private String medicareName;

    @TableField("medicare_sex")
    private Integer medicareSex;

    @TableField("medicare_age")
    private Integer medicareAge;

    @TableField("medicare_nation")
    private String medicareNation;

    @TableField("insurance_time")
    private Date insuranceTime;
}
