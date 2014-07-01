package me.wener.practices.crm.sys.lesson.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Accessors(chain = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LessonEntity
{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double cost;
    private String description;
    private String period;
    @Version
    private Integer version;
}
