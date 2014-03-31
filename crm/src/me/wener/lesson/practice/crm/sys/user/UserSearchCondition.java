package me.wener.lesson.practice.crm.sys.user;

import lombok.Data;

@Data
public class UserSearchCondition
{
    private String enname = null;
    private String cnname = null;
    private Boolean enabled = null;
    private String groupId = null;
}
