package me.wener.lesson.practice.crm.sys.group.action;

import me.wener.lesson.practice.crm.sys.common.action.GeneralListAction;
import me.wener.lesson.practice.crm.sys.common.dao.IGeneralService;
import me.wener.lesson.practice.crm.sys.group.entity.Group;
import me.wener.lesson.practice.crm.sys.group.service.impl.GroupService;


public class GroupAction extends GeneralListAction<Group>
{

    @Override
    protected IGeneralService<Group> getService()
    {
        return new GroupService();
    }

}
