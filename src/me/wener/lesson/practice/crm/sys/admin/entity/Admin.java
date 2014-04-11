package me.wener.lesson.practice.crm.sys.admin.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@ToString
@Entity(name = "admins")
@DatabaseTable(tableName = "admins")
public class Admin implements Serializable
{
    @Getter
    @Setter
    @Column
    @DatabaseField
    private String username;
    @Getter
    @Setter
    @Column
    @DatabaseField
    private String password;
    @Getter
    @Setter
    @Id
    @GeneratedValue
    @DatabaseField(generatedId = true)
    private int id;

}
