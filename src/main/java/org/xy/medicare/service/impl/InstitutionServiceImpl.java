package org.xy.medicare.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.xy.medicare.dao.IInstitutionDAO;
import org.xy.medicare.entity.Institution;
import org.xy.medicare.service.IInstitutionService;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @description:实现对institution表（定点机构）的服务实现
 * @author: XY-GYL
 * @time: 2022/5/30 9:45
 */

@Service
public class InstitutionServiceImpl extends ServiceImpl<IInstitutionDAO, Institution> implements IInstitutionService {

    /**
     * 根据名称、类别查找定点机构数量
     *
     * @param institutionName
     * @param institutionType
     * @return
     */
    @Override
    public int countInstitutionByNameTypeSER(String institutionName, Integer institutionType) {
        return baseMapper.countInstitutionByNameTypeDAO(institutionName, institutionType);
    }


    /**
     * 查询所有定点机构并分页显示
     *
     * @return 分页结果
     */
    @Override
    public PageInfo<Map<String, Object>> findAllInstitutionInPagesSer(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> list = baseMapper.findAllInstitutionDAO();
        //如果数据为空
        if (list.size() == 0) {
            return null;
        }
        //将数字转为文字
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("institution_type").equals(1)) {
                list.get(i).put("institution_type", "一级医院");
            } else if (list.get(i).get("institution_type").equals(2)) {
                list.get(i).put("institution_type", "二级医院");
            } else if (list.get(i).get("institution_type").equals(3)) {
                list.get(i).put("institution_type", "三级医院");
            }
        }
        PageInfo<Map<String, Object>> pageInfo = new PageInfo(list);
        return pageInfo;
    }

    /**
     * 根据定点机构编号删除定点机构
     *
     * @param institutionNum
     * @return 删除结果
     */
    @Override
    public boolean deleteInstitutionByInstitutionNumSer(String institutionNum) {
        return baseMapper.deleteInstitutionByInstitutionNumDAO(institutionNum);
    }

    /**
     * 根据信息添加定点机构
     *
     * @param institutionName
     * @param institutionType
     * @param institutionTelephone
     * @param institutionAddress
     * @return
     */
    @Override
    public boolean addInstitutionByInformationSer(String institutionName, Integer institutionType, String institutionTelephone, String institutionAddress) {
        return baseMapper.insertNewInstitutionDAO(UUID.randomUUID().toString(), institutionName, institutionType, institutionTelephone, institutionAddress);
    }

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
    @Override
    public boolean modifyInstitutionByInformationSer(String institutionNum, String institutionName, Integer institutionType, String institutionTelephone, String institutionAddress) {
        return baseMapper.modifyInstitutionDAO(institutionNum, institutionName, institutionType, institutionTelephone, institutionAddress);
    }


}
