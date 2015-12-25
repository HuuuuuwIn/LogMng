package com.zzcm.log.quartz;

/**
 * Created by Administrator on 2015/12/23.
 */
public class MyJob {
    public void work(){
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        SFTPUtil.download("192.168.0.180","root","zzcm2014","/opt","cid.jar","D:/test/aaaa.jar");
        System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBB");
    }
}
