package org.xy.medicare.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.lettuce.core.dynamic.annotation.Param;
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
     *
     * @param account 账号
     * @return 删除结果
     */
    public boolean deletePersonByAccountSer(String account);

    /**
     * 根据账号查找个人信息数量并返回结果
     *
     * @param account 账号
     * @return 此人员的个数
     */
    public int countPersonByAccountSer(String account);

    /**
     * 查询单个用户个人信息
     *
     * @return 用户个人信息
     */
    public Map<String, Object> findThePersonByAccountSer(String account);

    /**
     * 根据账号查找并修改用户个人信息
     *
     * @param account 账号
     * @return 修改结果
     */
    public boolean modifyPersonByAccountSer(String account, String bankAccount, String telephone, String address);

}
