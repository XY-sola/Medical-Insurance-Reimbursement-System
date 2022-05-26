package org.xy.medicare.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.xy.medicare.dao.IMedicareCardDAO;
import org.xy.medicare.entity.MedicareCard;
import org.xy.medicare.service.IMedicareCardService;


/**
 * @description:实现对medicare_card表（医保信息）的服务
 * @author: XY-GYL
 * @time: 2022/5/26 15:05
 */

@Service
public class MedicareCardServiceImpl extends ServiceImpl<IMedicareCardDAO, MedicareCard> implements IMedicareCardService {

    @Override
    public int countMedicareCardByAccount(String account){
        return query().eq("medicare_card_num",account).count();
    }
}
