package me.wener.practices.crm.sys.employee;

import me.wener.practices.crm.sys.employee.dao.UserDao;
import me.wener.practices.web.common.dao.Paging;
import me.wener.practices.web.common.entity.Sex;
import me.wener.practices.crm.sys.employee.entity.UserEntity;
import me.wener.practices.crm.sys.employee.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ContextConfiguration("classpath:beans.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTester
{
    @Inject
    ApplicationContext ctx;
    @Inject
    UserService svc;
    @Inject
    UserDao dao;

    @Test
    public void testSex()
    {
        UserEntity user = new UserEntity();
        user.setName("文儿")
                .setAccount("wener")
                .setPassword("123")
                .setSex(Sex.Male)
                ;
        dao.save(user);
        List<UserEntity> list = svc.all();
       assert list.get(0).getSex().equals(Sex.Male);
    }
    @Test
    public void testUserPaging()
    {
        generateUser(50);
        Paging<UserEntity> page = dao.page();
        System.out.printf("current %s pages %s, results %s \n",
                page.getCurrentPage(), page.getPageCount(),page.getItemCount());
    }

    public void generateUser(int n)
    {
        List<UserEntity> users = new ArrayList<UserEntity>();
        for (int i = 0; i < n; i ++)
        {
            UserEntity user = new UserEntity();
            user.setName("文儿_"+i)
                    .setAccount("wener_"+i)
                    .setPassword("123_"+i)
                    .setSex(i % 2 == 0 ? Sex.Male: Sex.Female)
            ;
            users.add(user);
        }
        dao.save(users.toArray(new UserEntity[0]));
    }
}
