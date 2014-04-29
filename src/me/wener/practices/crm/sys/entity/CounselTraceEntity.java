package me.wener.practices.crm.sys.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Version;
import lombok.Data;
import lombok.experimental.Accessors;

/* 咨询学生跟踪
日期：		交流方式：		营销人员：
咨询时长：		QQ：		学员：
交流结果：
内容：	 	 	 */

@Accessors(chain = true)
@Data
@Entity
public class CounselTraceEntity
{
    @Id
    @GeneratedValue
    private Long id;
    private Date date;
    /** 时长 暂时用 String 表示. 格式为 HH:mm */
    private String duration;
    private String studentQQ;
    /** 学生名 */
    private String studentName;
    /** 营销人员 */
    private String salesmanName;
    /** 结果 */
    private String conclusion;

    @Lob
    private String content;

    @Version
    private Integer version;
}
