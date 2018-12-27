package com.eleven.redis.hack;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟Jedis收发消息 服务端破解
 *
 * @author sunchao
 * @date 2018/12/26
 */


public class JedisHack {

    /**
     * 可以获取到传输命令集
     *      *3
            $3
            SET
            $4
            food
            $5
            apple
     *
     * */
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(6379);
        Socket socket = serverSocket.accept();
        byte[] bytes = new byte[1024];
        socket.getInputStream().read(bytes);
        System.out.println(new String(bytes));
    }
}
