package org.xy.medicare.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

/**
 * @description:添加审批人员信息的表单
 * @author: XY-GYL
 * @time: 2022/5/29 15:13
 */

@Data
public class AddWorkerForm {

    //工号
    @NotBlank
    @Length(min=6,max=6)
    private String workerNum;

    //身份证号
    @NotBlank
    @Length(min=18,max=18)
    private String identityNum;

    //名字
    @NotBlank
    private String workerName;

    //性别
    @NotNull
    private Integer workerSex;

    //工作单位
    private String workerOrganization;

    //工作地点
    private String workerAddress;
    
}
