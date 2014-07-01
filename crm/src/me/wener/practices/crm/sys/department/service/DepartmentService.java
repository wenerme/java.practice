package me.wener.practices.crm.sys.department.service;


import java.util.List;
import me.wener.practices.crm.sys.department.entity.DepartmentEntity;
import me.wener.practices.web.common.dao.Paging;
import me.wener.practices.web.common.service.BaseService;

public interface DepartmentService extends BaseService<DepartmentEntity, Long>
{
    List<DepartmentEntity> getInfoList();

    DepartmentEntity editTo(DepartmentEntity model);
}
