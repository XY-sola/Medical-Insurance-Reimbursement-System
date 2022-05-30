package org.xy.medicare.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.xy.medicare.entity.Treatment;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @description:treatment_project表，treatment实体类的Dao
 * @author: XY-GYL
 * @time: 2022/5/29 22:11
 */

public interface ITreatmentDAO extends BaseMapper<Treatment> {

    /**
     * 根据名称、类别、价格、比例查找诊疗项目数量
     *
     * @param treatmentName
     * @param treatmentType
     * @param treatmentPrice
     * @param treatmentPercentage
     * @return
     */
    @Select("select count(treatment_project_name) " +
            "from treatment_project " +
            "where treatment_project_name=#{treatmentName} and treatment_project_type=#{treatmentType} and treatment_project_price=#{treatmentPrice} and treatment_project_percentage=#{treatmentPercentage}; ")
    public int countTreatmentByNameTypePricePercentageDAO(@Param("treatment_project_name") String treatmentName,
                                                          @Param("treatment_project_type") Integer treatmentType,
                                                          @Param("treatment_project_price") BigDecimal treatmentPrice,
                                                          @Param("treatment_project_percentage") Double treatmentPercentage);

    /**
     * 查询所有诊疗项目信息
     *
     * @return Treatment列表
     */
    @Select("select * " +
            "from treatment_project ")
    public List<Map<String, Object>> findAllTreatmentDAO();

    /**
     * 根据诊疗项目编号删除诊疗项目
     *
     * @param treatmentNum
     * @return 删除结果
     */
    @Delete("DELETE FROM treatment_project  " +
            "WHERE treatment_project_num = #{treatmentNum}; ")
    public boolean deleteTreatmentByTreatmentNumDAO(@Param("treatment_project_num") String treatmentNum);

    /**
     * 根据信息添加诊疗项目
     *
     * @param treatmentNum
     * @param treatmentName
     * @param treatmentType
     * @param treatmentPrice
     * @param treatmentPercentage
     * @return
     */
    @Insert("insert into treatment_project " +
            "values (#{treatmentNum},#{treatmentName},#{treatmentType},#{treatmentPrice},#{treatmentPercentage}); ")
    public boolean insertNewTreatmentDAO(@Param("treatment_project_num") String treatmentNum,
                                         @Param("treatment_project_name") String treatmentName,
                                         @Param("treatment_project_type") Integer treatmentType,
                                         @Param("treatment_project_price") BigDecimal treatmentPrice,
                                         @Param("treatment_project_percentage") Double treatmentPercentage);

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
    @Update("update treatment_project " +
            "set treatment_project_name = #{treatmentName},treatment_project_type=#{treatmentType},treatment_project_price=#{treatmentPrice},treatment_project_percentage=#{treatmentPercentage}   " +
            "where treatment_project_num=#{treatmentNum};")
    public boolean modifyTreatmentDAO(@Param("treatment_project_num") String treatmentNum,
                                      @Param("treatment_project_name") String treatmentName,
                                      @Param("treatment_project_type") Integer treatmentType,
                                      @Param("treatment_project_price") BigDecimal treatmentPrice,
                                      @Param("treatment_project_percentage") Double treatmentPercentage);


}
