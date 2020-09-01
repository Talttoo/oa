package com.julong.enterpriseeureka.spyy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.julong.enterpriseeureka.spyy.entity.AsCriticalRemind;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lyt
 * @since 2020-06-24
 */
public interface AsCriticalRemindMapper extends BaseMapper<AsCriticalRemind> {

    List<AsCriticalRemind> getList(String date);

}
