package com.julong.enterpriseeureka.vo;


import lombok.Data;

@Data
public class ZhuYuanVo {

  /*  String getZhuYuan (String riqi);

    String getZaiYuan (String riqi);


    String getChuYuan (@Param(value = "riqi") String riqi);


    String getWeiJi (String riqi);*/

    String zhuyuan;
    String zaiyuan;
    String chuyuan;
    String weiji;

    String bzchuangwei;
    String shiyongchuangwei;
    String shiyonglv;


}
