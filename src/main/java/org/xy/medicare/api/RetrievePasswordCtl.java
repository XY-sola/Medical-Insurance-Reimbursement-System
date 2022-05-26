package org.xy.medicare.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xy.medicare.common.http.ResponseResult;
import org.xy.medicare.common.http.StatusCode;
import org.xy.medicare.form.RetrievePasswordModifyForm;
import org.xy.medicare.form.RetrievePasswordVerifyForm;
import org.xy.medicare.service.impl.MedicareCardServiceImpl;
import org.xy.medicare.service.impl.UserServiceImpl;
import org.xy.medicare.service.impl.WorkerServiceImpl;

import javax.validation.Valid;
import java.util.Map;

/**
 * @description:找回密码页面的控制类
 * @author: XY-GYL
 * @time: 2022/5/26 17:38
 */

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RetrievePasswordCtl {

    //自动封装服务层对象
    @Autowired
    private UserServiceImpl ser1;
    @Autowired
    private MedicareCardServiceImpl ser2;
    @Autowired
    private WorkerServiceImpl ser3;

    /**
     * 根据账号、身份证号，进行找回密码的验证，并返回相应状态码
     *
     * @param form
     * @return 验证结果信息
     */
    @PostMapping("/retrievePasswordVerify")
    public ResponseResult<Map<String, String>> retrievePasswordVerify(@RequestBody @Valid RetrievePasswordVerifyForm form) {
        int userQuantity = ser1.countUserByAccount(form.getAccount());
        if (userQuantity == 0) {
            return ResponseResult.getMessageResult(null, "A001");
        }
        int userRole = ser1.findUserRoleByAccount(form.getAccount());
        if (userRole == 2) {
            //验证医保人员的身份证号
            String IdentityNum = ser2.findMedicareCardIdentityNumByAccount(form.getAccount());
            if (form.getIdentityCardNum().equals(IdentityNum)) {
                return ResponseResult.getMessageResult(null, "A012");
            } else {
                return ResponseResult.getMessageResult(null, "A013");
            }
        } else {
            //验证审批人员的身份证号
            String IdentityNum = ser3.findWorkerIdentityNumByAccount(form.getAccount());
            if (form.getIdentityCardNum().equals(IdentityNum)) {
                return ResponseResult.getMessageResult(null, "A012");
            } else {
                return ResponseResult.getMessageResult(null, "A013");
            }
        }
    }

    /**
     * 根据账号、密码、新密码，进行密码重置，并返回相应状态码
     *
     * @param form
     * @return 修改结果信息
     */
    @PostMapping("/retrievePasswordModify")
    public ResponseResult<Map<String, String>> retrievePasswordModify(@RequestBody @Valid RetrievePasswordModifyForm form) {
        if(!form.getPassword().equals(form.getPasswordRepeat())){
            //密码不一致
            return ResponseResult.getMessageResult(null, "A007");
        }
        boolean res = ser1.modifyPassword(form.getAccount(),form.getPassword());
        if(res){
            return ResponseResult.getMessageResult(null, "A014");
        }else{
            return ResponseResult.getMessageResult(null, "A015");
        }

    }
}
