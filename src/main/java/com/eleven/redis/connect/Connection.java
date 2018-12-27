package com.eleven.redis.connect;

import com.eleven.redis.protocol.Protocol;

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

    //todo 实现IO复用
    public Connection connection(){
        try {
            if(!isConnected()){
                socket = new Socket(host,port);
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return this;
    }

    public Connection sendCommand( Protocol.Command command, byte[] ...args){
        connection();

        Protocol.sendCommand(outputStream,command,args);

        return this;
    }

    public String getStatusCodeReply(){
        byte[] bytes = new byte[1024];
        try {
             socket.getInputStream().read(bytes);
        }catch (Exception e){

        }
        return new String(bytes);
    }

    public boolean isConnected(){
        return socket != null && socket.isBound();
    }
}
