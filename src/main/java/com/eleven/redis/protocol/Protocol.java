package com.eleven.redis.protocol;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 协议层
 *
 * @author sunchao
 * @date 2018/12/26
 */


public class Protocol {
    public static final String DOLLAR_BYTE = "$";
    public static final String ASTERISK_BYTE = "*";
    public static final String BLANK_STRING = "\r\n";

    /**
     * redis数据组装  拼接处JedisHack截取到的数据
     * */
    public static void sendCommand(OutputStream os,Command command,byte[] ...args){
        StringBuffer buffer = new StringBuffer();
        //*3
        buffer.append(ASTERISK_BYTE).append(args.length+1).append(BLANK_STRING);
        //$3
        buffer.append(DOLLAR_BYTE).append(command.name().length()).append(BLANK_STRING);
        //SET
        buffer.append(command.name()).append(BLANK_STRING);
        //$4
        //food
        //$5
        //apple
        for(final byte[] arg:args){
            buffer.append(DOLLAR_BYTE).append(arg.length).append(BLANK_STRING);
            buffer.append(new String(arg)).append(BLANK_STRING);
        }
//        System.out.println(buffer.toString());
        try {
            os.write(buffer.toString().getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }

    }


    public static enum Command{
        GET,SET,KEYS
    }

}
