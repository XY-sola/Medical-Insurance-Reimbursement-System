package org.xy.medicare.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.xy.medicare.dao.IWorkerDAO;
import org.xy.medicare.entity.Worker;
import org.xy.medicare.service.IWorkerService;

import java.util.List;
import java.util.Map;

/**
 * @description:实现对worker表（审批人员信息）的服务
 * @author: XY-GYL
 * @time: 2022/5/26 15:05
 */

@Service
public class WorkerServiceImpl extends ServiceImpl<IWorkerDAO, Worker> implements IWorkerService {

    /**
     * 根据账号查找审批人员数量并返回结果
     *
     * @param account 账号
     * @return 此人员的个数
     */
    @Override
    public int countWorkerByAccountSer(String account) {
        return query().eq("worker_num", account).count();
    }

    /**
     * 根据身份证号查找审批人员数量并返回结果
     *
     * @param identityNum 身份证号
     * @return 此人员的个数
     */
    @Override
    public int countWorkerByIdentityNumSer(String identityNum) {
        return query().eq("worker_identity_num", identityNum).count();
    }

    /**
     * 根据账号查找审批人员身份证号并返回结果
     *
     * @param account 账号
     * @return 身份证号
     */
    @Override
    public String findWorkerIdentityNumByAccountSer(String account) {
        return baseMapper.selectIdentityNumByWorkerNum(account);
    }

    /**
     * 根据账号查找审批人员姓名并返回结果
     *
     * @param account 账号
     * @return 姓名
     */
    @Override
    public String findWorkerNameByAccountSer(String account) {
        return baseMapper.selectWorkerNameByWorkerNum(account);
    }

    /**
     * 查询未注册的审批人员并分页显示
     *
     * @return 分页结果
     */
    @Override
    public PageInfo<Map<String, Object>> findNotRegisterWorkerInPagesSer(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> list = baseMapper.findNotRegisterWorkerCard();
        //如果数据为空
        if (list.size() == 0) {
            return null;
        }
        //将数字转为文字
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("worker_sex").equals(0)) {
                list.get(i).put("worker_sex", "男");
            } else if (list.get(i).get("worker_sex").equals(1)) {
                list.get(i).put("worker_sex", "女");
            }
        }
        PageInfo<Map<String, Object>> pageInfo = new PageInfo(list);
        return pageInfo;
    }

    /**
     * 查询单个审批人员
     *
     * @return 审批人员信息
     */
    @Override
    public Map<String, Object> findTheWorkerByWorkerNumSer(String workerNum) {
        Map<String, Object> map = baseMapper.findTheWorkerByWorkerNumDAO(workerNum);
        //将数字转为文字
        if (map.get("worker_sex").equals(0)) {
            map.put("worker_sex", "男");
        } else if (map.get("worker_sex").equals(1)) {
            map.put("worker_sex", "女");
        }
        return map;
    }

    /**
     * 查询所有审批人员并分页显示
     *
     * @return 分页结果
     */
    @Override
    public PageInfo<Map<String, Object>> findAllWorkerInPagesSer(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> list = baseMapper.findAllWorkerDAO();
        //如果数据为空
        if (list.size() == 0) {
            return null;
        }
        //将数字转为文字
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("worker_sex").equals(0)) {
                list.get(i).put("worker_sex", "男");
            } else if (list.get(i).get("worker_sex").equals(1)) {
                list.get(i).put("worker_sex", "女");
            }
        }
        PageInfo<Map<String, Object>> pageInfo = new PageInfo(list);
        return pageInfo;
    }

    /**
     * 根据工号删除审批人员信息
     *
     * @param workerNum
     * @return 删除结果
     */
    @Override
    public boolean deleteWorkerByWorkerNumSer(String workerNum) {
        return baseMapper.deleteWorkerByWorkerNumDAO(workerNum);
    }

    /**
     * 根据信息添加审批人员
     *
     * @param workerNum
     * @param workerName
     * @param workerIdentityNum
     * @param workerSex
     * @param workerOrganization
     * @param workerAddress
     * @return
     */
    @Override
    public boolean addWorkerByInformationSer(String workerNum, String workerName, String workerIdentityNum, Integer workerSex, String workerOrganization, String workerAddress) {
        return baseMapper.insertNewWorkerDAO(workerNum, workerName, workerIdentityNum, workerSex, workerOrganization, workerAddress);
    }


}
