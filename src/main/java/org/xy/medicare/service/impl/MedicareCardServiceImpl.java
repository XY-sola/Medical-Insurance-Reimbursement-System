package org.xy.medicare.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.xy.medicare.dao.IMedicareCardDAO;
import org.xy.medicare.entity.MedicareCard;
import org.xy.medicare.service.IMedicareCardService;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @description:实现对medicare_card表（医保信息）的服务
 * @author: XY-GYL
 * @time: 2022/5/26 15:05
 */

@Service
public class MedicareCardServiceImpl extends ServiceImpl<IMedicareCardDAO, MedicareCard> implements IMedicareCardService {

    /**
     * 根据账号查找医保人员数量并返回结果
     *
     * @param account 账号
     * @return 此人员的个数
     */
    @Override
    public int countMedicareCardByAccountSer(String account) {
        return query().eq("medicare_card_num", account).count();
    }

    /**
     * 根据身份证号查找医保人员数量并返回结果
     *
     * @param identityNum 身份证号
     * @return 此人员的个数
     */
    @Override
    public int countMedicareCardByIdentityNumSer(String identityNum) {
        return query().eq("identity_card_num", identityNum).count();
    }

    /**
     * 根据账号查找医保人员身份证号并返回结果
     *
     * @param account 账号
     * @return 身份证号
     */
    @Override
    public String findMedicareCardIdentityNumByAccountSer(String account) {
        Map<String, Object> map = new HashMap<>();
        map = baseMapper.findTheMedicareCardByMedicareCardNumDAO(account);
        System.out.println("顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶" + map);

        return baseMapper.selectIdentityCardNumByMedicareCardNum(account);
    }

    /**
     * 根据账号查找医保人员姓名并返回结果
     *
     * @param account 账号
     * @return 姓名
     */
    @Override
    public String findMedicareNameByAccountSer(String account) {
        return baseMapper.selectMedicareNameByMedicareCardNum(account);
    }

    /**
     * 查询未注册的医保人员并分页显示
     *
     * @return 分页结果
     */
    @Override
    public PageInfo<Map<String, Object>> findNotRegisterMedicareCardInPagesSer(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> list = baseMapper.findNotRegisterMedicareCard();
        //如果数据为空
        if (list.size() == 0) {
            return null;
        }
        //将数字转为文字
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("medicare_sex").equals(0)) {
                list.get(i).put("medicare_sex", "男");
            } else if (list.get(i).get("medicare_sex").equals(1)) {
                list.get(i).put("medicare_sex", "女");
            }
        }
        PageInfo<Map<String, Object>> pageInfo = new PageInfo(list);
        return pageInfo;
    }

    /**
     * 查询单个医保人员
     *
     * @return 医保人员信息
     */
    @Override
    public Map<String, Object> findTheMedicareCardByWorkerMedicareCardNumSer(String medicareCardNum) {
        Map<String, Object> map = baseMapper.findTheMedicareCardByMedicareCardNumDAO(medicareCardNum);
        //将数字转为文字
        if (map.get("medicare_type").equals(1)) {
            map.put("medicare_type", "城镇职工医保");
        } else if (map.get("medicare_type").equals(2)) {
            map.put("medicare_type", "城镇居民医保");
        } else if (map.get("medicare_type").equals(3)) {
            map.put("medicare_type", "新农合医保");
        }
        if (map.get("medicare_status").equals(0)) {
            map.put("medicare_status", "未缴费");
        } else if (map.get("medicare_status").equals(1)) {
            map.put("medicare_status", "已缴费");
        }
        if (map.get("medicare_sex").equals(0)) {
            map.put("medicare_sex", "男");
        } else if (map.get("medicare_sex").equals(1)) {
            map.put("medicare_sex", "女");
        }
        return map;
    }

    /**
     * 查询所有医保人员并分页显示
     *
     * @return 分页结果
     */
    @Override
    public PageInfo<Map<String, Object>> findAllMedicareCardInPagesSer(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> list = baseMapper.findAllMedicareCard();
        //如果数据为空
        if (list.size() == 0) {
            return null;
        }
        //将数字转为文字
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("medicare_type").equals(1)) {
                list.get(i).put("medicare_type", "城镇职工医保");
            } else if (list.get(i).get("medicare_type").equals(2)) {
                list.get(i).put("medicare_type", "城镇居民医保");
            } else if (list.get(i).get("medicare_type").equals(3)) {
                list.get(i).put("medicare_type", "新农合医保");
            }
            if (list.get(i).get("medicare_status").equals(0)) {
                list.get(i).put("medicare_status", "未缴费");
            } else if (list.get(i).get("medicare_status").equals(1)) {
                list.get(i).put("medicare_status", "已缴费");
            }
            if (list.get(i).get("medicare_sex").equals(0)) {
                list.get(i).put("medicare_sex", "男");
            } else if (list.get(i).get("medicare_sex").equals(1)) {
                list.get(i).put("medicare_sex", "女");
            }
        }
        PageInfo<Map<String, Object>> pageInfo = new PageInfo(list);
        return pageInfo;
    }

    /**
     * 根据医保号删除医保人员信息
     *
     * @param medicareCardNum 医保号
     * @return 删除结果
     */
    @Override
    public boolean deleteMedicareCardByMedicareCardNumSer(String medicareCardNum) {
        return baseMapper.deleteMedicareCardByMedicareCardNumDAO(medicareCardNum);
    }

    /**
     * 根据信息添加医保人员
     *
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
    @Override
    public boolean addMedicareCardByInformationSer(String medicareCardNum, String identityCardNum, Integer medicareType, Integer medicareStatus, String medicareName, Integer medicareSex, Integer medicareAge, String medicareNation, Date insuranceTime) {
        return baseMapper.insertNewMedicareCardDAO(medicareCardNum, identityCardNum, medicareType, medicareStatus, medicareName, medicareSex, medicareAge, medicareNation, insuranceTime);
    }


}
