package org.xy.medicare.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.xy.medicare.dao.IUserDao;
import org.xy.medicare.entity.User;
import org.xy.medicare.service.IRegisterService;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:Register的服务层实现
 * @author: XY-GYL
 * @time: 2022/5/26 14:47
 */

@Service
public class RegisterServiceImpl extends ServiceImpl<IUserDao, User> implements IRegisterService {

    @Override
    public Map<String, String> userRegister(String account, String password, Integer userRole){
        Map<String, String> map = new HashMap<>();
        int res = query().eq("account", account).count();
        if(res >=1 ){
            //账号已注册
            map.put("res", "-1");
        }else{
            //账号未注册
            map.put("res", "1");
            baseMapper.insertIntoUser(account, password,userRole);
        }
        return map;
    }
}
