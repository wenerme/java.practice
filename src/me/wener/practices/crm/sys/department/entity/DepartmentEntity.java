package me.wener.practices.crm.sys.department.entity;


import java.util.HashSet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import me.wener.practices.crm.sys.employee.entity.UserEntity;

import javax.persistence.*;
import java.util.Set;

@Accessors(chain = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DepartmentEntity
{
    public DepartmentEntity(Long id, String name, String description)
    {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @OneToMany

    private Set<UserEntity> employees = new HashSet<>();
    @Version
    private Integer version;
}
