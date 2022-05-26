package org.xy.medicare.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @description:编写用户实体
 * @author: XY-GYL
 * @time: 2022/5/24 11:01
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
public class User implements Serializable {

    @TableId("account")
    private String account;

    @TableField("password")
    private String password;

    @TableField("user_role")
    private Integer userRole;
}
