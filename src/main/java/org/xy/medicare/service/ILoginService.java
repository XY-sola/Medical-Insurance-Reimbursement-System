package org.xy.medicare.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.xy.medicare.entity.User;

import java.util.Map;

/**
 * @description:Login服务层接口
 * @author: XY-GYL
 * @time: 2022/5/24 11:47
 */

public interface ILoginService extends IService<User> {
    /**
     * 根据账号和密码验证登录并封装信息到res中
     *
     * @param account 账号
     * @param password 密码
     * @return 包含用户信息的Map
     */
    public Map<String, String> userLogin(String account, String password);
}
