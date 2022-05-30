package org.xy.medicare.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.xy.medicare.entity.Medicine;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @description:medicine表，medicine实体类的Dao
 * @author: XY-GYL
 * @time: 2022/5/29 17:07
 */

public interface IMedicineDAO extends BaseMapper<Medicine> {

    /**
     * 根据名称、类别、价格查找药品数量
     *
     * @param medicineName
     * @param medicineType
     * @param medicinePrice
     * @return
     */
    @Select("select count(medicine_name) " +
            "from medicine " +
            "where medicine_name=#{medicineName} and medicine_type=#{medicineType} and medicine_price=#{medicinePrice}; ")
    public int countMedicineByNameTypePriceDAO(@Param("medicine_name") String medicineName,
                                               @Param("medicine_type") Integer medicineType,
                                               @Param("medicine_price") BigDecimal medicinePrice);

    /**
     * 查询所有药品信息
     *
     * @return Medicine列表
     */
    @Select("select * " +
            "from medicine ")
    public List<Map<String, Object>> findAllMedicineDAO();

    /**
     * 根据药品编号删除药品信息
     *
     * @param medicineNum
     * @return 删除结果
     */
    @Delete("DELETE FROM medicine  " +
            "WHERE medicine_num = #{medicineNum}; ")
    public boolean deleteMedicineByMedicineNumDAO(@Param("medicine_num") String medicineNum);

    /**
     * 根据信息添加药品
     *
     * @param medicineNum
     * @param medicineName
     * @param medicineType
     * @param medicinePrice
     * @param medicineProducer
     * @return
     */
    @Insert("insert into medicine " +
            "values (#{medicineNum},#{medicineName},#{medicineType},#{medicinePrice},#{medicineProducer}); ")
    public boolean insertNewMedicineDAO(@Param("medicine_num") String medicineNum,
                                        @Param("medicine_name") String medicineName,
                                        @Param("medicine_type") Integer medicineType,
                                        @Param("medicine_price") BigDecimal medicinePrice,
                                        @Param("medicine_producer") String medicineProducer);

    /**
     * 根据信息修改药品
     *
     * @param medicineNum
     * @param medicineName
     * @param medicineType
     * @param medicinePrice
     * @param medicineProducer
     * @return
     */
    @Update("update medicine " +
            "set medicine_name = #{medicineName},medicine_type=#{medicineType},medicine_price=#{medicinePrice},medicine_producer=#{medicineProducer}   " +
            "where medicine_num=#{medicineNum};" )
    public boolean modifyMedicineDAO(@Param("medicine_num") String medicineNum,
                                     @Param("medicine_name") String medicineName,
                                     @Param("medicine_type") Integer medicineType,
                                     @Param("medicine_price") BigDecimal medicinePrice,
                                     @Param("medicine_producer") String medicineProducer);

}
