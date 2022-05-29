package org.xy.medicare.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.sql.Date;

/**
 * @description:编写个人信息实体
 * @author: XY-GYL
 * @time: 2022/5/28 19:03
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("person")
public class Person implements Serializable {

    @TableId("account")
    private String account;

    @TableField("bank_account")
    private String bankAccount;

    @TableField("telephone")
    private String telephone;

    @TableField("address")
    private String address;

}
