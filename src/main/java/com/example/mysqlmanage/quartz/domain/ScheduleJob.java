package com.example.mysqlmanage.quartz.domain;


import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2021/6/25
 * description:
 */
@Getter
@Setter
public class ScheduleJob {
    /**
     * id
     */
    private Integer id;

    /**
     * 任务名称
     */
    private String jobName;

    /**
     * 任务描述
     */
    private String jobDesc;

    /**
     * 服务名称
     */
    private String beanName;

    /**
     * 方法名称
     */
    private String methodName;

    /**
     * 方法参数
     */
    private String parameter;

    /**
     * cron表达式
     */
    private String cexp;

    /**
     * 状态
     */
    private int status;

    /**
     * 定是任务启动个数
     */
    private int schedulerNum;
}
