package me.wener.lesson.practice.crm.sys.user;

import com.google.common.base.Strings;
import lombok.Data;
import me.wener.lesson.practice.crm.sys.common.dao.ISearchCondition;

@Data
public class UserSearchCondition implements ISearchCondition
{
    private String enname = null;
    private String cnname = null;
    private String enabled = null;
    private String groupId = null;

    public Boolean isEnabled()
    {
        if (Strings.isNullOrEmpty(enabled) || enabled.toLowerCase().equals("null"))
            return null;
        return Boolean.valueOf(enabled);
    }
}
