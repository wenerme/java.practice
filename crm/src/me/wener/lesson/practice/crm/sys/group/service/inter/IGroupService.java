package me.wener.lesson.practice.crm.sys.group.service.inter;

import me.wener.lesson.practice.crm.sys.common.Paging;
import me.wener.lesson.practice.crm.sys.common.web.IGeneralService;
import me.wener.lesson.practice.crm.sys.group.entity.Group;

public interface IGroupService extends IGeneralService<Group>
{
    public Paging<Group> findAll() throws Exception;

    public Paging<Group> findGroupByDepartment(String department) throws Exception;

    public Group add(Group group) throws Exception;

    public void deleteById(int id) throws Exception;
}
