package org.xy.medicare.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.xy.medicare.entity.Institution;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @description:institution表，institution实体类的Dao
 * @author: XY-GYL
 * @time: 2022/5/30 8:46
 */

public interface IInstitutionDAO extends BaseMapper<Institution> {

    /**
     * 根据名称、类别查找定点机构数量
     *
     * @param institutionName
     * @param institutionType
     * @return
     */
    @Select("select count(institution_name) " +
            "from institution " +
            "where institution_name=#{institutionName} and institution_type=#{institutionType} ; ")
    public int countInstitutionByNameTypeDAO(@Param("institution_name") String institutionName,
                                             @Param("institution_type") Integer institutionType);


    /**
     * 查询所有定点机构信息
     *
     * @return Institution列表
     */
    @Select("select * " +
            "from institution ")
    public List<Map<String, Object>> findAllInstitutionDAO();

    /**
     * 根据定点机构编号删除定点机构
     *
     * @param institutionNum
     * @return 删除结果
     */
    @Delete("DELETE FROM institution  " +
            "WHERE institution_num=#{institutionNum}; ")
    public boolean deleteInstitutionByInstitutionNumDAO(@Param("institution_num") String institutionNum);

    /**
     * 根据信息添加定点机构
     *
     * @param institutionNum
     * @param institutionName
     * @param institutionType
     * @param institutionTelephone
     * @param institutionAddress
     * @return
     */
    @Insert("insert into institution " +
            "values (#{institutionNum},#{institutionName},#{institutionType},#{institutionTelephone},#{institutionAddress}); ")
    public boolean insertNewInstitutionDAO(@Param("institution_num") String institutionNum,
                                           @Param("institution_name") String institutionName,
                                           @Param("institution_type") Integer institutionType,
                                           @Param("institution_telephone") String institutionTelephone,
                                           @Param("institution_address") String institutionAddress);

    /**
     * 根据信息修改定点机构
     *
     * @param institutionNum
     * @param institutionName
     * @param institutionType
     * @param institutionTelephone
     * @param institutionAddress
     * @return
     */
    @Update("update institution " +
            "set institution_name = #{institutionName},institution_type=#{institutionType},institution_telephone=#{institutionTelephone},institution_address=#{institutionAddress}   " +
            "where institution_num=#{institutionNum};")
    public boolean modifyInstitutionDAO(@Param("institution_num") String institutionNum,
                                        @Param("institution_name") String institutionName,
                                        @Param("institution_type") Integer institutionType,
                                        @Param("institution_telephone") String institutionTelephone,
                                        @Param("institution_address") String institutionAddress);

}
