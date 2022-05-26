package org.xy.medicare.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.xy.medicare.dao.IUserDao;
import org.xy.medicare.entity.User;
import org.xy.medicare.service.ILoginService;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:Login的服务层实现
 * @author: XY-GYL
 * @time: 2022/5/24 11:18
 */

@Service
public class LoginServiceImpl extends ServiceImpl<IUserDao, User> implements ILoginService {

    @Override
    public Map<String, String> userLogin(String account, String password) {
        Map<String, String> map = new HashMap<>();
        int res = query().eq("account", account).count();
        if (res == 0) {
            //账号不存在
            map.put("res", "-1");
            return map;
        }
        User user = query().eq("account", account).one();
        if (password.equals(user.getPassword())) {
            //密码相同
            map.put("res", "1");
            map.put("account", user.getAccount());
            map.put("user_role", user.getUserRole().toString());
        } else {
            //密码不同，登录失败
            map.put("res", "-2");
        }
        return map;
    }
}
