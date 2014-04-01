package me.wener.lesson.practice.crm.sys.group;

import lombok.Data;
import me.wener.lesson.practice.crm.sys.common.dao.ISearchCondition;


@Data
public class GroupSearchCondition implements ISearchCondition
{
    private String department;
}
