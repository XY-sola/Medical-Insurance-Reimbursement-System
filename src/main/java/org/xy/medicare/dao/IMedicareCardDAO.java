package org.xy.medicare.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.xy.medicare.entity.MedicareCard;

import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * @description:medicare_card表，medicare_card实体类的Dao
 * @author: XY-GYL
 * @time: 2022/5/26 15:20
 */

public interface IMedicareCardDAO extends BaseMapper<MedicareCard> {

    /**
     * 根据账号查找医保人员身份证号并返回结果
     *
     * @return 身份证号
     */
    @Select("SELECT identity_card_num " +
            "FROM medicare_card " +
            "WHERE medicare_card_num = #{medicareCardNum}; ")
    public String selectIdentityCardNumByMedicareCardNum(@Param("medicareCardNum") String medicareCardNum);

    /**
     * 根据账号查找医保人员姓名并返回结果
     *
     * @return 姓名
     */
    @Select("SELECT medicare_name " +
            "FROM medicare_card " +
            "WHERE medicare_card_num = #{medicareCardNum}; ")
    public String selectMedicareNameByMedicareCardNum(@Param("medicareCardNum") String medicareCardNum);

    /**
     * 查询所有未注册的医保人员
     *
     * @return Medicare_Card列表
     */
    @Select("SELECT medicare_card_num, identity_card_num,medicare_name,medicare_sex,medicare_age " +
            "FROM medicare_card " +
            "WHERE medicare_card_num NOT IN ( " +
            "SELECT medicare_card.medicare_card_num " +
            "FROM user, medicare_card " +
            "WHERE medicare_card.medicare_card_num = user.account) " )
    public List<Map<String, Object>> findNotRegisterMedicareCard();

    /**
     * 查询单个医保人员
     *
     * @return Medicare_Card列表
     */
    @Select("select * " +
            "from medicare_card " +
            "where medicare_card_num = #{medicareCardNum}; " )
    public Map<String,Object> findTheMedicareCardByMedicareCardNumDAO(@Param("medicare_card_num") String medicareCardNum);

    /**
     * 查询所有医保人员
     *
     * @return Medicare_Card列表
     */
    @Select("select * " +
            "from medicare_card " )
    public List<Map<String, Object>> findAllMedicareCard();

    /**
     * 根据医保号删除医保人员
     * @param medicareCardNum
     * @return 删除结果
     */
    @Delete("DELETE FROM medicare_card  " +
            "WHERE medicare_card_num = #{medicareCardNum}; ")
    public boolean deleteMedicareCardByMedicareCardNumDAO(@Param("medicare_card_num") String medicareCardNum);

    /**
     * 根据信息添加医保人员
     * @param medicareCardNum
     * @param identityCardNum
     * @param medicareType
     * @param medicareStatus
     * @param medicareName
     * @param medicareSex
     * @param medicareAge
     * @param medicareNation
     * @param insuranceTime
     * @return
     */
    @Insert("insert into medicare_card " +
            "values (#{medicareCardNum},#{identityCardNum},#{medicareType},#{medicareStatus},#{medicareName},#{medicareSex},#{medicareAge},#{medicareNation},#{insuranceTime});")
    public boolean insertNewMedicareCardDAO(@Param("medicare_card_num") String medicareCardNum,
                                            @Param("identity_card_num") String identityCardNum,
                                            @Param("medicare_type") Integer medicareType,
                                            @Param("medicare_status") Integer medicareStatus,
                                            @Param("medicare_name") String medicareName,
                                            @Param("medicare_sex") Integer medicareSex,
                                            @Param("medicare_age") Integer medicareAge,
                                            @Param("medicare_nation") String medicareNation,
                                            @Param("insurance_time") Date insuranceTime);

}
