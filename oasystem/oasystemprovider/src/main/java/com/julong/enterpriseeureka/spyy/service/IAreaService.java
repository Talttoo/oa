package com.julong.enterpriseeureka.spyy.service;

import com.julong.enterpriseeureka.spyy.entity.Area;
import com.baomidou.mybatisplus.extension.service.IService;
import com.julong.enterpriseeureka.vo.*;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-07-09
 */
//@Mapper
//@Transactional
public interface IAreaService {


     ZongHeQueryVo getMenZhenDataByRiQi(String riqi);
     List<MenZhenShouRuReturn> getMenzhenKeShiShouRu(QueryDateVo querydatevo);
     List<ZhuYuanShouRuReturn> getZhuYuanShouru(QueryDateVo querydatevo);
}
