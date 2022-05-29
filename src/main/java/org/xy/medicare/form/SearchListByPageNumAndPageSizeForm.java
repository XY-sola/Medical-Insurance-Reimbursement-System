package org.xy.medicare.form;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @description:根据页面数和页面大小请求查询的表单
 * @author: XY-GYL
 * @time: 2022/5/27 19:35
 */

@Data
public class SearchListByPageNumAndPageSizeForm {

    //当前页码
    @NotNull
    @Min(1)
    private Integer pageNum;

    //一页多少数据
    @NotNull
    @Range(min=5, max=50)
    private Integer pageSize;
}
