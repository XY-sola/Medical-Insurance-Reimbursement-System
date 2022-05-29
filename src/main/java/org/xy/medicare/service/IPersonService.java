package org.xy.medicare.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.xy.medicare.entity.Person;

import java.util.Map;

/**
 * @description:对Person实体的服务层接口
 * @author: XY-GYL
 * @time: 2022/5/28 19:06
 */

public interface IPersonService extends IService<Person> {

    /**
     * 根据账号新建用户个人信息并封装信息到res中
     *
     * @param account 账号
     * @return 包含用户信息的Map
     */
    public Map<String, String> newNullPersonSer(String account);

    /**
     * 根据账号删除用户个人信息
     * @param account 账号
     * @return 修改结果
     */
    public boolean deletePersonByAccountSer(String account);

}
