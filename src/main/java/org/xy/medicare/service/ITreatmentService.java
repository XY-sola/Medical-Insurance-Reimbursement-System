package org.xy.medicare.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import org.xy.medicare.entity.Treatment;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @description:对Treatment实体的服务层接口
 * @author: XY-GYL
 * @time: 2022/5/29 22:12
 */

public interface ITreatmentService extends IService<Treatment> {

    /**
     * 根据名称、类别、价格、自费比例查找诊疗项目数量
     * @param treatmentName
     * @param treatmentType
     * @param treatmentPrice
     * @param treatmentPercentage
     * @return
     */
    public int countTreatmentByNameTypePricePercentageSER(String treatmentName, Integer treatmentType, BigDecimal treatmentPrice, Double treatmentPercentage);

    /**
     * 查询所有诊疗项目并分页显示
     *
     * @return 分页结果
     */
    public PageInfo<Map<String, Object>> findAllTreatmentInPagesSer(int pageNum, int pageSize);

    /**
     * 根据诊疗项目编号删除诊疗项目
     *
     * @param treatmentNum
     * @return 删除结果
     */
    public boolean deleteTreatmentByTreatmentNumSer(String treatmentNum);

    /**
     * 根据信息添加诊疗项目
     * @param treatmentName
     * @param treatmentType
     * @param treatmentPrice
     * @param treatmentPercentage
     * @return
     */
    public boolean addTreatmentByInformationSer( String treatmentName, Integer treatmentType, BigDecimal treatmentPrice, Double treatmentPercentage);

    /**
     * 根据信息修改诊疗项目
     * @param treatmentNum
     * @param treatmentName
     * @param treatmentType
     * @param treatmentPrice
     * @param treatmentPercentage
     * @return
     */
    public boolean modifyTreatmentByInformationSer(String treatmentNum, String treatmentName, Integer treatmentType, BigDecimal treatmentPrice, Double treatmentPercentage);

}
