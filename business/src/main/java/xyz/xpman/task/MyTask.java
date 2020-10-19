package xyz.xpman.task;

import java.util.Date;

/*
    author: Timor
    date: 2020/1/16 0016
*/
public class MyTask implements Runnable{
    @Override
    public void run() {
        System.out.println("[MyTask-定时任务] 当前时间：" + new Date());
    }
}
