package org.xy.medicare.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import org.xy.medicare.entity.MedicareCard;

import java.sql.Date;
import java.util.Map;

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
    public int countMedicareCardByAccountSer(String account);

    /**
     * 根据身份证号查找医保人员数量并返回结果
     *
     * @param identityNum 身份证号
     * @return 此人员的个数
     */
    public int countMedicareCardByIdentityNumSer(String identityNum);

    /**
     * 根据账号查找医保人员身份证号并返回结果
     *
     * @param account 账号
     * @return 身份证号
     */
    public String findMedicareCardIdentityNumByAccountSer(String account);

    /**
     * 根据账号查找医保人员姓名并返回结果
     *
     * @param account 账号
     * @return 姓名
     */
    public String findMedicareNameByAccountSer(String account);

    /**
     * 查询未注册的医保人员并分页显示
     *
     * @return 分页结果
     */
    public PageInfo<Map<String, Object>> findNotRegisterMedicareCardInPagesSer(int pageNum, int pageSize);

    /**
     * 查询单个医保人员
     *
     * @return 医保人员信息
     */
    public Map<String, Object> findTheMedicareCardByWorkerMedicareCardNumSer(String medicareCardNum);

    /**
     * 查询所有医保人员并分页显示
     *
     * @return 分页结果
     */
    public PageInfo<Map<String, Object>> findAllMedicareCardInPagesSer(int pageNum, int pageSize);

    /**
     * 根据医保号删除医保人员信息
     *
     * @param medicareCardNum
     * @return 删除结果
     */
    public boolean deleteMedicareCardByMedicareCardNumSer(String medicareCardNum);

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
    public boolean addMedicareCardByInformationSer(String medicareCardNum, String identityCardNum, Integer medicareType, Integer medicareStatus, String medicareName, Integer medicareSex, Integer medicareAge, String medicareNation, Date insuranceTime);

}
