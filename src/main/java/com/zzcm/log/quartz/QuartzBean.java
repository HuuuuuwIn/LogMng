package com.zzcm.log.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2015/12/23.
 */
@Service
@Lazy(false)
public class QuartzBean {
    /* 日志对象 */
    private static final Logger LOG = LoggerFactory.getLogger(QuartzBean.class);

    //@PostConstruct
    public void init() {
        LOG.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        //System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa");
        //SFTPUtil.download("192.168.0.180","root","zzcm2014","/opt","cid.jar","D:/test/aaaa.jar");
        //System.out.println("2aaaaaaaaaaaaaaaaaaaaaaaaaa2");
    }
}
