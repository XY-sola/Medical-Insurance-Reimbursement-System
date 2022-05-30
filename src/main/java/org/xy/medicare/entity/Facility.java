package org.xy.medicare.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @description:service_facility的实体类
 * @author: XY-GYL
 * @time: 2022/5/30 8:25
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("service_facility")
public class Facility {

    @TableId("service_facility_num")
    private String facilityNum;

    @TableField("service_facility_name")
    private String facilityName;

    @TableField("service_facility_type")
    private Integer facilityType;

    @TableField("service_facility_price")
    private BigDecimal facilityPrice;

    @TableField("service_facility_percentage")
    private double facilityPercentage;

}
