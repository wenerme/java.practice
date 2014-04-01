package me.wener.lesson.practice.crm.sys.group.service.inter;

import me.wener.lesson.practice.crm.sys.common.dao.Paging;
import me.wener.lesson.practice.crm.sys.common.dao.IGeneralService;
import me.wener.lesson.practice.crm.sys.group.GroupSearchCondition;
import me.wener.lesson.practice.crm.sys.group.entity.Group;

public interface IGroupService extends IGeneralService<Group, GroupSearchCondition>
{
}
