package com.example.mysqlmanage.quartz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2021/6/25
 * description:
 */
@Slf4j
public class RunShellJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // 获取参数
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        log.info("mysqlHost:{}, mysqlUsername:{}, mysqlPassword:{}",
                jobDataMap.getString("mysqlHost"), jobDataMap.getString("mysqlUsername"), jobDataMap.getString("mysqlPassword"));
    }
}
