package me.wener.lesson.practice.crm.sys.user;

import lombok.Data;
import me.wener.lesson.practice.crm.sys.common.dao.ISearchCondition;

@Data
public class UserSearchCondition implements ISearchCondition
{
    private String enname = null;
    private String cnname = null;
    private Boolean enabled = null;
    private String groupId = null;
}
