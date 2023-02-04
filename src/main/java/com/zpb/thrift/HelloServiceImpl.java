package com.zpb.thrift;

import api.HelloService;
import org.apache.thrift.TException;

import java.time.LocalDateTime;

/**
 * @author       pengbo.zhao
 * @description  
 * @createDate   2022/1/4 16:19
 * @updateDate   2022/1/4 16:19
 * @version      1.0
 */

public class HelloServiceImpl implements HelloService.Iface {

    @Override
    public String sayHello(String para) throws TException {
        long start = System.currentTimeMillis();

        System.err.println("接收到客户端请求："+ para);
        String message = "hello I'm service "+ LocalDateTime.now();

        System.err.println("服务端 rt :" + (System.currentTimeMillis() - start));

        return message;
    }
}
