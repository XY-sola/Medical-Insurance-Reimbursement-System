package org.xy.medicare.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @description:institution的实体类
 * @author: XY-GYL
 * @time: 2022/5/30 8:29
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("institution")
public class Institution {

    @TableId("institution_num")
    private String institutionNum;

    @TableField("institution_name")
    private String institutionName;

    @TableField("institution_type")
    private Integer institutionType;

    @TableField("institution_telephone")
    private String institutionTelephone;

    @TableField("institution_address")
    private String institutionAddress;

}
