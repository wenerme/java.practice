package me.wener.practices.web.common.dao.jpa;


import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

public class CriteriaUtils
{
    private CriteriaUtils()
    {
    }

    /**
     * 拷贝和查询相关的限制<br/>
     * 不会拷贝 Join
     * @return 返回拷贝到的目标对象
     */
    public static <T> CriteriaQuery<T> copyRestriction(CriteriaQuery<?> from, CriteriaQuery<T> to)
    {
        Predicate predicate;

        to.groupBy(from.getGroupList());
        to.distinct(from.isDistinct());

        predicate = from.getGroupRestriction();
        if (predicate != null)
            to.having(from.getGroupRestriction());

        predicate = from.getRestriction();
        if (predicate != null)
            to.where(predicate);

        return to;
    }

    private static boolean isEclipseLink(CriteriaQuery<?> from)
    {
        return from.getClass().getName().contains("org.eclipse.persistence");
    }
}
