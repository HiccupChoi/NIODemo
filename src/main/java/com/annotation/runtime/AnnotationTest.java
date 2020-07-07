package com.annotation.runtime;

public class AnnotationTest {

    @Get(value = "http://ip.taobao.com/59.108.54.37")
    public String getIpMsg() {
        return "";
    }

    @Get(value = "http://ip.taobao.com/")
    public String getIp() {
        return "";
    }
}
