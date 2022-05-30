package org.xy.medicare.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.xy.medicare.dao.IRequestContentDAO;
import org.xy.medicare.entity.RequestContent;
import org.xy.medicare.service.IRequestContentService;

/**
 * @description:Request_content类的服务层实现
 * @author: XY-GYL
 * @time: 2022/5/29 17:50
 */

@Service
public class RequestContentServiceImpl extends ServiceImpl<IRequestContentDAO, RequestContent> implements IRequestContentService {

    /**
     * 根据药品编号判断报销申请中是否使用了药品
     *
     * @param medicineNum 药品编号
     * @return 使用了药品的申请的数量
     */
    @Override
    public Integer countApplicationByMedicineNumSer(String medicineNum) {
        return query().eq("rc_item_id", medicineNum).count();
    }

    /**
     * 根据诊疗项目编号判断报销申请中是否使用了诊疗项目
     *
     * @param treatmentNum 诊疗项目编号
     * @return 使用了诊疗项目的申请的数量
     */
    @Override
    public Integer countApplicationByTreatmentNumSer(String treatmentNum) {
        return query().eq("rc_item_id", treatmentNum).count();
    }

    /**
     * 根据服务设施编号判断报销申请中是否使用了服务设施
     *
     * @param facilityNum 服务设施编号
     * @return 使用了服务设施的申请的数量
     */
    @Override
    public Integer countApplicationByFacilityNumSer(String facilityNum) {
        return query().eq("rc_item_id", facilityNum).count();
    }

}
