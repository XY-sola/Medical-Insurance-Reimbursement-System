package org.xy.medicare.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.xy.medicare.dao.ITreatmentDAO;
import org.xy.medicare.entity.Treatment;
import org.xy.medicare.service.ITreatmentService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @description:实现对treatment表（诊疗项目）的服务实现
 * @author: XY-GYL
 * @time: 2022/5/29 22:45
 */

@Service
public class TreatmentServiceImpl extends ServiceImpl<ITreatmentDAO, Treatment> implements ITreatmentService {

    /**
     * 根据名称、类别、价格、自费比例查找诊疗项目数量
     *
     * @param treatmentName
     * @param treatmentType
     * @param treatmentPrice
     * @param treatmentPercentage
     * @return
     */
    @Override
    public int countTreatmentByNameTypePricePercentageSER(String treatmentName, Integer treatmentType, BigDecimal treatmentPrice, Double treatmentPercentage) {
        return baseMapper.countTreatmentByNameTypePricePercentageDAO(treatmentName, treatmentType, treatmentPrice, treatmentPercentage);
    }

    /**
     * 查询所有诊疗项目并分页显示
     *
     * @return 分页结果
     */
    @Override
    public PageInfo<Map<String, Object>> findAllTreatmentInPagesSer(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> list = baseMapper.findAllTreatmentDAO();
        //如果数据为空
        if (list.size() == 0) {
            return null;
        }
        //将数字转为文字
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("treatment_project_type").equals(0)) {
                list.get(i).put("treatment_project_type", "全部统筹");
            } else if (list.get(i).get("treatment_project_type").equals(1)) {
                list.get(i).put("treatment_project_type", "部分统筹");
            } else if (list.get(i).get("treatment_project_type").equals(2)) {
                list.get(i).put("treatment_project_type", "不统筹");
            }
        }
        PageInfo<Map<String, Object>> pageInfo = new PageInfo(list);
        return pageInfo;
    }

    /**
     * 根据诊疗项目编号删除诊疗项目
     *
     * @param treatmentNum
     * @return 删除结果
     */
    @Override
    public boolean deleteTreatmentByTreatmentNumSer(String treatmentNum) {
        return baseMapper.deleteTreatmentByTreatmentNumDAO(treatmentNum);
    }

    /**
     * 根据信息添加诊疗项目
     *
     * @param treatmentName
     * @param treatmentType
     * @param treatmentPrice
     * @param treatmentPercentage
     * @return
     */
    @Override
    public boolean addTreatmentByInformationSer(String treatmentName, Integer treatmentType, BigDecimal treatmentPrice, Double treatmentPercentage) {
        return baseMapper.insertNewTreatmentDAO(UUID.randomUUID().toString(), treatmentName, treatmentType, treatmentPrice, treatmentPercentage);
    }

    /**
     * 根据信息修改诊疗项目
     *
     * @param treatmentNum
     * @param treatmentName
     * @param treatmentType
     * @param treatmentPrice
     * @param treatmentPercentage
     * @return
     */
    @Override
    public boolean modifyTreatmentByInformationSer(String treatmentNum, String treatmentName, Integer treatmentType, BigDecimal treatmentPrice, Double treatmentPercentage) {
        return baseMapper.modifyTreatmentDAO(treatmentNum, treatmentName, treatmentType, treatmentPrice, treatmentPercentage);
    }


}
