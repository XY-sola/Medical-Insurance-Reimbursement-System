package org.xy.medicare.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import io.lettuce.core.dynamic.annotation.Param;
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
    public int countWorkerByAccountSer(String account);

    /**
     * 根据账号查找审批人员身份证号并返回结果
     *
     * @param account 账号
     * @return 身份证号
     */
    public String findWorkerIdentityNumByAccountSer(String account);

    /**
     * 根据账号查找审批人员姓名并返回结果
     *
     * @param account 账号
     * @return 姓名
     */
    public String findWorkerNameByAccountSer(String account);

    /**
     * 查询未注册的审批人员并分页显示
     *
     * @return 分页结果
     */
    public PageInfo<Map<String, Object>> findNotRegisterWorkerInPagesSer(int pageNum, int pageSize);

    /**
     * 查询所有审批人员并分页显示
     *
     * @return 分页结果
     */
    public PageInfo<Map<String, Object>> findAllWorkerInPagesSer(int pageNum, int pageSize);

    /**
     * 根据工号删除审批人员信息
     *
     * @param workerNum
     * @return 删除结果
     */
    public boolean deleteWorkerByWorkerNumSer(String workerNum);

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
    public boolean addWorkerByInformationSer(String workerNum, String workerName, String workerIdentityNum, Integer workerSex, String workerOrganization, String workerAddress);

}
