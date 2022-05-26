package org.xy.medicare.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @description:编写工作人员实体
 * @author: XY-GYL
 * @time: 2022/5/26 15:06
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("worker")
public class Worker implements Serializable {

    @TableId("worker_num")
    private String workerNum;

    @TableField("worker_name")
    private String workerName;

    @TableField("worker_identity_num")
    private String workerIdentityNum;

    @TableField("worker_sex")
    private Integer workerSex;

    @TableField("worker_organization")
    private String workerOrganization;

    @TableField("worker_address")
    private String workerAddress;
}
