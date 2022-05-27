package org.xy.medicare.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.xy.medicare.entity.MedicareCard;

/**
 * @description:对MedicareCard实体的服务层接口
 * @author: XY-GYL
 * @time: 2022/5/26 15:22
 */

public interface IMedicareCardService extends IService<MedicareCard> {

    /**
     * 根据账号查找医保人员数量并返回结果
     *
     * @param account 账号
     * @return 此人员的个数
     */
    public int countMedicareCardByAccount(String account);

    /**
     * 根据账号查找医保人员身份证号并返回结果
     *
     * @param account 账号
     * @return 身份证号
     */
    public String findMedicareCardIdentityNumByAccount(String account);

    /**
     * 根据账号查找医保人员姓名并返回结果
     *
     * @param account 账号
     * @return 姓名
     */
    public String findMedicareNameByAccount(String account);
}
