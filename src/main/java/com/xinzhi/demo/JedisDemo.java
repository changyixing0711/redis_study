package com.xinzhi.demo;

import redis.clients.jedis.Jedis;

import java.util.List;
/**
 * @Author：小常
 * @Package：com.xinzhi.Controller
 * @Project：redis_study
 * @name：OrderController
 * @Date：2023/3/6 14:48
 * @Filename：OrderController
 */
public class JedisDemo {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("152.136.17.91", 6379);

        jedis.auth("123456");

        System.out.println(jedis.ping());

        //set
        jedis.set("name","zhangsan");
        String name = jedis.get("name");
        System.out.println(name);


        //mset
        jedis.mset("k1","v1","k2","v2");
        List<String> mget = jedis.mget("k1", "k2");
        System.out.println(mget);

        //lpush
        jedis.lpush("list","1","2","3","4");
        List<String> list = jedis.lrange("list", 0, -1);
        System.out.print(list);

        //rpush
        jedis.rpush("list1", "5", "4", "3", "2", "1");
        List<String> list1 = jedis.lrange("list1", 0, -1);
        System.out.println(list1);
    }
}
