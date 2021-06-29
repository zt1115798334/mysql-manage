package com.example.mysqlmanage.quartz.service;

import com.example.mysqlmanage.quartz.domain.ScheduleJob;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2021/6/25
 * description:
 */
public interface QuartzService {

    /**
     * 初始化定时任务
     */
    void initTask(List<ScheduleJob> scheduleJobList);

    /**
     * 新增定时任务
     */
    void addJob(ScheduleJob job);

    /**
     * 暂停、启动、删除定时任务
     * status:pause暂停，start启动，del删除
     */
    void operateJob(String status, ScheduleJob job);

    /**
     * 启动所有定时任务
     */
    void startAllJob();

    /**
     * 暂停所有定时任
     */
    void pauseAllJob();

    /**
     * 更新定时任务
     */
    void updateJob(ScheduleJob job);


    /**
     * 查询所有定时任务
     */
    List<Map<String, Object>> queryAllJob();


    /**
     * 查询所有运行中的定时任务
     */
    List<Map<String, Object>> queryRunJob();

    void runAJobNow(String jobName, String jobGroupName);


    /**
     * @param jobClass     任务实现类
     * @param jobName      任务名称(建议唯一)
     * @param jobGroupName 任务组名
     * @param jobTime      时间表达式 （如：0/5 * * * * ? ）
     * @param jobData      参数
     */
    void addJob(Class<? extends QuartzJobBean> jobClass, String jobName, String jobGroupName, String jobTime, Map<String,Object> jobData);

}
