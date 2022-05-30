package org.xy.medicare.api;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xy.medicare.common.http.ResponseResult;
import org.xy.medicare.common.http.StatusCode;
import org.xy.medicare.form.*;
import org.xy.medicare.service.impl.FacilityServiceImpl;
import org.xy.medicare.service.impl.RequestContentServiceImpl;

import javax.validation.Valid;
import java.util.Map;

/**
 * @description:查找、删除、添加服务设施的控制层接口
 * @author: XY-GYL
 * @time: 2022/5/30 10:09
 */

@CrossOrigin
@RestController
@RequestMapping("/api")
public class FacilityCtl {

    //自动封装服务层对象
    @Autowired
    private FacilityServiceImpl ser1;
    @Autowired
    private RequestContentServiceImpl ser2;

    /**
     * 获取全部服务设施分页列表
     *
     * @param form 包含页码和单页条数
     * @return JSON in response
     */
    @PostMapping("/searchAllFacilityList")
    public ResponseResult<PageInfo<Map<String, Object>>> searchAllFacilityListCtl(@RequestBody @Valid SearchListByPageNumAndPageSizeForm form) {
        PageInfo<Map<String, Object>> pager = ser1.findAllFacilityInPagesSer(form.getPageNum(), form.getPageSize());
        if (pager == null) {
            //服务设施列表为空，视为查询失败
            return ResponseResult.getMessageResult(null, "A061");
        } else {
            return ResponseResult.getMessageResult(pager, "A060", StatusCode.C200);
        }
    }

    /**
     * 根据服务设施编号删除服务设施
     *
     * @param form 包含服务设施编号
     * @return JSON in response
     */
    @PostMapping("/deleteFacility")
    public ResponseResult<Boolean> deleteFacilityCtl(@RequestBody @Valid IDForm form) {
        if (ser2.countApplicationByFacilityNumSer(form.getId()) == 0) {
            boolean res = ser1.deleteFacilityByFacilityNumSer(form.getId());
            if (res) {
                return ResponseResult.getSuccessResult(true, "A062", null);
            } else {
                return ResponseResult.getMessageResult(false, "A063");
            }
        } else {
            return ResponseResult.getMessageResult(false, "A064");
        }
    }

    /**
     * 根据信息添加服务设施
     *
     * @param form
     * @return
     */
    @PostMapping("/addFacility")
    public ResponseResult<Boolean> addFacilityByInformationCtl(@RequestBody @Valid AddFacilityForm form) {
        if (ser1.countFacilityByNameTypePricePercentageSER(form.getFacilityName(), form.getFacilityType(), form.getFacilityPrice(), form.getFacilityPercentage()) == 0) {
            boolean res = ser1.addFacilityByInformationSer(form.getFacilityName(), form.getFacilityType(), form.getFacilityPrice(), form.getFacilityPercentage());
            if (res) {
                return ResponseResult.getSuccessResult(true, "A065", null);
            } else {
                return ResponseResult.getMessageResult(false, "A066");
            }
        } else {
            return ResponseResult.getMessageResult(false, "A067");
        }
    }

    /**
     * 根据信息修改服务设施
     *
     * @param form
     * @return
     */
    @PostMapping("/modifyFacility")
    public ResponseResult<Boolean> modifyFacilityByInformationCtl(@RequestBody @Valid ModifyFacilityForm form) {
        boolean res = ser1.modifyFacilityByInformationSer(form.getFacilityNum(), form.getFacilityName(), form.getFacilityType(), form.getFacilityPrice(), form.getFacilityPercentage());
        if (res) {
            return ResponseResult.getSuccessResult(true, "A068", null);
        } else {
            return ResponseResult.getMessageResult(false, "A069");
        }
    }

}
