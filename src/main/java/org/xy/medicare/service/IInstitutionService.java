package org.xy.medicare.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import org.xy.medicare.entity.Institution;

import java.util.Map;

/**
 * @description:对Institution实体的服务层接口
 * @author: XY-GYL
 * @time: 2022/5/30 9:22
 */

public interface IInstitutionService extends IService<Institution> {

    /**
     * 根据名称、类别查找定点机构数量
     * @param institutionName
     * @param institutionType
     * @return
     */
    public int countInstitutionByNameTypeSER(String institutionName, Integer institutionType);


    /**
     * 查询所有定点机构并分页显示
     *
     * @return 分页结果
     */
    public PageInfo<Map<String, Object>> findAllInstitutionInPagesSer(int pageNum, int pageSize);

    /**
     * 根据定点机构编号删除定点机构
     *
     * @param institutionNum
     * @return 删除结果
     */
    public boolean deleteInstitutionByInstitutionNumSer(String institutionNum);

    /**
     * 根据信息添加定点机构
     * @param institutionName
     * @param institutionType
     * @param institutionTelephone
     * @param institutionAddress
     * @return
     */
    public boolean addInstitutionByInformationSer( String institutionName, Integer institutionType, String institutionTelephone, String institutionAddress);

    /**
     * 根据信息修改定点机构
     * @param institutionNum
     * @param institutionName
     * @param institutionType
     * @param institutionTelephone
     * @param institutionAddress
     * @return
     */
    public boolean modifyInstitutionByInformationSer(String institutionNum, String institutionName, Integer institutionType, String institutionTelephone, String institutionAddress);

}
