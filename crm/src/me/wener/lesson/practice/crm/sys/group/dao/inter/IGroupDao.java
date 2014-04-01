package me.wener.lesson.practice.crm.sys.group.dao.inter;

import me.wener.lesson.practice.crm.sys.common.dao.IBaseDao;
import me.wener.lesson.practice.crm.sys.common.dao.Paging;
import me.wener.lesson.practice.crm.sys.group.GroupSearchCondition;
import me.wener.lesson.practice.crm.sys.group.entity.Group;

public interface IGroupDao extends IBaseDao<Group>
{
    public Paging<Group> search(GroupSearchCondition condition) throws Exception;
}
