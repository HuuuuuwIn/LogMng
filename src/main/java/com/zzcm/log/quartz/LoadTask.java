package com.zzcm.log.quartz;

import com.zzcm.log.bean.Task;
import com.zzcm.log.service.TaskService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.List;

/**
 * Created by Administrator on 2015/12/22.
 */
public class LoadTask {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;
    @Autowired
    private TaskService taskService;

    public void init(){
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        List<Task> tasks = taskService.getEnableTasks();
        for (Task task : tasks) {
            TriggerKey triggerKey = TriggerKey.triggerKey("task_"+task.getId(),"group_"+task.getId());
            try {
                CronTrigger cronTrigger = (CronTrigger)scheduler.getTrigger(triggerKey);
                if(null==cronTrigger){
                    JobDetail jobDetail = JobBuilder.newJob(JobFactory.class).withIdentity("task_"+task.getId(),"group_"+task.getId()).build();
                    jobDetail.getJobDataMap().put("jobParam",task);
                    // 表达式调度构建器
                    CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(task.getCronTime());
                    // 按新的表达式构建一个新的trigger
                    cronTrigger = TriggerBuilder.newTrigger().withIdentity("task_"+task.getId(),"group_"+task.getId()).withSchedule(cronScheduleBuilder).build();
                    scheduler.scheduleJob(jobDetail,cronTrigger);
                }else{
                    // trigger已存在，则更新相应的定时设置
                    CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
                            .cronSchedule(task.getCronTime());
                    // 按新的cronExpression表达式重新构建trigger
                    cronTrigger = cronTrigger.getTriggerBuilder().withIdentity(triggerKey)
                            .withSchedule(scheduleBuilder).build();
                    // 按新的trigger重新设置job执行
                    scheduler.rescheduleJob(triggerKey, cronTrigger);
                }
            }catch (Exception e){

            }


        }
    }
}
