package com.julong.enterpriseeureka.spyy.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.julong.enterpriseeureka.spyy.entity.AsCriticalRemind;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lyt
 * @since 2020-06-24
 */
public interface IAsCriticalRemindService extends IService<AsCriticalRemind> {

    JSONObject getList(String date);
}
