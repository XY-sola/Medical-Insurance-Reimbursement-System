package org.xy.medicare.api;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xy.medicare.common.http.ResponseResult;
import org.xy.medicare.common.http.StatusCode;
import org.xy.medicare.form.AddMedicineForm;
import org.xy.medicare.form.IDForm;
import org.xy.medicare.form.ModifyMedicineForm;
import org.xy.medicare.form.SearchListByPageNumAndPageSizeForm;
import org.xy.medicare.service.impl.MedicineServiceImpl;
import org.xy.medicare.service.impl.RequestContentServiceImpl;

import javax.validation.Valid;
import java.util.Map;

/**
 * @description:查找、删除、添加药品的控制层接口
 * @author: XY-GYL
 * @time: 2022/5/29 17:18
 */

@CrossOrigin
@RestController
@RequestMapping("/api")
public class MedicineCtl {

    //自动封装服务层对象
    @Autowired
    private MedicineServiceImpl ser1;
    @Autowired
    private RequestContentServiceImpl ser2;

    /**
     * 获取全部药品信息分页列表
     *
     * @param form 包含页码和单页条数
     * @return JSON in response
     */
    @PostMapping("/searchAllMedicineList")
    public ResponseResult<PageInfo<Map<String, Object>>> searchAllMedicineListCtl(@RequestBody @Valid SearchListByPageNumAndPageSizeForm form) {
        PageInfo<Map<String, Object>> pager = ser1.findAllMedicineInPagesSer(form.getPageNum(), form.getPageSize());
        if (pager == null) {
            //药品信息列表为空，视为查询失败
            return ResponseResult.getMessageResult(null, "A041");
        } else {
            return ResponseResult.getMessageResult(pager, "A040", StatusCode.C200);
        }
    }

    /**
     * 根据药品编号删除医保人员
     *
     * @param form 包含药品编号
     * @return JSON in response
     */
    @PostMapping("/deleteMedicine")
    public ResponseResult<Boolean> deleteMedicineCtl(@RequestBody @Valid IDForm form) {
        if (ser2.countApplicationByMedicineNumSer(form.getId()) == 0) {
            boolean res = ser1.deleteMedicineByMedicineNumSer(form.getId());
            if (res) {
                return ResponseResult.getSuccessResult(true, "A042", null);
            } else {
                return ResponseResult.getMessageResult(false, "A043");
            }
        } else {
            return ResponseResult.getMessageResult(false, "A044");
        }
    }

    /**
     * 根据信息添加药品信息
     *
     * @param form
     * @return
     */
    @PostMapping("/addMedicine")
    public ResponseResult<Boolean> addMedicineByInformationCtl(@RequestBody @Valid AddMedicineForm form) {
        if (ser1.countMedicineByNameTypePriceSER(form.getMedicineName(), form.getMedicineType(), form.getMedicinePrice()) == 0) {
            boolean res = ser1.addMedicineByInformationSer(form.getMedicineName(), form.getMedicineType(), form.getMedicinePrice(), form.getMedicineProducer());
            if (res) {
                return ResponseResult.getSuccessResult(true, "A045", null);
            } else {
                return ResponseResult.getMessageResult(false, "A046");
            }
        } else {
            return ResponseResult.getMessageResult(false, "A047");
        }
    }

    /**
     * 根据信息修改药品信息
     *
     * @param form
     * @return
     */
    @PostMapping("/modifyMedicine")
    public ResponseResult<Boolean> modifyMedicineByInformationCtl(@RequestBody @Valid ModifyMedicineForm form) {
        boolean res = ser1.modifyMedicineByInformationSer(form.getMedicineNum(),form.getMedicineName(), form.getMedicineType(), form.getMedicinePrice(), form.getMedicineProducer());
        if (res) {
            return ResponseResult.getSuccessResult(true, "A048", null);
        } else {
            return ResponseResult.getMessageResult(false, "A049");
        }
    }
}
