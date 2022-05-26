package org.xy.medicare.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.xy.medicare.dao.IWorkerDAO;
import org.xy.medicare.entity.Worker;
import org.xy.medicare.service.IWorkerService;

/**
 * @description:实现对worker表（审批人员信息）的服务
 * @author: XY-GYL
 * @time: 2022/5/26 15:05
 */

@Service
public class WorkerServiceImpl extends ServiceImpl<IWorkerDAO, Worker> implements IWorkerService {

    @Override
    public int countWorkerByAccount(String account){
        return query().eq("worker_num", account).count();
    }

    @Override
    public String findWorkerIdentityNumByAccount(String account){
        return baseMapper.selectIdentityNumByWorkerNum(account);
    }
}
