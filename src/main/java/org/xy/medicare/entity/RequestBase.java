package org.xy.medicare.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @description:编写requeset_base的实体
 * @author: XY-GYL
 * @time: 2022/5/29 7:52
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("request_base")
public class RequestBase {

    @TableId("rb_id")
    private String rbId;

    @TableField("rb_user")
    private String rbUser;

    @TableField("rb_worker")
    private String rbWorker;

    @TableField("rb_institution")
    private String rbInstitution;

    @TableField("rb_type")
    private Integer rbType;

    @TableField("rb_status")
    private Integer rbStatus;

    @TableField("rb_money")
    private BigDecimal rbMoney;

    @TableField("rb_start_time")
    private Date rbStartTime;

    @TableField("rb_finish_time")
    private Date rbFinishTime;

    @TableField("rb_submit_time")
    private Date rbSubmitTime;

    @TableField("rb_fail_reason")
    private String rbFailReason;

}
