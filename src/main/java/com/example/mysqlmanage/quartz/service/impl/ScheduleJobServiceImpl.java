package com.example.mysqlmanage.quartz.service.impl;

import com.example.mysqlmanage.quartz.domain.ScheduleJob;
import com.example.mysqlmanage.quartz.job.RunShellJob;
import com.example.mysqlmanage.quartz.properties.MySqlBackupsProperties;
import com.example.mysqlmanage.quartz.service.QuartzService;
import com.example.mysqlmanage.quartz.service.ScheduleJobService;
import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2021/6/25
 * description:
 */
@AllArgsConstructor
@Service
public class ScheduleJobServiceImpl implements ScheduleJobService {

    private final QuartzService quartzService;

    private final MySqlBackupsProperties mySqlBackupsProperties;
    @Override
    public void initTask()
    {
//        //查询数据库是否存在需要定时的任务,此处模拟改为手动添加
//        List<ScheduleJob> scheduleJobs = new ArrayList<>();
//        for(int i =1;i<=3;i++)
//        {
//            ScheduleJob job = new ScheduleJob();
//            job.setId(1);
//            job.setBeanName("test");
//            job.setMethodName("test");
//            job.setCexp("0/1 * * * * ?");
//
//            //job.setParameter("测试定时任务"+i);
//            job.setParameter("");
//            job.setStatus(1);
//            job.setJobName("测试"+i);
//            job.setSchedulerNum(1);
//            scheduleJobs.add(job);
//        }
//        quartzService.initTask(scheduleJobs);

        Map<String,Object> params = Maps.newHashMap();
        params.put("mysqlHost",mySqlBackupsProperties.getMysqlHost());
        params.put("mysqlUsername",mySqlBackupsProperties.getMysqlUsername());
        params.put("mysqlPassword",mySqlBackupsProperties.getMysqlPassword());
        // 测试第二种添加job方式
        quartzService.addJob(RunShellJob.class,"备份数据库",null,mySqlBackupsProperties.getBackupsTime(),params);

    }

    @Override
    public void add(ScheduleJob job)
    {

        //此处省去数据验证
        //持久化定时任务
        //save(job);

        //加入job
        try
        {
            quartzService.addJob(job);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void start(int id)
    {
        //此处省去数据验证
        // 根据id查找定时任务
        //ScheduleJob job = this.getById(id);
        ScheduleJob job = new ScheduleJob();
        job.setStatus(1);
        //更新状态为执行
        //this.updateById(job);

        //执行job

        quartzService.operateJob("start", job);

    }

    @Override
    public void pause(int id)
    {
        //此处省去数据验证
        ScheduleJob job = new ScheduleJob();
        job.setStatus(2);
        //this.updateById(job);

        quartzService.operateJob("pause", job);

    }

    @Override
    public void delete(int id)
    {
        //此处省去数据验证
        ScheduleJob job = new ScheduleJob();
        //this.removeById(id);

        quartzService.operateJob("del", job);

    }

    @Override
    public void startAllJob()
    {
        //此处省去数据验证
        ScheduleJob job = new ScheduleJob();
        job.setStatus(1);
        //this.update(job, new QueryWrapper<>());

        quartzService.startAllJob();

    }

    @Override
    public void pauseAllJob()
    {
        //此处省去数据验证
        ScheduleJob job = new ScheduleJob();
        job.setStatus(2);
        //this.update(job, new QueryWrapper<>());

        quartzService.pauseAllJob();

    }
}
