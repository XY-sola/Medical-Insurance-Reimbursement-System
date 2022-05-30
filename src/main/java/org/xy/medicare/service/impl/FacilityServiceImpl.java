package org.xy.medicare.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.xy.medicare.dao.IFacilityDAO;
import org.xy.medicare.entity.Facility;
import org.xy.medicare.service.IFacilityService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
 * @description:实现对service_facility表（服务设施）的服务实现
 * @author: XY-GYL
 * @time: 2022/5/30 9:45
 */

@Service
public class FacilityServiceImpl extends ServiceImpl<IFacilityDAO, Facility> implements IFacilityService {

    /**
     * 根据名称、类别、价格、自费比例查找服务设施数量
     *
     * @param facilityName
     * @param facilityType
     * @return
     */
    @Override
    public int countFacilityByNameTypePricePercentageSER(String facilityName, Integer facilityType, BigDecimal facilityPrice, Double facilityPercentage) {
        return baseMapper.countFacilityByNameTypePricePercentageDAO(facilityName, facilityType, facilityPrice, facilityPercentage);
    }

    /**
     * 查询所有服务设施并分页显示
     *
     * @return 分页结果
     */
    @Override
    public PageInfo<Map<String, Object>> findAllFacilityInPagesSer(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> list = baseMapper.findAllFacilityDAO();
        //如果数据为空
        if (list.size() == 0) {
            return null;
        }
        //将数字转为文字
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("service_facility_type").equals(0)) {
                list.get(i).put("service_facility_type", "可报销");
            } else if (list.get(i).get("service_facility_type").equals(1)) {
                list.get(i).put("service_facility_type", "不可报销");
            }
        }
        PageInfo<Map<String, Object>> pageInfo = new PageInfo(list);
        return pageInfo;
    }

    /**
     * 根据服务设施编号删除服务设施
     *
     * @param facilityNum
     * @return 删除结果
     */
    @Override
    public boolean deleteFacilityByFacilityNumSer(String facilityNum) {
        return baseMapper.deleteFacilityByFacilityNumDAO(facilityNum);
    }

    /**
     * 根据信息添加服务设施
     *
     * @param facilityName
     * @param facilityType
     * @param facilityPrice
     * @param facilityPercentage
     * @return
     */
    @Override
    public boolean addFacilityByInformationSer(String facilityName, Integer facilityType, BigDecimal facilityPrice, Double facilityPercentage) {
        return baseMapper.insertNewFacilityDAO(UUID.randomUUID().toString(), facilityName, facilityType, facilityPrice, facilityPercentage);
    }

    /**
     * 根据信息修改服务设施
     *
     * @param facilityNum
     * @param facilityName
     * @param facilityType
     * @param facilityPrice
     * @param facilityPercentage
     * @return
     */
    @Override
    public boolean modifyFacilityByInformationSer(String facilityNum, String facilityName, Integer facilityType, BigDecimal facilityPrice, Double facilityPercentage) {
        return baseMapper.modifyFacilityDAO(facilityNum, facilityName, facilityType, facilityPrice, facilityPercentage);
    }


}
