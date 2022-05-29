package org.xy.medicare.api;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xy.medicare.common.http.ResponseResult;
import org.xy.medicare.common.http.StatusCode;
import org.xy.medicare.form.AccountAndRoleForm;
import org.xy.medicare.form.AddMedicareCardForm;
import org.xy.medicare.form.IDForm;
import org.xy.medicare.form.SearchListByPageNumAndPageSizeForm;
import org.xy.medicare.service.impl.MedicareCardServiceImpl;
import org.xy.medicare.service.impl.PersonServiceImpl;
import org.xy.medicare.service.impl.RequestBaseServiceImpl;
import org.xy.medicare.service.impl.UserServiceImpl;

import javax.validation.Valid;
import java.sql.Date;
import java.util.Map;

/**
 * @description:medicare_card实体的控制层接口
 * @author: XY-GYL
 * @time: 2022/5/28 17:17
 */

@CrossOrigin
@RestController
@RequestMapping("/api")
public class MedicareCardCtl {


    //自动封装服务层对象
    @Autowired
    private MedicareCardServiceImpl ser1;
    @Autowired
    private RequestBaseServiceImpl ser2;
    @Autowired
    private UserServiceImpl ser3;
    @Autowired
    private PersonServiceImpl ser4;

    /**
     * 获取未注册医保人员信息分页列表
     *
     * @param form 包含页码和单页条数
     * @return JSON in response
     */
    @PostMapping("/searchNotRegisterMedicareList")
    public ResponseResult<PageInfo<Map<String, Object>>> searchNotRegisterMedicareListCtl(@RequestBody @Valid SearchListByPageNumAndPageSizeForm form) {
        PageInfo<Map<String, Object>> pager = ser1.findNotRegisterMedicareCardInPagesSer(form.getPageNum(), form.getPageSize());
        if (pager == null) {
            return ResponseResult.getMessageResult(null, "A019");
        } else {
            return ResponseResult.getMessageResult(pager, "A018", StatusCode.C200);
        }
    }

    /**
     * 获取全部医保人员信息分页列表
     *
     * @param form 包含页码和单页条数
     * @return JSON in response
     */
    @PostMapping("/searchAllMedicareList")
    public ResponseResult<PageInfo<Map<String, Object>>> searchAllMedicareListCtl(@RequestBody @Valid SearchListByPageNumAndPageSizeForm form) {
        PageInfo<Map<String, Object>> pager = ser1.findAllMedicareCardInPagesSer(form.getPageNum(), form.getPageSize());
        if (pager == null) {
            return ResponseResult.getMessageResult(null, "A025");
        } else {
            return ResponseResult.getMessageResult(pager, "A024", StatusCode.C200);
        }
    }

    /**
     * 根据医保号删除医保人员
     * @param form 包含医保号
     * @return JSON in response
     */
    @PostMapping("/deleteMedicareCard")
    public ResponseResult<Boolean> deleteMedicareCardCtl(@RequestBody @Valid IDForm form) {
        if(ser2.countApplicationByMedicareCardIdSer(form.getId())==0){
            //严谨的应该判断有无账户再进行账户删除，这里直接全部删除，因此判断用 或
            boolean res1 = ser4.deletePersonByAccountSer(form.getId());
            boolean res2 = ser3.deleteUserByAccountSer(form.getId());
            boolean res3 = ser1.deleteMedicareCardByMedicareCardNumSer(form.getId());
            if (res1 || res2 || res3) {
                return ResponseResult.getSuccessResult(true, "A026", null);
            } else {
                return ResponseResult.getMessageResult(false, "A027");
            }
        }else{
            return ResponseResult.getMessageResult(false, "A028");
        }
    }

    /**
     * 根据信息添加医保人员信息
     * @param form
     * @return
     */
    @PostMapping("/addMedicareCard")
    public ResponseResult<Boolean> addMedicareCardByInformationCtl(@RequestBody @Valid AddMedicareCardForm form) {
        if(ser1.countMedicareCardByAccountSer(form.getMedicareCardNum())==0){
            boolean res = ser1.addMedicareCardByInformationSer(form.getMedicareCardNum(),form.getIdentityCardNum(),form.getMedicareType(),form.getMedicareStatus(),form.getMedicareName(),form.getMedicareSex(),form.getMedicareAge(),form.getMedicareNation(),form.getMedicareTime());
            if(res){
                return ResponseResult.getSuccessResult(true, "A029", null);
            }else{
                return ResponseResult.getMessageResult(false, "A030");
            }
        }else{
            return ResponseResult.getMessageResult(false, "A031");
        }
    }

}
