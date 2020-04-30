package com.waitAndNotify;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @Author: Hiccup
 * @Date: 2019/12/23 17:52
 */
public class ConnectionPool {

    /**
     * 链接池
     */
    private LinkedList<Connection> pool = new LinkedList();

    public ConnectionPool(int initialSize) {
        if (initialSize > 0){
            for (int i = 0; i < initialSize; i++) {
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    public void releaseConnectiin(Connection connection){
        if (connection != null){
            synchronized (pool){
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool){
            if (mills <= 0){
                while (pool.isEmpty()){
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                while (pool.isEmpty() && remaining > 0){
                    pool.wait();
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;
                if (!pool.isEmpty()){
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }
}
