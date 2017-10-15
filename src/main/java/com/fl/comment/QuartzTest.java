package com.fl.comment;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.SimpleTriggerImpl;

import java.util.Date;

/**
 * Created by chenfeilong on 2017/10/11.
 */
public class QuartzTest {

    public static void main(String[] args) {
        // TODO 自动生成方法存根
        QuartzTest q = new QuartzTest();
        try {
            q.startScheduler();
        } catch (SchedulerException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        }
    }
    protected void startScheduler() throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        JobDetail jobDetail =new JobDetailImpl("testJob", Scheduler.DEFAULT_GROUP, MyJob.class);
        //结束时间
        long end = System.currentTimeMillis() + 12000L;
        //执行10次，每3秒执行一次，到9秒后结束
        SimpleTrigger trigger = new SimpleTriggerImpl("test",null,new Date(),new Date(end),10,3000L);
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }

}
