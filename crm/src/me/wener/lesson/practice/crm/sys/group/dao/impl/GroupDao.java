package me.wener.lesson.practice.crm.sys.group.dao.impl;

import com.google.common.base.Strings;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import me.wener.lesson.practice.crm.sys.common.dao.BaseDao;
import me.wener.lesson.practice.crm.sys.common.dao.Paging;
import me.wener.lesson.practice.crm.sys.group.GroupSearchCondition;
import me.wener.lesson.practice.crm.sys.group.dao.inter.IGroupDao;
import me.wener.lesson.practice.crm.sys.group.entity.Group;
import me.wener.lesson.practice.crm.sys.user.entity.User;

public class GroupDao extends BaseDao<Group> implements IGroupDao
{

    @Override
    public Paging<Group> search(GroupSearchCondition condition) throws Exception
    {
        // 如果有一个值为非空 才使用 where
        if (condition.getDepartment() != null)
        {
            QueryBuilder<Group, Integer> qb = getDao().queryBuilder();
            Where<Group, Integer> where = qb.where();

            if (!Strings.isNullOrEmpty(condition.getDepartment()))
                where.like(Group.FIELD_DEPARTMENT, like(condition.getDepartment())).and();

            where.raw("1 = 1");// 补足 and

            return new Paging<>(getDao(), qb);
        }

        return selectPage();
    }

    private static String like(String raw)
    {
        return "%" + raw + "%";
    }
}
