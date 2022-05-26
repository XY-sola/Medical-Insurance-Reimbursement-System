package org.xy.medicare.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Insert;
import org.xy.medicare.entity.User;

/**
 * @description:user表，User实体类的Dao
 * @author: XY-GYL
 * @time: 2022/5/24 11:55
 */

public interface IUserDao extends BaseMapper<User> {

    @Insert("INSERT INTO user " +
            "VALUES (#{account},#{password},#{userRole}); ")
    public boolean insertIntoUser(@Param("account") String account,
                              @Param("password") String password,
                              @Param("user_role") int userRole);
}