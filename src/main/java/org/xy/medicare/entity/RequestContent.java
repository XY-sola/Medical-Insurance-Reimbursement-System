package org.xy.medicare.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @description:编写requeset_content的实体
 * @author: XY-GYL
 * @time: 2022/5/29 17:36
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("request_content")
public class RequestContent {

    @TableId("uuid")
    private String uuid;

    @TableField("rc_id")
    private String rcId;

    @TableField("rc_type")
    private Integer rcType;

    @TableField("rc_item_id")
    private String rcItemId;

    @TableField("rc_item_quantity")
    private Integer rcItemQuantity;

}
