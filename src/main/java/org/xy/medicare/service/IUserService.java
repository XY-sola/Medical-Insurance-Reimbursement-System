package org.xy.medicare.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import org.xy.medicare.entity.User;

import java.util.Map;

/**
 * @description:对User实体的服务层接口
 * @author: XY-GYL
 * @time: 2022/5/26 18:37
 */

public interface IUserService extends IService<User> {

    /**
     * 根据账号和密码验证登录并封装信息到res中
     *
     * @param account 账号
     * @param password 密码
     * @return 包含用户信息的Map
     */
    public Map<String, String> userLoginSer(String account, String password);

    /**
     * 根据账号、密码和用户角色注册用户并封装信息到res中
     *
     * @param account 账号
     * @param password 密码
     * @param userRole 用户角色
     * @return 包含用户信息的Map
     */
    public Map<String, String> userRegisterSer(String account, String password, Integer userRole);

    /**
     * 根据账号判断是否存在账户
     * @param account 账号
     * @return 用户数量
     */
    public Integer countUserByAccountSer(String account);

    /**
     * 根据账号找到用户的用户角色
     *
     * @param account 账号
     * @return 用户角色
     */
    public Integer findUserRoleByAccountSer(String account);

    /**
     * 根据账号和密码修改密码
     * @param account 账号
     * @param password 密码
     * @return 修改结果
     */
    public boolean modifyPasswordSer(String account, String password);

    /**
     * 根据账号删除用户信息
     * @param account 账号
     * @return 删除结果
     */
    public boolean deleteUserByAccountSer(String account);

    /**
     * 查询除管理员外所有用户并分页显示
     *
     * @return 分页结果
     */
    public PageInfo<Map<String, Object>> findAllUserExceptAdminInPagesSer(int pageNum, int pageSize);


}
