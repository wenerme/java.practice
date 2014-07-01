package me.wener.practices.web.common.dao;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import me.wener.practices.web.common.dao.jpa.CriteriaUtils;
import me.wener.practices.web.common.util.BeanHelper;
import me.wener.practices.web.common.util.SimpleValueTester;
import me.wener.practices.web.common.util.ValueTester;
import org.hibernate.Criteria;

/**
 * 主要封装了一些和 CriteriaQuery 操作相关的简便方法,且这些操作是类型安全的
 * @param <E> 查询的实体类型
 */
@Slf4j
public class CriteriaQueryHelper<E>
{
    private static final ValueTester DEFAULT_TESTER = new SimpleValueTester();
    private ValueTester tester = DEFAULT_TESTER;

    @Getter
    private CriteriaBuilder builder;
    @Getter
    private CriteriaQuery<E> query;
    @Getter
    private Root<E> root;
    @Getter
    private Class<E> type;

    //region 创建方法
    private CriteriaQueryHelper()
    {
    }

    public static <E> CriteriaQueryHelper<E> create(CriteriaBuilder cb, Class<E> type)
    {
        return create(cb, cb.createQuery(type));
    }

    public static <E> CriteriaQueryHelper<E> create(CriteriaBuilder cb, CriteriaQuery<E> cq)
    {
        return create(cb, cq, cq.from(cq.getResultType()));
    }

    public static <E> CriteriaQueryHelper<E> create(CriteriaBuilder cb, CriteriaQuery<E> cq, Root<E> root)
    {
        CriteriaQueryHelper<E> query = new CriteriaQueryHelper<>();
        query.builder = cb;
        query.query = cq;
        query.root = root;
        query.type = cq.getResultType();
        return query;
    }

    public static String wrapToWildcard(String val, WildcardWrapMode mode)
    {
        switch (mode)
        {
            case Head:
                return "%" + val;
            case Tail:
                return val + "%";
            case Both:
                return "%" + val + "%";
            case None:
            default:
                return val;
        }

    }

    //endregion

    @SafeVarargs
    public final Predicate like(Object searcher, LogicMode mode, SingularAttribute<E, String>... attrs)
    {
        return like(searcher, mode, Lists.newArrayList(attrs));
    }

    public Predicate like(Object searcher, LogicMode mode, List<SingularAttribute<E, String>> attrs)
    {
        return like(searcher, mode, WildcardWrapMode.None, attrs);
    }

    @SafeVarargs
    public final Predicate like(Object searcher, LogicMode logic, WildcardWrapMode wrapMode, SingularAttribute<E, String> ... attrs)
    {
        return like(searcher, logic, wrapMode, Lists.newArrayList(attrs));
    }
    public Predicate like(Object searcher, LogicMode logic, WildcardWrapMode wrapMode, List<SingularAttribute<E, String>> attrs)
    {
        ArrayList<Predicate> predicates = new ArrayList<>();

        for (SingularAttribute<E, String> attr : attrs)
        {
            String val = (String) BeanHelper.tryGetProperty(searcher, attr.getName());
            Predicate predicate = builder.like(root.get(attr), wrapToWildcard(val, wrapMode));
            predicates.add(predicate);
        }

        return combine(logic, predicates);
    }

    public final Predicate eq(Object searcher, LogicMode mode, SingularAttribute<E, ?>... attrs)
    {
        return eq(searcher, mode, Lists.newArrayList(attrs));
    }

    public Predicate eq(Object searcher, LogicMode mode, List<SingularAttribute<E, ?>> attrs)
    {
        ArrayList<Predicate> predicates = new ArrayList<>();

        for (SingularAttribute<E, ?> attr : attrs)
        {
            Object val = BeanHelper.tryGetProperty(searcher, attr.getName());
            Predicate predicate = builder.equal(root.get(attr), val);
            predicates.add(predicate);
        }

        return combine(mode, predicates);
    }

    protected Predicate combine(LogicMode mode, List<Predicate> predicates)
    {
        if (LogicMode.AND == mode)
            return builder.and(asArray(predicates));
        else
            return builder.or(asArray(predicates));
    }

    protected Predicate[] asArray(List<Predicate> predicates)
    {
        return predicates.toArray(new Predicate[0]);
    }

    //region wither
    public <S> WithSearcher<S> with(S searcher)
    {
        return this.new WithSearcher<S>().setSearcher(searcher);
    }

    @Accessors(chain = true)
    public class WithSearcher<S>
    {
        @Getter
        @Setter(AccessLevel.PRIVATE)
        private S searcher;

        public CriteriaQueryHelper<E> end()
        {
            return CriteriaQueryHelper.this;
        }
    }
    //endregion
}
