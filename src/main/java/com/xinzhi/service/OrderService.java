package com.xinzhi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author：小常
 * @Package：com.xinzhi.service
 * @Project：redis_study
 * @name：OrderService
 * @Date：2023/3/6 14:24
 * @Filename：OrderService
 */
@Service
@Slf4j
public class OrderService {

    public static final String ORDER_KEY="ord:";

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    //添加订单
    public void addOrder(){
        int keyId= ThreadLocalRandom.current().nextInt(1000)+1;
        String serialNo = UUID.randomUUID().toString();

        String key =ORDER_KEY+keyId;
        String value ="京东订单"+serialNo;

        stringRedisTemplate.opsForValue().set(key,value);

        log.info("***key:{}",key);
        log.info("***value:{}",value);
    }

    //根据Id去查
    public String getOrderById(Integer keyId){
        return stringRedisTemplate.opsForValue().get(ORDER_KEY+keyId);
    }

}
