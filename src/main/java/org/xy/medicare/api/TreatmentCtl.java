package org.xy.medicare.api;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xy.medicare.common.http.ResponseResult;
import org.xy.medicare.common.http.StatusCode;
import org.xy.medicare.form.*;
import org.xy.medicare.service.impl.MedicineServiceImpl;
import org.xy.medicare.service.impl.RequestContentServiceImpl;
import org.xy.medicare.service.impl.TreatmentServiceImpl;

import javax.validation.Valid;
import java.util.Map;

/**
 * @description:查找、删除、添加诊疗项目的控制层接口
 * @author: XY-GYL
 * @time: 2022/5/30 7:27
 */

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TreatmentCtl {

    //自动封装服务层对象
    @Autowired
    private TreatmentServiceImpl ser1;
    @Autowired
    private RequestContentServiceImpl ser2;

    /**
     * 获取全部诊疗项目分页列表
     *
     * @param form 包含页码和单页条数
     * @return JSON in response
     */
    @PostMapping("/searchAllTreatmentList")
    public ResponseResult<PageInfo<Map<String, Object>>> searchAllTreatmentListCtl(@RequestBody @Valid SearchListByPageNumAndPageSizeForm form) {
        PageInfo<Map<String, Object>> pager = ser1.findAllTreatmentInPagesSer(form.getPageNum(), form.getPageSize());
        if (pager == null) {
            //诊疗项目列表为空，视为查询失败
            return ResponseResult.getMessageResult(null, "A051");
        } else {
            return ResponseResult.getMessageResult(pager, "A050", StatusCode.C200);
        }
    }

    /**
     * 根据诊疗项目编号删除诊疗项目
     *
     * @param form 包含诊疗项目编号
     * @return JSON in response
     */
    @PostMapping("/deleteTreatment")
    public ResponseResult<Boolean> deleteTreatmentCtl(@RequestBody @Valid IDForm form) {
        if (ser2.countApplicationByTreatmentNumSer(form.getId()) == 0) {
            boolean res = ser1.deleteTreatmentByTreatmentNumSer(form.getId());
            if (res) {
                return ResponseResult.getSuccessResult(true, "A052", null);
            } else {
                return ResponseResult.getMessageResult(false, "A053");
            }
        } else {
            return ResponseResult.getMessageResult(false, "A054");
        }
    }

    /**
     * 根据信息添加诊疗项目
     *
     * @param form
     * @return
     */
    @PostMapping("/addTreatment")
    public ResponseResult<Boolean> addTreatmentByInformationCtl(@RequestBody @Valid AddTreatmentForm form) {
        if (ser1.countTreatmentByNameTypePricePercentageSER(form.getTreatmentName(),form.getTreatmentType(),form.getTreatmentPrice(),form.getTreatmentPercentage()) == 0) {
            boolean res = ser1.addTreatmentByInformationSer(form.getTreatmentName(),form.getTreatmentType(),form.getTreatmentPrice(),form.getTreatmentPercentage());
            if (res) {
                return ResponseResult.getSuccessResult(true, "A055", null);
            } else {
                return ResponseResult.getMessageResult(false, "A056");
            }
        } else {
            return ResponseResult.getMessageResult(false, "A057");
        }
    }

    /**
     * 根据信息修改诊疗项目
     *
     * @param form
     * @return
     */
    @PostMapping("/modifyTreatment")
    public ResponseResult<Boolean> modifyTreatmentByInformationCtl(@RequestBody @Valid ModifyTreatmentForm form) {
        boolean res = ser1.modifyTreatmentByInformationSer(form.getTreatmentNum(),form.getTreatmentName(),form.getTreatmentType(),form.getTreatmentPrice(),form.getTreatmentPercentage());
        if (res) {
            return ResponseResult.getSuccessResult(true, "A058", null);
        } else {
            return ResponseResult.getMessageResult(false, "A059");
        }
    }

}
