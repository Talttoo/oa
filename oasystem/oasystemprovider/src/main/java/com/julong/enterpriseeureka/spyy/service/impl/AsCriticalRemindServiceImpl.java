package com.julong.enterpriseeureka.spyy.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.julong.enterpriseeureka.spyy.entity.AsCriticalRemind;
import com.julong.enterpriseeureka.spyy.mapper.AsCriticalRemindMapper;
import com.julong.enterpriseeureka.spyy.service.IAsCriticalRemindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lyt
 * @since 2020-06-24
 */
@Transactional
@Service
public class AsCriticalRemindServiceImpl extends ServiceImpl<AsCriticalRemindMapper, AsCriticalRemind> implements IAsCriticalRemindService {

    @Autowired
    AsCriticalRemindMapper asCriticalRemindMapper;

   public JSONObject getList(String date){

       List<AsCriticalRemind> reminds = asCriticalRemindMapper.getList(date);

       System.out.println("reminds:"+reminds.toString());

       JSONObject result = new JSONObject();

       result.put("code",200);
       result.put("msg","success");
       result.put("data",reminds.toString());

       System.out.println("map:"+result.toString());

       //JSONObject result = JSON.parseObject(map.toString());

       return result;

   }
}
