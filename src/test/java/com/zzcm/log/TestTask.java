package com.zzcm.log;

import com.zzcm.log.bean.Task;
import com.zzcm.log.dao.NodeDao;
import com.zzcm.log.dao.TaskDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2015/12/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:spring-root.xml"})
//当然 你可以声明一个事务管理 每个单元测试都进行事务回滚 无论成功与否
@TransactionConfiguration(defaultRollback = false)
//记得要在XML文件中声明事务哦~~~我是采用注解的方式
@Transactional
public class TestTask {
    @Autowired
    private TaskDao dao;
    @Autowired
    private NodeDao nodeDao;

    @Test
    //@Rollback(false)
    public void testAdd() throws Exception{

        Task task = new Task();
        task.setName("first");
        task.setCronTime("");
        task.setEnable(true);
        task.setSync(false);
        dao.saveOrUpdate(task);

    }

    @Test
    //@Rollback(false)
    public void testQuery() throws Exception{

        List<Task> list = dao.getEnableTasks();
        for (Task task : list) {
            System.out.println(task.getFrom().getName());
        }
    }

}
