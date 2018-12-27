package com.eleven.redis.client;

import com.eleven.redis.connect.Connection;
import com.eleven.redis.protocol.Protocol;

/**
 * 对外提供接口层,api暴露层
 *
 * @author sunchao
 * @date 2018/12/26
 */


public class Client {

    Connection connection;

    public Client(String host,int port) {
        this.connection = new Connection(host,port);
    }

    public String set(String key, String value){
        //todo

        connection.sendCommand(Protocol.Command.SET,key.getBytes(),value.getBytes());

        return connection.getStatusCodeReply();
    }

    public String get(String key){
        connection.sendCommand(Protocol.Command.GET,key.getBytes());
        return connection.getStatusCodeReply();
    }

}
