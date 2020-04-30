package com.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
 
public class MyTimerTask extends TimerTask {
    @Override
    public void run() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
        System.out.println("Current Time："+format.format(calendar.getTime()));//获取当前系统时间
        System.out.println("NO.1");
    }
    public static void main(String[] args) {
        MyTimerTask task = new MyTimerTask();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
        System.out.println(format.format(calendar.getTime()));
        calendar.add(Calendar.SECOND,3);//获取距离当前时间3秒后的时间
        Timer timer = new Timer();
        timer.schedule(task,calendar.getTime(), 2000);
 
    }
}