package org.xy.medicare.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import org.xy.medicare.entity.Facility;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @description:对Facility实体的服务层接口
 * @author: XY-GYL
 * @time: 2022/5/30 9:19
 */

public interface IFacilityService extends IService<Facility> {

    /**
     * 根据名称、类别、价格、自费比例查找服务设施数量
     *
     * @param facilityName
     * @param facilityType
     * @return
     */
    public int countFacilityByNameTypePricePercentageSER(String facilityName, Integer facilityType, BigDecimal facilityPrice, Double facilityPercentage);

    /**
     * 查询所有服务设施并分页显示
     *
     * @return 分页结果
     */
    public PageInfo<Map<String, Object>> findAllFacilityInPagesSer(int pageNum, int pageSize);

    /**
     * 根据服务设施编号删除服务设施
     *
     * @param facilityNum
     * @return 删除结果
     */
    public boolean deleteFacilityByFacilityNumSer(String facilityNum);

    /**
     * 根据信息添加服务设施
     *
     * @param facilityName
     * @param facilityType
     * @param facilityPrice
     * @param facilityPercentage
     * @return
     */
    public boolean addFacilityByInformationSer( String facilityName, Integer facilityType, BigDecimal facilityPrice, Double facilityPercentage);

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
    public boolean modifyFacilityByInformationSer(String facilityNum, String facilityName, Integer facilityType, BigDecimal facilityPrice, Double facilityPercentage);

}
