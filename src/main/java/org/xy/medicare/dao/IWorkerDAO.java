package org.xy.medicare.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Select;
import org.xy.medicare.entity.Worker;

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
}
