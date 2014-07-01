package mybatis;

import java.util.List;
import me.wener.learn.jk.domain.Factory;
import me.wener.learn.jk.mapper.FactoryMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class SimpleMyBaties
{

    private SqlSessionFactory factory;

    @Before
    public void before()
    {
        factory = new SqlSessionFactoryBuilder()
                .build(this.getClass().getClassLoader().getResourceAsStream("mybatis-config-local.xml"));
    }

    @Test
    public void count()
    {
        try (SqlSession sqlSession = factory.openSession())
        {
            FactoryMapper mapper = sqlSession.getMapper(FactoryMapper.class);
            System.out.println("count " + mapper.count());
        }
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
