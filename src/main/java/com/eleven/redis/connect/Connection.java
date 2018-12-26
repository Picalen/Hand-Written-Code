package com.eleven.redis.connect;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 模拟redis通讯传输层
 *
 * @author sunchao
 * @date 2018/12/26
 */


public class Connection {
    private Socket socket;
    private String host;
    private int port;
    private OutputStream outputStream;
    private InputStream inputStream;

    public Connection(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Connection connection(){
        try {
            socket = new Socket(host,port);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
        }catch (Exception e){
            e.printStackTrace();
        }

        return this;
    }

//    public Connection sendCommand(){
//
//    }
}
