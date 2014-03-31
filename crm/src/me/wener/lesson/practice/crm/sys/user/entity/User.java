package me.wener.lesson.practice.crm.sys.user.entity;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;
import me.wener.lesson.practice.crm.sys.group.entity.Group;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;


@Data
// @Accessors(chain = true) 使用该值后 BeanUtils 不能设置值
@DatabaseTable(tableName = User.TABLE_NAME)
public class User implements Serializable
{
    public final static String TABLE_NAME = "users";

    public final static String FIELD_ENNAME = "enname";
    public final static String FIELD_CNNAME = "cnname";
    public final static String FIELD_PASSWORD = "password";
    public final static String FIELD_EMAIL = "email";
    public final static String FIELD_BEGIN_DATE = "beginDate";
    public final static String FIELD_END_DATE = "endDate";
    public final static String FIELD_ENABLED = "enabled";
    public final static String FIELD_GROUP = "groupId";
    @Column
    @DatabaseField(columnName = FIELD_CNNAME, canBeNull = false)
    String cnname;
    @Id
    @GeneratedValue
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = FIELD_ENNAME, canBeNull = false)
    private String enname;
    @Column
    @DatabaseField(columnName = FIELD_PASSWORD, canBeNull = false)
    private String password;
    @Column
    @DatabaseField(columnName = FIELD_EMAIL, canBeNull = false)
    private String email;
    @DatabaseField(columnName = FIELD_BEGIN_DATE, canBeNull = false, dataType = DataType.DATE_LONG)
    private Date beginDate;
    @Column
    @DatabaseField(columnName = FIELD_END_DATE, canBeNull = false, dataType = DataType.DATE_LONG)
    private Date endDate;
    @DatabaseField(columnName = FIELD_ENABLED, canBeNull = false)
    private boolean enabled;
    @DatabaseField(columnName = FIELD_GROUP, foreign = true, foreignAutoRefresh = true)
    private Group group = new Group();
    /*
    id int(5) primary key auto_increment,
	enname varchar(20) not null,  
	cnname varchar(20) not null, 
	password varchar(32) not null,
	email varchar(30) not null, 
	beginDate date not null,
	endDate date not null,
	state varchar(1) not null,
	groups_id int(5),
	constraint groups_id_FK foreign key(groups_id) references groups(id)
	 */
}
