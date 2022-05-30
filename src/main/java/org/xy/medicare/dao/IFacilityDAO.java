package org.xy.medicare.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.xy.medicare.entity.Facility;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @description:service_facility表，facility实体类的Dao
 * @author: XY-GYL
 * @time: 2022/5/30 8:46
 */

public interface IFacilityDAO extends BaseMapper<Facility> {

    /**
     * 根据名称、类别、价格、比例查找服务设施数量
     *
     * @param facilityName
     * @param facilityType
     * @param facilityPrice
     * @param facilityPercentage
     * @return
     */
    @Select("select count(service_facility_name) " +
            "from service_facility " +
            "where service_facility_name=#{facilityName} and service_facility_type=#{facilityType} and service_facility_price=#{facilityPrice} and service_facility_percentage=#{facilityPercentage}; ")
    public int countFacilityByNameTypePricePercentageDAO(@Param("service_facility_name") String facilityName,
                                                         @Param("service_facility_type") Integer facilityType,
                                                         @Param("service_facility_price") BigDecimal facilityPrice,
                                                         @Param("service_facility_percentage") Double facilityPercentage);


    /**
     * 查询所有服务设施信息
     *
     * @return Facility列表
     */
    @Select("select * " +
            "from service_facility ")
    public List<Map<String, Object>> findAllFacilityDAO();

    /**
     * 根据服务设施编号删除服务设施
     *
     * @param facilityNum
     * @return 删除结果
     */
    @Delete("DELETE FROM service_facility  " +
            "WHERE service_facility_num = #{facilityNum}; ")
    public boolean deleteFacilityByFacilityNumDAO(@Param("service_facility_num") String facilityNum);

    /**
     * 根据信息添加服务设施
     *
     * @param facilityNum
     * @param facilityName
     * @param facilityType
     * @param facilityPrice
     * @param facilityPercentage
     * @return
     */
    @Insert("insert into service_facility " +
            "values (#{facilityNum},#{facilityName},#{facilityType},#{facilityPrice},#{facilityPercentage}); ")
    public boolean insertNewFacilityDAO(@Param("service_facility_num") String facilityNum,
                                        @Param("service_facility_name") String facilityName,
                                        @Param("service_facility_type") Integer facilityType,
                                        @Param("service_facility_price") BigDecimal facilityPrice,
                                        @Param("service_facility_percentage") Double facilityPercentage);

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
    @Update("update service_facility " +
            "set service_facility_name = #{facilityName},service_facility_type=#{facilityType},service_facility_price=#{facilityPrice},service_facility_percentage=#{facilityPercentage}   " +
            "where service_facility_num=#{facilityNum};")
    public boolean modifyFacilityDAO(@Param("service_facility_num") String facilityNum,
                                     @Param("service_facility_name") String facilityName,
                                     @Param("service_facility_type") Integer facilityType,
                                     @Param("service_facility_price") BigDecimal facilityPrice,
                                     @Param("service_facility_percentage") Double facilityPercentage);

}
