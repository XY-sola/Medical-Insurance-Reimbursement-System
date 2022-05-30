package org.xy.medicare.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xy.medicare.common.http.ResponseResult;
import org.xy.medicare.common.http.StatusCode;
import org.xy.medicare.form.IDForm;
import org.xy.medicare.form.ModifyMedicineForm;
import org.xy.medicare.form.ModifyPersonForm;
import org.xy.medicare.service.impl.PersonServiceImpl;

import javax.validation.Valid;
import java.util.Map;

/**
 * @description:查找、修改个人信息的控制层接口
 * @author: XY-GYL
 * @time: 2022/5/30 13:48
 */

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PersonCtl {

    //自动封装服务层对象
    @Autowired
    private PersonServiceImpl ser1;

    /**
     * 获取单个用户个人信息
     *
     * @param form 包含账号
     * @return JSON in response
     */
    @PostMapping("/searchThePerson")
    public ResponseResult<Map<String, Object>> searchThePersonCtl(@RequestBody @Valid IDForm form) {
        if (ser1.countPersonByAccountSer(form.getId()) == 0) {
            //个人信息表中无此用户，查询失败
            return ResponseResult.getMessageResult(null, "A081");
        }
        Map<String, Object> map = ser1.findThePersonByAccountSer(form.getId());
        return ResponseResult.getMessageResult(map, "A080", StatusCode.C200);
    }

    /**
     * 根据信息修改个人信息
     *
     * @param form 个人信息
     * @return
     */
    @PostMapping("/modifyThePerson")
    public ResponseResult<Boolean> modifyThePersonByInformationCtl(@RequestBody @Valid ModifyPersonForm form) {
        boolean res = ser1.modifyPersonByAccountSer(form.getAccount(),form.getBankAccount(),form.getTelephone(),form.getAddress());
        if (res) {
            return ResponseResult.getSuccessResult(true, "A082", null);
        } else {
            return ResponseResult.getMessageResult(false, "A083");
        }
    }

}
