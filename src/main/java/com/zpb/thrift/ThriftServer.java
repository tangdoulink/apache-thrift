package com.zpb.thrift;

import api.HelloService;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * @author       pengbo.zhao
 * @description  thrift-service
 * @createDate   2022/1/4 13:56
 * @updateDate   2022/1/4 13:56
 * @version      1.0
 */

public class ThriftServer {
    public static void main(String[] args) throws TTransportException {
        int port = 8000;
        TServerSocket tServerSocket = new TServerSocket(port);
        TServer.Args tServerArgs = new TServer.Args(tServerSocket);
        TProcessor processor = new HelloService.Processor<>(new HelloServiceImpl());
        tServerArgs.processor(processor);
        tServerArgs.protocolFactory(new TBinaryProtocol.Factory());
        TSimpleServer tSimpleServer = new TSimpleServer(tServerArgs);
        System.err.println("thrift-server start ......" + port);
        tSimpleServer.serve();
    }
}
