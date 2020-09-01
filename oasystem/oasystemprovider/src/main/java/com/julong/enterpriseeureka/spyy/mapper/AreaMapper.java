package com.julong.enterpriseeureka.spyy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.julong.enterpriseeureka.spyy.entity.Area;
import com.julong.enterpriseeureka.vo.MenZhenShouRuReturn;
import com.julong.enterpriseeureka.vo.QueryDateVo;
import com.julong.enterpriseeureka.vo.ZhuYuanShouRuReturn;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-07-09
 */
//@DS("two")
public interface AreaMapper extends BaseMapper<Object> {


    /**
     * @return --每天急诊人数
     */
//    门诊动态
    String getJiZhenRenShu(String riqi);


    String getMenZhenRenShu(String riqi);


    String getZonRenShu(String riqi);


    String getChuFangZonJinE(String riqi);

    String getChuFangShu(String riqi);


    String getZonshouRu(String riqi);


    String getYaopinshouRu(String riqi);


//    住院动态

    String getZhuYuan(String riqi);

    String getZaiYuan(String riqi);


    String getChuYuan(@Param(value = "riqi") String riqi);


    String getWeiJi(String riqi);


    //    床位
    String getShiYongChuangWei(String riqi);

    //编制床位
    String getBZChuangWei(String riqi);


    //门诊科室收入分类汇总报表
    List<MenZhenShouRuReturn> getMenzhenKeShiShouRu(QueryDateVo riqi);


    //门诊科室收入分类汇总报表
    List<ZhuYuanShouRuReturn> getZhuShouRu(QueryDateVo riqi);


}
