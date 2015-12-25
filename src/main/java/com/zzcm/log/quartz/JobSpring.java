package com.zzcm.log.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created by Administrator on 2015/12/23.
 */
public class JobSpring extends QuartzJobBean{
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        //SFTPUtil.download("192.168.0.180","root","zzcm2014","/opt","cid.jar","D:/test/aaaa.jar");
        System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBB");
    }
}
