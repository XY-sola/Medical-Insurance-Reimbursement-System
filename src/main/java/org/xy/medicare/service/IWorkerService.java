package org.xy.medicare.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.xy.medicare.entity.Worker;

import java.util.Map;

/**
 * @description:对worker实体的服务层接口
 * @author: XY-GYL
 * @time: 2022/5/26 15:22
 */

public interface IWorkerService extends IService<Worker> {

    /**
     * 根据账号查找审批人员数量并返回结果
     *
     * @param account 账号
     * @return 此人员的个数
     */
    public int countWorkerByAccount(String account);

    /**
     * 根据账号查找审批人员身份证号并返回结果
     *
     * @param account 账号
     * @return 身份证号
     */
    public String findWorkerIdentityNumByAccount(String account);

    /**
     * 根据账号查找审批人员姓名并返回结果
     *
     * @param account 账号
     * @return 姓名
     */
    public String findWorkerNameByAccount(String account);
}
