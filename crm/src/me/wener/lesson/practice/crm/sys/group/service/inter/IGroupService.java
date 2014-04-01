package me.wener.lesson.practice.crm.sys.group.service.inter;

import me.wener.lesson.practice.crm.sys.common.dao.Paging;
import me.wener.lesson.practice.crm.sys.common.dao.IGeneralService;
import me.wener.lesson.practice.crm.sys.group.GroupSearchCondition;
import me.wener.lesson.practice.crm.sys.group.entity.Group;

public interface IGroupService extends IGeneralService<Group, GroupSearchCondition>
{
    public Paging<Group> findAll() throws Exception;

    public Paging<Group> findGroupByDepartment(String department) throws Exception;

    public Group add(Group group) throws Exception;

    public void delete(int id) throws Exception;
}
