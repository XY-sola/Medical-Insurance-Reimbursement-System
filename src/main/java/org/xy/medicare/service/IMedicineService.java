package org.xy.medicare.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import io.lettuce.core.dynamic.annotation.Param;
import org.xy.medicare.entity.Medicine;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @description:对Medicine实体的服务层接口
 * @author: XY-GYL
 * @time: 2022/5/29 17:10
 */

public interface IMedicineService extends IService<Medicine> {

    /**
     * 根据名称、类别、价格查找药品数量
     *
     * @param medicineName
     * @param medicineType
     * @param medicinePrice
     * @return
     */
    public int countMedicineByNameTypePriceSER(String medicineName, Integer medicineType, BigDecimal medicinePrice);

    /**
     * 查询所有药品并分页显示
     *
     * @return 分页结果
     */
    public PageInfo<Map<String, Object>> findAllMedicineInPagesSer(int pageNum, int pageSize);

    /**
     * 根据药品编号删除药品信息
     *
     * @param medicineNum
     * @return 删除结果
     */
    public boolean deleteMedicineByMedicineNumSer(String medicineNum);

    /**
     * 根据信息添加药品
     *
     * @param medicineName
     * @param medicineType
     * @param medicinePrice
     * @param medicineProducer
     * @return
     */
    public boolean addMedicineByInformationSer(String medicineName, Integer medicineType, BigDecimal medicinePrice, String medicineProducer);

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
    public boolean modifyMedicineByInformationSer(String medicineNum, String medicineName, Integer medicineType, BigDecimal medicinePrice, String medicineProducer);


}
