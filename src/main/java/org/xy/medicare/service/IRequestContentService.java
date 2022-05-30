package org.xy.medicare.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.xy.medicare.entity.RequestContent;

/**
 * @description:对Request_content实体的服务层接口
 * @author: XY-GYL
 * @time: 2022/5/29 17:47
 */

public interface IRequestContentService extends IService<RequestContent> {

    /**
     * 根据药品编号判断报销申请中是否使用了药品
     *
     * @param medicineNum 药品编号
     * @return 使用了药品的申请的数量
     */
    public Integer countApplicationByMedicineNumSer(String medicineNum);

    /**
     * 根据诊疗项目编号判断报销申请中是否使用了诊疗项目
     *
     * @param treatmentNum 诊疗项目编号
     * @return 使用了诊疗项目的申请的数量
     */
    public Integer countApplicationByTreatmentNumSer(String treatmentNum);

    /**
     * 根据服务设施编号判断报销申请中是否使用了服务设施
     *
     * @param facilityNum 服务设施编号
     * @return 使用了服务设施的申请的数量
     */
    public Integer countApplicationByFacilityNumSer(String facilityNum);

}
