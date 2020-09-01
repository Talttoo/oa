package com.julong.enterpriseeureka.spyy.service.impl;

//import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.julong.enterpriseeureka.spyy.entity.A1;
import com.julong.enterpriseeureka.spyy.mapper.A1Mapper;
import com.julong.enterpriseeureka.spyy.service.IA1Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-01-06
 */
@Service
@Transactional
@Slf4j
public class A1ServiceImpl extends ServiceImpl<A1Mapper, A1> implements IA1Service {

//    @LcnTransaction
    @Transactional
    @Override
    public int charu() {

        log.info("------------------------------");
        A1 a1 = new A1();
        a1.setAid(1D);
        a1.setState("yihao");
        this.save(a1);
//        int i = 1 / 0;

        A1 a2 = new A1();
        a2.setAid(2D);
        a2.setState("erhao");
        this.save(a2);

        return 0;
    }
}



