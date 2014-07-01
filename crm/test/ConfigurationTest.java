import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.QueryHint;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import me.wener.practices.crm.sys.department.entity.DepartmentEntity;
import me.wener.practices.crm.sys.department.service.DepartmentService;
import me.wener.practices.crm.sys.employee.dao.UserDao;
import me.wener.practices.crm.sys.employee.dao.UserDaoImpl;
import me.wener.practices.crm.sys.employee.entity.UserEntity;
import me.wener.practices.crm.sys.employee.entity.UserEntity_;
import me.wener.practices.crm.sys.employee.service.UserService;
import me.wener.practices.crm.sys.lesson.dao.LessonDaoImpl;
import me.wener.practices.crm.sys.lesson.entity.LessonEntity;
import me.wener.practices.crm.sys.lesson.entity.LessonEntity_;
import me.wener.practices.crm.sys.lesson.entity.LessonSearcher;
import me.wener.practices.web.common.dao.CriteriaQueryHelper;
import me.wener.practices.web.common.dao.LogicMode;
import me.wener.practices.web.common.dao.Paging;
import me.wener.practices.web.common.dao.WildcardWrapMode;
import me.wener.practices.web.common.util.BeanHelper;
import org.hibernate.jpa.QueryHints;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class ConfigurationTest
{
    @Inject
    ApplicationContext ctx;

    @Test
    public void test1()
    {
        System.out.println(ctx.getBean(UserDao.class));
        System.out.println(ctx.getBean(UserEntity.class));
        System.out.println(ctx.getBean(DepartmentEntity.class));

        assert ctx.getBean(UserService.class) == ctx.getBean(UserService.class);
        assert ctx.getBean(DepartmentService.class) == ctx.getBean(DepartmentService.class);

        assert ctx.getBean(UserEntity.class) != ctx.getBean(UserEntity.class);
        assert ctx.getBean(DepartmentEntity.class) != ctx.getBean(DepartmentEntity.class);
    }

    @Test
    public void testSelect()
    {
        TestDao testDao = autowire(TestDao.class);
        testDao.testA();
    }

    @SuppressWarnings("unchecked")
    protected <T> T autowire(Class<T> clazz)
    {
        return (T) ctx.getAutowireCapableBeanFactory()
                .autowire(clazz, AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, true);
    }

    @Test
    public void testCount()
    {
        autowire(TestLessonDao.class).testQueryCount();
    }

    @Test
    public void testPaging()
    {
        autowire(TestLessonDao.class).testPaging();
    }

    @Test
    public void testSearch()
    {
        autowire(TestLessonDao.class).testSearch();
    }

    @Test
    public void testBeanHelper()
    {
        LessonEntity entity = new LessonEntity();
        LessonEntity model = new LessonEntity();
        model.setName("wener");

        BeanHelper.merge(entity, model, LessonEntity_.name);
        assert entity.getName().equals("wener");
        System.out.println(BeanHelper.tryGetProperty(entity, LessonEntity_.name));
    }
}

class TestDao extends UserDaoImpl
{
    public void testA()
    {
        CriteriaBuilder builder = em().getCriteriaBuilder();
        CriteriaQuery<UserEntity> query = builder.createQuery(UserEntity.class);
        Root<UserEntity> root = query.from(UserEntity.class);

//        query.multiselect(root.get(UserEntity_.id),root.get(UserEntity_.name));
        System.out.println(UserEntity_.account.getName());
        query.multiselect(root.get(UserEntity_.id), root.get(UserEntity_.name));

        System.out.println(em().createQuery(query).getResultList());
    }


}

@Transactional
@PersistenceContext
class TestLessonDao extends LessonDaoImpl
{

    public void testSearch()
    {
        LessonSearcher searcher = new LessonSearcher();
        searcher.setName("Java");
        searcher.setDescription("IOS");

        CriteriaQueryHelper<LessonEntity> helper = getQueryHelper();

        CriteriaQuery<LessonEntity> query = helper.getQuery()
                .where(helper.like(searcher, LogicMode.OR, WildcardWrapMode.Both, BeanHelper.skipNullOrEmpty(searcher, LessonEntity_.name, LessonEntity_.description)));

        System.out.println(all(query));
        System.out.println(all(query));
    }

    public void testCount()
    {
        LessonSearcher searcher = new LessonSearcher();
        searcher.setName("Java");
        searcher.setDescription("IOS");

        CriteriaQueryHelper<LessonEntity> helper = getQueryHelper();
        CriteriaBuilder builder = helper.getBuilder();
        CriteriaQuery<Long> cq = builder.createQuery(Long.class);

        cq.select(builder.count(cq
                .from(LessonEntity.class)));

        CriteriaQuery<LessonEntity> query = helper.getQuery()
                .where(helper.like(searcher, LogicMode.OR, WildcardWrapMode.Both, BeanHelper.skipNullOrEmpty(searcher, LessonEntity_.name, LessonEntity_.description)));

        cq.where(query.getRestriction());

        //helper.getBuilder().count(query.where())
        System.out.println(all(query));
        System.out.println("COUNT is :" + em().createQuery(cq).getSingleResult());

    }

    public void testPaging()
    {
        LessonSearcher searcher = new LessonSearcher();
        searcher.setName("Java");
        searcher.setDescription("IOS");
        CriteriaQueryHelper<LessonEntity> helper = getQueryHelper();
        CriteriaQuery<LessonEntity> query = helper.getQuery()
                .where(helper.like(searcher, LogicMode.OR, WildcardWrapMode.Both, BeanHelper.skipNullOrEmpty(searcher, LessonEntity_.name, LessonEntity_.description)));

        Paging<LessonEntity> page = paging(query).setPageSize(2);

        for (LessonEntity item : page.getItems())
        {
            System.out.println(item);
        }

        System.out.printf("itemCount: %s, pageCount: %s \n",
                page.getItemCount(), page.getPageCount());
    }

    public void testQueryCount()
    {
        LessonSearcher searcher = new LessonSearcher();
        searcher.setName("基础");
        searcher.setDescription("框架");
        CriteriaQueryHelper<LessonEntity> helper = getQueryHelper();
        CriteriaQuery<LessonEntity> query = helper.getQuery()
                .where(helper.like(searcher, LogicMode.OR, WildcardWrapMode.Both, BeanHelper.skipNullOrEmpty(searcher, LessonEntity_.name, LessonEntity_.description)));

        Paging<LessonEntity> page = paging(query);
        page.setPageSize(2);

        new Outer().info(page);

    }
}

class GenericInject<DAO, SERVICE>
{


}

class Outer
{
    public static Long count(TypedQuery<Long> query)
    {
        return query.getSingleResult();
    }

    public void info(Paging<?> page)
    {

        for (Object item : page.getItems())
        {
            System.out.println(item);
        }

        System.out.printf("itemCount: %s\n",page.getItemCount());
        for (Object item : page.getItems())
        {
            System.out.println(item);
        }

        System.out.printf("pageCount: %s \n",page.getPageCount());
    }
}