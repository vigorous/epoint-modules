package spring.test;

import com.epoint.reception.service.IReceptionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import spring.config.AppConfig;

import javax.annotation.Resource;

/**
 * @author xishengchun on 2017-03-31.
 * 测试基类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@Transactional
public abstract class BeanTest {

    protected Logger logger = LogManager.getLogger(BeanTest.class);

    @Before
    public void setup() {

    }


}
