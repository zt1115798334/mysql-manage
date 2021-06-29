package com.example.mysqlmanage.quartz.service;

import com.example.mysqlmanage.quartz.domain.ScheduleJob;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2021/6/25
 * description:
 */
public interface ScheduleJobService {
    /**
     * 初始化定时任
     */
    void initTask();

    /**
     * 新增定时任务
     */
    void add(ScheduleJob job);

    /**
     * 启动定时任务
     */
    void start(int id);

    /**
     * 暂停定时任务
     */
    void pause(int id);

    /**
     * 删除定时任务
     */
    void delete(int id);

    /**
     * 启动所有定时任务
     */
    void startAllJob();

    /**
     * 暂停所有定时任务
     */
    void pauseAllJob();
}
