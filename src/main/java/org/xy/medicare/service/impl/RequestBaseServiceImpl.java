package org.xy.medicare.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.xy.medicare.dao.IRequestBaseDAO;
import org.xy.medicare.entity.RequestBase;
import org.xy.medicare.service.IRequestBaseService;

/**
 * @description:Request_base类的服务层实现
 * @author: XY-GYL
 * @time: 2022/5/29 8:05
 */

@Service
public class RequestBaseServiceImpl extends ServiceImpl<IRequestBaseDAO, RequestBase> implements IRequestBaseService {

    /**
     * 根据用户医保号判断是否存在报销申请
     * @param medicareCardId 医保号
     * @return 用户提出的申请的数量
     */
    @Override
    public Integer countApplicationByMedicareCardIdSer(String medicareCardId){
        return query().eq("rb_user", medicareCardId).count();
    }

    /**
     * 根据工号判断是否存在审批过的申请
     * @param workerNum 工号
     * @return 审批人员审批过的申请数量
     */
    @Override
    public Integer countApplicationByWorkerNumSer(String workerNum){
        return query().eq("rb_worker", workerNum).count();
    }

}
