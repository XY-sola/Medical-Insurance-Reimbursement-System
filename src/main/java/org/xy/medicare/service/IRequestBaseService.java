package org.xy.medicare.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.xy.medicare.entity.RequestBase;

/**
 * @description:对Request_base实体的服务层接口
 * @author: XY-GYL
 * @time: 2022/5/29 8:02
 */

public interface IRequestBaseService extends IService<RequestBase> {

    /**
     * 根据用户医保号判断是否存在报销申请
     *
     * @param medicareCardId 医保号
     * @return 用户提出的申请的数量
     */
    public Integer countApplicationByMedicareCardIdSer(String medicareCardId);

    /**
     * 根据工号判断是否存在审批过的申请
     *
     * @param workerNum 工号
     * @return 审批人员审批过的申请数量
     */
    public Integer countApplicationByWorkerNumSer(String workerNum);

}
