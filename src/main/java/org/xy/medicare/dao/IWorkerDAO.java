package org.xy.medicare.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.xy.medicare.entity.Worker;

import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * @description:worker表，worker实体类的Dao
 * @author: XY-GYL
 * @time: 2022/5/26 15:18
 */

public interface IWorkerDAO extends BaseMapper<Worker> {

    @Select("SELECT worker_identity_num " +
            "FROM worker " +
            "WHERE worker_num = #{workerNum}; ")
    public String selectIdentityNumByWorkerNum(@Param("workerNum") String workerNum);

    @Select("SELECT worker_name " +
            "FROM worker " +
            "WHERE worker_num = #{workerNum}; ")
    public String selectWorkerNameByWorkerNum(@Param("workerNum") String workerNum);

    /**
     * 查询所有未注册的审批人员
     *
     * @return Worker列表
     */
    @Select("SELECT worker_num, worker_name,worker_identity_num,worker_sex,worker_organization " +
            "FROM worker " +
            "WHERE worker_num NOT IN ( " +
            "SELECT worker.worker_num " +
            "FROM user, worker " +
            "WHERE worker.worker_num = user.account) ")
    public List<Map<String, Object>> findNotRegisterWorkerCard();

    /**
     * 查询所有审批人员信息
     *
     * @return Worker列表
     */
    @Select("SELECT * " +
            "FROM worker ")
    public List<Map<String, Object>> findAllWorkerDAO();

    /**
     * 根据工号删除审批人员
     *
     * @param workerNum
     * @return 删除结果
     */
    @Delete("DELETE FROM worker  " +
            "WHERE worker_num = #{workerNum}; ")
    public boolean deleteWorkerByWorkerNumDAO(@Param("worker_num") String workerNum);

    /**
     * 根据信息添加审批人员
     * @param workerNum
     * @param workerName
     * @param workerIdentityNum
     * @param workerSex
     * @param workerOrganization
     * @param workerAddress
     * @return
     */
    @Insert("insert into worker " +
            "values (#{workerNum},#{workerName},#{workerIdentityNum},#{workerSex},#{workerOrganization},#{workerAddress}); ")
    public boolean insertNewWorkerDAO(@Param("worker_num") String workerNum,
                                      @Param("worker_name") String workerName,
                                      @Param("worker_identity_num") String workerIdentityNum,
                                      @Param("worker_sex") Integer workerSex,
                                      @Param("worker_organization") String workerOrganization,
                                      @Param("worker_address") String workerAddress);

}
