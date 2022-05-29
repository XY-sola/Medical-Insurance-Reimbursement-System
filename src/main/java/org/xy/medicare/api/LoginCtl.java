package org.xy.medicare.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xy.medicare.common.http.ResponseResult;
import org.xy.medicare.common.http.StatusCode;
import org.xy.medicare.common.security.utils.JwtTokenUtil;
import org.xy.medicare.form.LoginForm;
import org.xy.medicare.service.impl.MedicareCardServiceImpl;
import org.xy.medicare.service.impl.UserServiceImpl;
import org.xy.medicare.service.impl.WorkerServiceImpl;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:登录页面的控制类
 * @author: XY-GYL
 * @time: 2022/5/24 11:15
 */

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LoginCtl {

    //自动封装服务层对象
    @Autowired
    private UserServiceImpl ser;
    @Autowired
    private MedicareCardServiceImpl ser2;
    @Autowired
    private WorkerServiceImpl ser3;

    //封装token的工具类
    @Autowired
    private JwtTokenUtil jwtUtil;

    /**
     * 根据账号和密码，判断登录是否成功，并返回相应状态码
     *
     * @param form
     * @return 登陆结果信息
     */
    @PostMapping("/login")
    public ResponseResult<Map<String, String>> loginCtl(@RequestBody @Valid LoginForm form) {
        Map<String, String> map = ser.userLoginSer(form.getAccount(), form.getPassword());
        if ("1".equals(map.get("res"))) {
            String token = jwtUtil.createToken(map.get("account"));
            Map<String, String> res = new HashMap<>();
            res.put("authToken", token);
            res.put("account",map.get("account"));
            res.put("userRole", map.get("user_role"));
            if ("0".equals(map.get("user_role"))) {
                //0 管理员
                res.put("userName", "000");
                return ResponseResult.getMessageResult(res, "A003", StatusCode.C200);
            } else if ("1".equals(map.get("user_role"))) {
                //1 审批人员
                res.put("userName", ser3.findWorkerNameByAccountSer(form.getAccount()));
                return ResponseResult.getMessageResult(res, "A004", StatusCode.C200);
            } else {
                //2 普通用户
                res.put("userName", ser2.findMedicareNameByAccountSer(form.getAccount()));
                return ResponseResult.getMessageResult(res, "A005", StatusCode.C200);
            }
        } else if ("-1".equals(map.get("res"))) {
            return ResponseResult.getMessageResult(null, "A001");
        } else {
            return ResponseResult.getMessageResult(null, "A002");
        }
    }
}
