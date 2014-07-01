package mybatis;

import java.util.List;
import javax.inject.Inject;
import me.wener.learn.jk.domain.Factory;
import me.wener.learn.jk.mapper.FactoryMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:mybatis-beans.xml")
@Transactional
public class SpringMyBatis
{

    @Inject
    private SqlSessionFactory factory;
    @Inject
    private ApplicationContext context;

    @Inject
    FactoryMapper factoryMapper;

    @Test
    public void count()
    {
        System.out.println("count " + factoryMapper.count());
    }

    @Test
    public void findAll()
    {
        try (SqlSession sqlSession = factory.openSession())
        {
            FactoryMapper studentMapper = sqlSession.getMapper(FactoryMapper.class);
            List<Factory> list = studentMapper.findAll();
            for (Factory item : list)
            {
                System.out.println(item);
            }
        }
    }

}
