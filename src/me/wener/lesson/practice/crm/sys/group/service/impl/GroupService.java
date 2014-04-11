package me.wener.lesson.practice.crm.sys.group.service.impl;

import com.google.common.base.Joiner;
import me.wener.lesson.practice.crm.sys.common.dao.GeneralService;
import me.wener.lesson.practice.crm.sys.common.dao.Paging;
import me.wener.lesson.practice.crm.sys.group.GroupSearchCondition;
import me.wener.lesson.practice.crm.sys.group.dao.impl.GroupDao;
import me.wener.lesson.practice.crm.sys.group.dao.inter.IGroupDao;
import me.wener.lesson.practice.crm.sys.group.entity.Group;
import me.wener.lesson.practice.crm.sys.group.service.inter.IGroupService;

import java.util.List;

public class GroupService extends GeneralService<Group, GroupSearchCondition> implements IGroupService
{
    @Override
    protected IGroupDao getDao()
    {
        return new GroupDao();
    }

    @Override
    public Paging<Group> search(GroupSearchCondition condition) throws Exception
    {
        return new GroupDao().search(condition);
    }

}
