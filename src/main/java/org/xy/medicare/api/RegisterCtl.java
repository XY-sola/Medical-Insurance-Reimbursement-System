package org.xy.medicare.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xy.medicare.common.http.ResponseResult;
import org.xy.medicare.common.http.StatusCode;
import org.xy.medicare.form.RegisterForm;
import org.xy.medicare.service.impl.MedicareCardServiceImpl;
import org.xy.medicare.service.impl.RegisterServiceImpl;
import org.xy.medicare.service.impl.WorkerServiceImpl;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:注册页面的控制类
 * @author: XY-GYL
 * @time: 2022/5/26 14:28
 */

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RegisterCtl {

    //自动封装服务层对象
    @Autowired
    private RegisterServiceImpl ser1;
    @Autowired
    private MedicareCardServiceImpl ser2;
    @Autowired
    private WorkerServiceImpl ser3;

    /**
     * 根据账号、密码和用户角色，进行注册，并返回相应状态码
     *
     * @param form
     * @return 注册结果信息
     */
    @PostMapping("/register")
    public ResponseResult<Map<String, String>> register(@RequestBody @Valid RegisterForm form) {
        if (form.getUserRole() == 2) {
            //查询是否有普通用户的医保号
            int count = ser2.countMedicareCardByAccount(form.getAccount());
            if (count ==0 ) {
                return ResponseResult.getMessageResult(null, "A008");
            }
        } else if (form.getUserRole() == 1) {
            //查询是否有审批人员的工号
            int count = ser3.countWorkerByAccount(form.getAccount());
            if (count ==0 ) {
                return ResponseResult.getMessageResult(null, "A009");
            }
        }
        if(!form.getPassword().equals(form.getPasswordRepeat())){
            return ResponseResult.getMessageResult(null, "A007");
        }
        Map<String, String> map = ser1.userRegister(form.getAccount(), form.getPassword(),form.getUserRole());
        if ("1".equals(map.get("res"))) {
            return ResponseResult.getMessageResult(null, "A010", StatusCode.C200);
        } else {
            //账户已注册
            return ResponseResult.getMessageResult(null, "A006");
        }
    }
}
