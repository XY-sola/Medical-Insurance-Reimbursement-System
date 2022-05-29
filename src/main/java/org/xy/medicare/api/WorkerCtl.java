package org.xy.medicare.api;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xy.medicare.common.http.ResponseResult;
import org.xy.medicare.common.http.StatusCode;
import org.xy.medicare.form.AddMedicareCardForm;
import org.xy.medicare.form.AddWorkerForm;
import org.xy.medicare.form.IDForm;
import org.xy.medicare.form.SearchListByPageNumAndPageSizeForm;
import org.xy.medicare.service.impl.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * @description:查找、删除、添加审批人员的控制层接口
 * @author: XY-GYL
 * @time: 2022/5/28 19:52
 */

@CrossOrigin
@RestController
@RequestMapping("/api")
public class WorkerCtl {

    //自动封装服务层对象
    @Autowired
    private WorkerServiceImpl ser1;
    @Autowired
    private RequestBaseServiceImpl ser2;
    @Autowired
    private UserServiceImpl ser3;
    @Autowired
    private PersonServiceImpl ser4;

    /**
     * 获取未注册审批人员信息分页列表
     *
     * @param form 包含页码和单页条数
     * @return JSON in response
     */
    @PostMapping("/searchNotRegisterWorkerList")
    public ResponseResult<PageInfo<Map<String, Object>>> searchNotRegisterWorkerListCtl(@RequestBody @Valid SearchListByPageNumAndPageSizeForm form) {
        PageInfo<Map<String, Object>> pager = ser1.findNotRegisterWorkerInPagesSer(form.getPageNum(), form.getPageSize());
        if (pager == null) {
            return ResponseResult.getMessageResult(null, "A021");
        } else {
            return ResponseResult.getMessageResult(pager, "A020", StatusCode.C200);
        }
    }

    /**
     * 获取全部审批人员信息分页列表
     *
     * @param form 包含页码和单页条数
     * @return JSON in response
     */
    @PostMapping("/searchAllWorkerList")
    public ResponseResult<PageInfo<Map<String, Object>>> searchAllWorkerListCtl(@RequestBody @Valid SearchListByPageNumAndPageSizeForm form) {
        PageInfo<Map<String, Object>> pager = ser1.findAllWorkerInPagesSer(form.getPageNum(), form.getPageSize());
        if (pager == null) {
            //审批人员信息列表为空，视为查询失败
            return ResponseResult.getMessageResult(null, "A033");
        } else {
            return ResponseResult.getMessageResult(pager, "A032", StatusCode.C200);
        }
    }

    /**
     * 根据工号删除审批人员
     * @param form 包含工号
     * @return JSON in response
     */
    @PostMapping("/deleteWorker")
    public ResponseResult<Boolean> deleteWorkerCtl(@RequestBody @Valid IDForm form) {
        if(ser2.countApplicationByWorkerNumSer(form.getId())==0){
            //严谨的应该判断有无账户再进行账户删除，这里直接全部删除，因此判断用 或
            boolean res1 = ser4.deletePersonByAccountSer(form.getId());
            boolean res2 = ser3.deleteUserByAccountSer(form.getId());
            boolean res3 = ser1.deleteWorkerByWorkerNumSer(form.getId());
            if (res1 || res2 || res3) {
                return ResponseResult.getSuccessResult(true, "A034", null);
            } else {
                return ResponseResult.getMessageResult(false, "A035");
            }
        }else{
            return ResponseResult.getMessageResult(false, "A036");
        }
    }

    /**
     * 根据信息添加审批人员信息
     * @param form
     * @return
     */
    @PostMapping("/addWorker")
    public ResponseResult<Boolean> addWorkerByInformationCtl(@RequestBody @Valid AddWorkerForm form) {
        if(ser1.countWorkerByAccountSer(form.getWorkerNum())==0){
            boolean res = ser1.addWorkerByInformationSer(form.getWorkerNum(),form.getWorkerName(),form.getIdentityNum(),form.getWorkerSex(),form.getWorkerOrganization(),form.getWorkerAddress());
            if(res){
                return ResponseResult.getSuccessResult(true, "A037", null);
            }else{
                return ResponseResult.getMessageResult(false, "A038");
            }
        }else{
            return ResponseResult.getMessageResult(false, "A039");
        }
    }

}
