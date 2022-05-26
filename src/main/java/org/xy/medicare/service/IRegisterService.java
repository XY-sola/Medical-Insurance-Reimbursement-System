package org.xy.medicare.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.xy.medicare.entity.User;

import java.util.Map;

/**
 * @description:Register服务层接口
 * @author: XY-GYL
 * @time: 2022/5/24 11:47
 */

public interface IRegisterService extends IService<User> {

    /**
     * 根据账号、密码和用户角色注册用户并封装信息到res中
     *
     * @param account 账号
     * @param password 密码
     * @param userRole 用户角色
     * @return 包含用户信息的Map
     */
    public Map<String, String> userRegister(String account, String password, Integer userRole);
}
