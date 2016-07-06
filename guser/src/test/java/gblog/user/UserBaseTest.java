package gblog.user;

import dao.inter.UserBase;

import javax.inject.Inject;

import domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jetluo on 16/7/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring-test.xml")
public class UserBaseTest{

    @Inject
    private UserBase userBase;

//    @Test
//    public void createTest(){
//        User user = userBase.create("zhangsan");
//        System.out.println(user);
//    }

    @Test
    public void test(){
        User user = userBase.findById(2);
        System.out.println(user);
        System.out.println("==================");
        user = userBase.findByName("zhangsan");
        System.out.println(user);

    }


}
