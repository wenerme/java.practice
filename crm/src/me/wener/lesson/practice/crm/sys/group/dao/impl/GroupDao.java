package me.wener.lesson.practice.crm.sys.group.dao.impl;

import com.j256.ormlite.stmt.QueryBuilder;
import me.wener.lesson.practice.crm.sys.common.dao.BaseDao;
import me.wener.lesson.practice.crm.sys.common.dao.Paging;
import me.wener.lesson.practice.crm.sys.group.dao.inter.IGroupDao;
import me.wener.lesson.practice.crm.sys.group.entity.Group;


public class GroupDao extends BaseDao<Group> implements IGroupDao
{

    public Paging<Group> findGroupByDepartment(String department) throws Exception
    {
        QueryBuilder<Group, Integer> qb = getDao().queryBuilder();
        qb.where().like("department", department);
        return new Paging<>(getDao(), qb);
    }

}
