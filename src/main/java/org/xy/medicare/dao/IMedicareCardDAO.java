package org.xy.medicare.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Select;
import org.xy.medicare.entity.MedicareCard;

/**
 * @description:medicare_card表，medicare_card实体类的Dao
 * @author: XY-GYL
 * @time: 2022/5/26 15:20
 */

public interface IMedicareCardDAO extends BaseMapper<MedicareCard> {

    @Select("SELECT identity_card_num " +
            "FROM medicare_card " +
            "WHERE medicare_card_num = #{medicareCardNum}; ")
    public String selectIdentityCardNumByMedicareCardNum(@Param("medicareCardNum") String medicareCardNum);

    @Select("SELECT medicare_name " +
            "FROM medicare_card " +
            "WHERE medicare_card_num = #{medicareCardNum}; ")
    public String selectMedicareNameByMedicareCardNum(@Param("medicareCardNum") String medicareCardNum);

}
