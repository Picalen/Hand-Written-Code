package com.eleven.redis;

import com.eleven.redis.client.Client;
import redis.clients.jedis.Jedis;

/**
 * redis客户端 jedis使用测试
 *
 * @author sunchao
 * @date 2018/12/26
 *
 * Jedis 与 Redis 通讯，本质上由上而下分为三层，api操作层,message protocol层(消息协议层),transfer传输层。
 */


public class RedisTest {

//    public static void main(String[] args){
//        Jedis jedis = new Jedis("47.98.237.88",6379);
////        jedis.set("food", "apple");
//        String value = jedis.get("food");
//        System.out.println(value);
//    }

    public static void main(String[] args){
        Client client = new Client("47.98.237.88",6379);
        System.out.println(client.set("food", "beatbox123"));
        System.out.println(client.get("food"));
//        String value = client.get("food");
//        System.out.println(value);
    }
}
