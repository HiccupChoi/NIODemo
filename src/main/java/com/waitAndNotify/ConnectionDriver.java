package com.waitAndNotify;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * @Author: Hiccup
 * @Date: 2019/12/23 17:56
 */
public class ConnectionDriver {

    static class ConnectionHandler implements InvocationHandler{
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().contains("commit")){
                Thread.sleep(100);
            }
            return null;
        }
    }

    /**
     * 创建connection
     */
    public static final Connection createConnection(){
        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(), new Class[]{Connection.class}, new ConnectionHandler());
    }

}
