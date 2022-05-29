package org.xy.medicare.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @description:记录了ID的表单
 * @author: XY-GYL
 * @time: 2022/5/29 8:17
 */

@Data
public class IDForm {

    //账号
    @NotBlank
    @Length(min=6,max=36)
    private String id;//写成ID时，前端依旧传id

}
