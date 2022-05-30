package org.xy.medicare.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.xy.medicare.entity.Person;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @description:person表，person实体类的Dao
 * @author: XY-GYL
 * @time: 2022/5/28 19:07
 */

public interface IPersonDAO extends BaseMapper<Person> {

    /**
     * 新建空的用户个人信息
     *
     * @param account
     * @return
     */
    @Insert("INSERT INTO person(account) " +
            "VALUES (#{account}); ")
    public boolean insertNULLIntoPerson(@Param("account") String account);

    /**
     * 根据账号删除用户个人信息
     *
     * @param account
     * @return 删除结果
     */
    @Delete("DELETE FROM person  " +
            "WHERE account = #{account}; ")
    public boolean deletePersonByAccountDAO(@Param("account") String account);

    /**
     * 查询单个个人信息
     *
     * @return person集合
     */
    @Select("SELECT * " +
            "FROM person " +
            "WHERE account = #{account}; ")
    public Map<String, Object> findThePersonByAccountDAO(@Param("account") String account);

    /**
     * 根据账号查找并修改个人信息
     * @param account
     * @param bankAccount
     * @param telephone
     * @param address
     * @return
     */
    @Update("update person " +
            "set bank_account = #{bankAccount},telephone=#{telephone},address=#{address}  " +
            "where account=#{account}; ")
    public boolean modifyPersonByAccountDAO(@Param("account") String account,
                                            @Param("bank_account") String bankAccount,
                                            @Param("telephone") String telephone,
                                            @Param("address") String address);


}
