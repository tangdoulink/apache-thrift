package com.zpb.thrift;

import api.HelloService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;

/**
 * @author       pengbo.zhao
 * @description  thrift-client
 * @createDate   2022/1/4 13:56
 * @updateDate   2022/1/4 13:56
 * @version      1.0
 */
public class ThriftClient {
    public static void main(String[] args) throws TException {
        long start = System.currentTimeMillis();
        TSocket tSocket = new TSocket("localhost", 8000);
        TProtocol protocol = new TBinaryProtocol(tSocket);
        HelloService.Client client = new HelloService.Client(protocol);
        tSocket.open();
        String sayHello = client.sayHello("hello thrift");
        System.err.println("服务端响应数据：" + sayHello);
        tSocket.close();
        System.err.println("客户端 rt : " + (System.currentTimeMillis() - start));
    }
}
