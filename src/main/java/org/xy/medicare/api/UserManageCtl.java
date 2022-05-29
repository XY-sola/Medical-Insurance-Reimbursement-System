package org.xy.medicare.api;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xy.medicare.common.http.ResponseResult;
import org.xy.medicare.common.http.StatusCode;
import org.xy.medicare.entity.Person;
import org.xy.medicare.form.AccountAndRoleForm;
import org.xy.medicare.form.SearchListByPageNumAndPageSizeForm;
import org.xy.medicare.service.impl.PersonServiceImpl;
import org.xy.medicare.service.impl.UserServiceImpl;

import javax.validation.Valid;
import java.util.Map;

/**
 * @description:查找、添加、删除用户的控制层
 * @author: XY-GYL
 * @time: 2022/5/27 19:30
 */

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserManageCtl {

    //自动封装服务层对象
    @Autowired
    private UserServiceImpl ser1;
    @Autowired
    private PersonServiceImpl ser2;

    /**
     * 获取用户信息分页列表
     *
     * @param form 包含页码和单页条数
     * @return JSON in response
     */
    @PostMapping("/searchUserList")
    public ResponseResult<PageInfo<Map<String, Object>>> searchUserListExceptAdminCtl(@RequestBody @Valid SearchListByPageNumAndPageSizeForm form) {
        PageInfo<Map<String, Object>> pager = ser1.findAllUserExceptAdminInPagesSer(form.getPageNum(), form.getPageSize());
        if (pager == null) {
            return ResponseResult.getMessageResult(null, "A017");
        } else {
            return ResponseResult.getMessageResult(pager, "A016", StatusCode.C200);
        }
    }

    /**
     * 删除某个用户
     * @param form 包含用户账号
     * @return JSON in response
     */
    @PostMapping("/deleteUser")
    public ResponseResult<Boolean> deleteUserCtl(@RequestBody @Valid AccountAndRoleForm form) {
        boolean res2 = ser2.deletePersonByAccountSer(form.getAccount());
        boolean res1 = ser1.deleteUserByAccountSer(form.getAccount());
        if (res1 && res2) {
            return ResponseResult.getSuccessResult(true, "A022", null);
        } else {
            return ResponseResult.getMessageResult(false, "A023");
        }
    }

}
