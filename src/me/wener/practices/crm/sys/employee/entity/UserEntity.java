package me.wener.practices.crm.sys.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import me.wener.practices.crm.sys.department.entity.DepartmentEntity;
import me.wener.practices.web.common.entity.Sex;

import javax.persistence.*;
import java.util.Date;


@Accessors(chain = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserEntity
{
    public UserEntity(Long id, String name)
    {
        this.id = id;
        this.name = name;
    }
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 32)
    private String number;
    @Column(length = 32)
    private String account;

    private String password;
    @Column(length = 32)
    private String name;

    private Date birthday;
    /**
     * 入职时间
     */
    private Date joinDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private DepartmentEntity department;

    @Column(columnDefinition = "0")
    private Sex sex;
    @Version
    private Integer version;
}
