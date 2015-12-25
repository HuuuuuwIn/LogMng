package com.zzcm.log;

import com.zzcm.log.service.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by Administrator on 2015/12/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:spring-root.xml"})
//当然 你可以声明一个事务管理 每个单元测试都进行事务回滚 无论成功与否
//@TransactionConfiguration(defaultRollback = false)
//记得要在XML文件中声明事务哦~~~我是采用注解的方式
//@Transactional
public class TestTaskService {
    @Autowired
    private TaskService service;

    @Test
    //@Rollback(false)
    public void testRunOnce() throws Exception{

        //service.runOnce(1);
    }

    @Test
    //@Rollback(false)
    public void testRun() throws Exception{

        //service.run(1);
    }
}
