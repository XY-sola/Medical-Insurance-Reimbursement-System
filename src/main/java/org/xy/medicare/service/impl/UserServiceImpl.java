package org.xy.medicare.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.xy.medicare.dao.IUserDao;
import org.xy.medicare.entity.User;
import org.xy.medicare.service.IUserService;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:User类的服务层实现
 * @author: XY-GYL
 * @time: 2022/5/26 18:44
 */

@Service
public class UserServiceImpl extends ServiceImpl<IUserDao, User> implements IUserService {

    /**
     * 根据账号和密码验证登录并封装信息到res中
     *
     * @param account 账号
     * @param password 密码
     * @return 包含用户信息的Map
     */
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

    /**
     * 根据账号、密码和用户角色注册用户并封装信息到res中
     *
     * @param account 账号
     * @param password 密码
     * @param userRole 用户角色
     * @return 包含用户信息的Map
     */
    @Override
    public Map<String, String> userRegister(String account, String password, Integer userRole){
        Map<String, String> map = new HashMap<>();
        int res = query().eq("account", account).count();
        if(res >=1 ){
            //账号已注册
            map.put("res", "-1");
        }else{
            //账号未注册
            boolean suc = baseMapper.insertIntoUser(account, password, userRole);
            if(suc){
                map.put("res","1");
            }else{
                map.put("res", "2");
            }
        }
        return map;
    }

    /**
     * 根据账号判断是否存在账户
     * @param account 账号
     * @return 用户数量
     */
    @Override
    public Integer countUserByAccount(String account){
        return query().eq("account", account).count();
    }

    /**
     * 根据账号找到用户的用户角色
     *
     * @param account 账号
     * @return 用户角色
     */
    @Override
    public Integer findUserRoleByAccount(String account){
        return baseMapper.selectUserRoleByAccount(account);
    }

    /**
     * 根据账号和密码修改密码
     * @param account 账号
     * @param password 密码
     * @return 修改结果
     */
    public boolean modifyPassword(String account, String password){
        return baseMapper.updatePasswordByAccount(account, password);
    }

}
