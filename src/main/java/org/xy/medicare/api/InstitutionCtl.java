package org.xy.medicare.api;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xy.medicare.common.http.ResponseResult;
import org.xy.medicare.common.http.StatusCode;
import org.xy.medicare.form.*;
import org.xy.medicare.service.impl.InstitutionServiceImpl;
import org.xy.medicare.service.impl.RequestBaseServiceImpl;
import org.xy.medicare.service.impl.RequestContentServiceImpl;
import org.xy.medicare.service.impl.TreatmentServiceImpl;

import javax.validation.Valid;
import java.util.Map;

/**
 * @description:查找、删除、添加定点机构的控制层接口
 * @author: XY-GYL
 * @time: 2022/5/30 10:09
 */

@CrossOrigin
@RestController
@RequestMapping("/api")
public class InstitutionCtl {

    //自动封装服务层对象
    @Autowired
    private InstitutionServiceImpl ser1;
    @Autowired
    private RequestBaseServiceImpl ser2;

    /**
     * 获取全部定点机构分页列表
     *
     * @param form 包含页码和单页条数
     * @return JSON in response
     */
    @PostMapping("/searchAllInstitutionList")
    public ResponseResult<PageInfo<Map<String, Object>>> searchAllInstitutionListCtl(@RequestBody @Valid SearchListByPageNumAndPageSizeForm form) {
        PageInfo<Map<String, Object>> pager = ser1.findAllInstitutionInPagesSer(form.getPageNum(), form.getPageSize());
        if (pager == null) {
            //定点机构列表为空，视为查询失败
            return ResponseResult.getMessageResult(null, "A071");
        } else {
            return ResponseResult.getMessageResult(pager, "A070", StatusCode.C200);
        }
    }

    /**
     * 根据定点机构编号删除定点机构
     *
     * @param form 包含定点机构编号
     * @return JSON in response
     */
    @PostMapping("/deleteInstitution")
    public ResponseResult<Boolean> deleteInstitutionCtl(@RequestBody @Valid IDForm form) {
        if (ser2.countApplicationByInstitutionNumSer(form.getId()) == 0) {
            boolean res = ser1.deleteInstitutionByInstitutionNumSer(form.getId());
            if (res) {
                return ResponseResult.getSuccessResult(true, "A072", null);
            } else {
                return ResponseResult.getMessageResult(false, "A073");
            }
        } else {
            return ResponseResult.getMessageResult(false, "A074");
        }
    }

    /**
     * 根据信息添加定点机构
     *
     * @param form
     * @return
     */
    @PostMapping("/addInstitution")
    public ResponseResult<Boolean> addInstitutionByInformationCtl(@RequestBody @Valid AddInstitutionForm form) {
        if (ser1.countInstitutionByNameTypeSER(form.getInstitutionName(),form.getInstitutionType()) == 0) {
            boolean res = ser1.addInstitutionByInformationSer(form.getInstitutionName(),form.getInstitutionType(),form.getInstitutionTelephone(),form.getInstitutionAddress());
            if (res) {
                return ResponseResult.getSuccessResult(true, "A075", null);
            } else {
                return ResponseResult.getMessageResult(false, "A076");
            }
        } else {
            return ResponseResult.getMessageResult(false, "A077");
        }
    }

    /**
     * 根据信息修改定点机构
     *
     * @param form
     * @return
     */
    @PostMapping("/modifyInstitution")
    public ResponseResult<Boolean> modifyInstitutionByInformationCtl(@RequestBody @Valid ModifyInstitutionForm form) {
        boolean res = ser1.modifyInstitutionByInformationSer(form.getInstitutionNum(),form.getInstitutionName(),form.getInstitutionType(),form.getInstitutionTelephone(),form.getInstitutionAddress());
        if (res) {
            return ResponseResult.getSuccessResult(true, "A078", null);
        } else {
            return ResponseResult.getMessageResult(false, "A079");
        }
    }

}
