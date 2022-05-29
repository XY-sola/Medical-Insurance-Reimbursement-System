package org.xy.medicare.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xy.medicare.common.http.ResponseResult;
import org.xy.medicare.common.http.StatusCode;
import org.xy.medicare.form.RegisterForm;
import org.xy.medicare.service.impl.MedicareCardServiceImpl;
import org.xy.medicare.service.impl.PersonServiceImpl;
import org.xy.medicare.service.impl.UserServiceImpl;
import org.xy.medicare.service.impl.WorkerServiceImpl;

import javax.validation.Valid;
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
    private UserServiceImpl ser1;
    @Autowired
    private MedicareCardServiceImpl ser2;
    @Autowired
    private WorkerServiceImpl ser3;
    @Autowired
    private PersonServiceImpl ser4;

    /**
     * 根据账号、密码和用户角色，进行注册，并返回相应状态码
     *
     * @param form
     * @return 注册结果信息
     */
    @PostMapping("/register")
    public ResponseResult<Map<String, String>> registerCtl(@RequestBody @Valid RegisterForm form) {
        if (form.getUserRole() == 2 && ser2.countMedicareCardByAccountSer(form.getAccount()) == 0) {
            //查询是否有普通用户的医保号
            return ResponseResult.getMessageResult(null, "A008");
        } else if (form.getUserRole() == 1 && ser3.countWorkerByAccountSer(form.getAccount()) == 0) {
            //查询是否有审批人员的工号
            return ResponseResult.getMessageResult(null, "A009");
        }
        if (!form.getPassword().equals(form.getPasswordRepeat())) {
            return ResponseResult.getMessageResult(null, "A007");
        }
        Map<String, String> map = ser1.userRegisterSer(form.getAccount(), form.getPassword(), form.getUserRole());
        Map<String, String> map2 = ser4.newNullPersonSer(form.getAccount());
        if ("-1".equals(map.get("res"))) {
            //账户已注册
            return ResponseResult.getMessageResult(null, "A006");
        } else if ("1".equals(map.get("res"))) {
            //成功注册
            return ResponseResult.getMessageResult(null, "A010", StatusCode.C200);
        } else {
            //注册失败
            return ResponseResult.getMessageResult(null, "A011");
        }
    }
}
