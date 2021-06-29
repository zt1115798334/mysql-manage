package com.example.mysqlmanage.quartz.quartz;

import com.example.mysqlmanage.quartz.domain.ScheduleJob;
import com.example.mysqlmanage.quartz.utils.MethodUtil;
import com.example.mysqlmanage.quartz.utils.SpringContextUtil;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2021/6/25
 * description:
 */
@DisallowConcurrentExecution
public class QuartzFactory implements Job
{
    @Override
    public void execute(JobExecutionContext jobExecutionContext)
    {
        //获取调度数据
        ScheduleJob scheduleJob =
            (ScheduleJob)jobExecutionContext.getMergedJobDataMap()
                .get("scheduleJob");

        try
        {
            //获取对应的Bean
            Object object =
                SpringContextUtil.getBean(scheduleJob.getBeanName());

            String[] parameters  = null;
            if(null == scheduleJob.getParameter() || "".equals(scheduleJob.getParameter()))
            {
                parameters = new String[]{};
            }
            else
            {
                parameters = scheduleJob.getParameter().split(",");
            }
            // 使用反射的方式执行定时任务
            MethodUtil.invokeMethod(object,
                object.getClass(),
                scheduleJob.getMethodName(),
                parameters);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
