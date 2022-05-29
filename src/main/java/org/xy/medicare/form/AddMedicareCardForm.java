package org.xy.medicare.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

/**
 * @description:添加医保人员信息的表单
 * @author: XY-GYL
 * @time: 2022/5/29 11:33
 */

@Data
public class AddMedicareCardForm {

    //医保号
    @NotBlank
    @Length(min=16,max=16)
    private String medicareCardNum;

    //身份证号
    @NotBlank
    @Length(min=18,max=18)
    private String identityCardNum;

    //医保类别
    @NotNull
    private Integer medicareType;

    //医保状态
    @NotNull
    private Integer medicareStatus;

    //名字
    @NotBlank
    private String medicareName;

    //性别
    @NotNull
    private Integer medicareSex;

    //年龄
    @NotNull
    private Integer medicareAge;

    //民族
    @NotBlank
    private String medicareNation;

    //参保时间
    private Date medicareTime;
}
