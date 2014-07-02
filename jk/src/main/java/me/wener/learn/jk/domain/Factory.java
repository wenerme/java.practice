package me.wener.learn.jk.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Factory
{
    public static final String STATE_ENABLE = "1";
    public static final String STATE_DISABLE = "0";
    private String id;
    private String fullName;
    private String factoryName;
    private String contacts;
    private String phone;
    private String mobile;
    private String fax;
    private String note;
    private String inspector;
    private Integer orderNo;
    private String state;

    private String createBy;
    private String createDept;
    private java.util.Date createTime;

}
