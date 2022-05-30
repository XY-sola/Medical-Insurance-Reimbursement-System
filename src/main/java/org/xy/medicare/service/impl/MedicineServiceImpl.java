package org.xy.medicare.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.xy.medicare.dao.IMedicineDAO;
import org.xy.medicare.entity.Medicine;
import org.xy.medicare.service.IMedicineService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @description:实现对medicine表（药品）的服务实现
 * @author: XY-GYL
 * @time: 2022/5/29 17:12
 */

@Service
public class MedicineServiceImpl extends ServiceImpl<IMedicineDAO, Medicine> implements IMedicineService {

    /**
     * 根据名称、类别、价格查找药品数量
     *
     * @param medicineName
     * @param medicineType
     * @param medicinePrice
     * @return
     */
    public int countMedicineByNameTypePriceSER(String medicineName, Integer medicineType, BigDecimal medicinePrice) {
        return baseMapper.countMedicineByNameTypePriceDAO(medicineName, medicineType, medicinePrice);
    }


    /**
     * 查询所有药品并分页显示
     *
     * @return 分页结果
     */
    @Override
    public PageInfo<Map<String, Object>> findAllMedicineInPagesSer(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> list = baseMapper.findAllMedicineDAO();
        //如果数据为空
        if (list.size() == 0) {
            return null;
        }
        //将数字转为文字
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("medicine_type").equals(0)) {
                list.get(i).put("medicine_type", "甲类药品");
            } else if (list.get(i).get("medicine_type").equals(1)) {
                list.get(i).put("medicine_type", "乙类药品");
            } else if (list.get(i).get("medicine_type").equals(2)) {
                list.get(i).put("medicine_type", "丙类药品");
            }
        }
        PageInfo<Map<String, Object>> pageInfo = new PageInfo(list);
        return pageInfo;
    }

    /**
     * 根据药品编号删除药品信息
     *
     * @param medicineNum
     * @return 删除结果
     */
    @Override
    public boolean deleteMedicineByMedicineNumSer(String medicineNum) {
        return baseMapper.deleteMedicineByMedicineNumDAO(medicineNum);
    }

    /**
     * 根据信息添加药品
     *
     * @param medicineName
     * @param medicineType
     * @param medicinePrice
     * @param medicineProducer
     * @return
     */
    @Override
    public boolean addMedicineByInformationSer(String medicineName, Integer medicineType, BigDecimal medicinePrice, String medicineProducer) {
        return baseMapper.insertNewMedicineDAO(UUID.randomUUID().toString(), medicineName, medicineType, medicinePrice, medicineProducer);
    }

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
    @Override
    public boolean modifyMedicineByInformationSer(String medicineNum, String medicineName, Integer medicineType, BigDecimal medicinePrice, String medicineProducer) {
        return baseMapper.modifyMedicineDAO(medicineNum, medicineName, medicineType, medicinePrice, medicineProducer);
    }
}
