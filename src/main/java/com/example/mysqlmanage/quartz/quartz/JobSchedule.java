package com.example.mysqlmanage.quartz.quartz;

import com.example.mysqlmanage.quartz.service.ScheduleJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2021/6/25
 * description:
 */
@Component
public class JobSchedule implements CommandLineRunner {
    @Autowired
    private ScheduleJobService scheduleJobService;

    /**
     * 初始化定时任务
     */
    @Override
    public void run(String... strings)
            throws Exception
    {
        System.out.println("==============开始初始化定时任务==============");
        scheduleJobService.initTask();
        System.out.println("==============初始化定时任务结束==============");
    }
}
