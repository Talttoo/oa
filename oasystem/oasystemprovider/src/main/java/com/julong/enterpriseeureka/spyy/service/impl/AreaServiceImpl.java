package com.julong.enterpriseeureka.spyy.service.impl;

import com.julong.enterpriseeureka.spyy.entity.Area;
import com.julong.enterpriseeureka.spyy.mapper.AreaMapper;
import com.julong.enterpriseeureka.spyy.service.IAreaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.julong.enterpriseeureka.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.NumberFormat;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-07-09
 */


@Transactional
@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Object> implements IAreaService {


    @Autowired
    AreaMapper areaMapper;


    @Override
    public ZongHeQueryVo getMenZhenDataByRiQi(String riqi) {

        riqi = riqi.replaceAll("-", ".");

        MenZhenVo menZhenVo = new MenZhenVo();

        String jiZhenRenShu = areaMapper.getJiZhenRenShu(riqi);
        String menZhenRenShu = areaMapper.getMenZhenRenShu(riqi);
        String zonRenShu = areaMapper.getZonRenShu(riqi);
        String chuFangShu = areaMapper.getChuFangShu(riqi);
        String chuFangZonJinE = areaMapper.getChuFangZonJinE(riqi);
        String zonshouRu = areaMapper.getZonshouRu(riqi);
        String yaopinshouru = areaMapper.getYaopinshouRu(riqi);
        double v1 = 0;
        try {
            Double yaopinshouru_d = Double.valueOf(yaopinshouru);
            Double zonshouru_d = Double.valueOf(zonshouRu);


            v1 = yaopinshouru_d / zonshouru_d;
        } catch (Exception e) {

            yaopinshouru="0";
        }

        NumberFormat nf = java.text.NumberFormat.getPercentInstance();
        nf.setMaximumIntegerDigits(2);//小数点前保留几位
        nf.setMinimumFractionDigits(2);// 小数点后保留几位
        String yaopinzhanbi = nf.format(v1);





        
        /*String jiZhenRenShu ="123";
        String menZhenRenShu = "456";
        String zonRenShu = "300";
        String chuFangShu = "350";
        String chuFangZonJinE = String.valueOf(Math.random()*9000+1000);
        */


        menZhenVo.setJizhenrenshu(jiZhenRenShu);
        menZhenVo.setMenzhenrenshu(menZhenRenShu);
        menZhenVo.setZonrenshu(zonRenShu);

        menZhenVo.setChufangshu(chuFangShu);
        menZhenVo.setChufangzonjine(chuFangZonJinE);

        menZhenVo.setZonshouru(zonshouRu);


        menZhenVo.setYaopinshouru(yaopinshouru);

        menZhenVo.setYaopinzhanbi(yaopinzhanbi);

        double v = 0;
        if (!Integer.valueOf(chuFangShu).equals(0)) {
            v = Double.valueOf(chuFangZonJinE) / Integer.valueOf(chuFangShu);
        }
        menZhenVo.setChufangrenjunjine(String.valueOf(v));







        /*住院*/
      /*  String getZhuYuan (String riqi);

        String getZaiYuan (String riqi);


        String getChuYuan (@Param(value = "riqi") String riqi);


        String getWeiJi (String riqi);
*/

        String zhuyuan = areaMapper.getZhuYuan(riqi);
        String chuyuan = areaMapper.getChuYuan(riqi);
        String zaiyuan = areaMapper.getZaiYuan(riqi);
        String weiji = areaMapper.getWeiJi(riqi);

        String bzchuangwei = areaMapper.getBZChuangWei(riqi);

        String shiyongchuangwei = areaMapper.getShiYongChuangWei(riqi);

        bzchuangwei= bzchuangwei==null?"0":bzchuangwei;
        shiyongchuangwei= shiyongchuangwei==null?"0":shiyongchuangwei;
        int bzchuangwei_int = Integer.valueOf(bzchuangwei);
        int shiyongchuangwei_int = Integer.valueOf(shiyongchuangwei);


        // 创建一个数值格式化对象
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(2);
        String shiyonglv = numberFormat.format((float) shiyongchuangwei_int / (float) bzchuangwei_int * 100);

        shiyonglv = shiyonglv + "%";


        ZhuYuanVo zhuYuanVo = new ZhuYuanVo();

        zhuYuanVo.setZhuyuan(zhuyuan);
        zhuYuanVo.setZaiyuan(zaiyuan);
        zhuYuanVo.setChuyuan(chuyuan);
        zhuYuanVo.setWeiji(weiji);

        zhuYuanVo.setBzchuangwei(bzchuangwei);
        zhuYuanVo.setShiyongchuangwei(shiyongchuangwei);
        zhuYuanVo.setShiyonglv(shiyonglv);

        ZongHeQueryVo zonghequeryvo = new ZongHeQueryVo();

        zonghequeryvo.setMenzhenvo(menZhenVo);
        zonghequeryvo.setZhuyuanvo(zhuYuanVo);


        return zonghequeryvo;


    }

    @Override
    public List<MenZhenShouRuReturn> getMenzhenKeShiShouRu(QueryDateVo querydatevo) {


        List<MenZhenShouRuReturn> menzhenKeShiShouRu = areaMapper.getMenzhenKeShiShouRu(querydatevo);

        return menzhenKeShiShouRu;

    }

    @Override
    public List<ZhuYuanShouRuReturn> getZhuYuanShouru(QueryDateVo querydatevo) {

        List<ZhuYuanShouRuReturn> zhuyuanshouru = areaMapper.getZhuShouRu(querydatevo);

        return zhuyuanshouru;
    }


}























