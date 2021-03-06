package org.xy.medicare.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.xy.medicare.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @description:user表，User实体类的Dao
 * @author: XY-GYL
 * @time: 2022/5/24 11:55
 */

public interface IUserDao extends BaseMapper<User> {

    /**
     * 插入用户，实现注册
     * @param account
     * @param password
     * @param userRole
     * @return
     */
    @Insert("INSERT INTO user " +
            "VALUES (#{account},#{password},#{userRole}); ")
    public boolean insertIntoUser(@Param("account") String account,
                              @Param("password") String password,
                              @Param("user_role") int userRole);

    /**
     * 根据账号返回用户角色
     * @param account
     * @return
     */
    @Select("SELECT user_role " +
            "FROM user " +
            "WHERE account = #{account}; ")
    public Integer selectUserRoleByAccount(@Param("account") String account);

    /**
     * 根据账号修改密码
     * @param account
     * @return
     */
    @Update("UPDATE user " +
            "SET password = #{password} " +
            "WHERE account = #{account}; ")
    public boolean updatePasswordByAccount(@Param("account") String account,
                                           @Param("password") String password);

    /**
     * 根据账号删除用户
     * @param account
     * @return 删除结果
     */
    @Delete("DELETE FROM user  " +
            "WHERE account = #{account}; ")
    public boolean deleteUserByAccountDAO(@Param("account") String account);

    /**
     * 查询所有用户
     *
     * @return User列表
     */
    @Select("SELECT account,user_role " +
            "FROM user " +
            "WHERE user_role != 0 " +
            "ORDER BY user_role " )
    public List<Map<String, Object>> findAllUserExceptAdmin();



}