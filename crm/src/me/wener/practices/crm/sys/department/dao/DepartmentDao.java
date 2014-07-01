package me.wener.practices.crm.sys.department.dao;


import java.util.List;
import me.wener.practices.crm.sys.department.entity.DepartmentEntity;
import me.wener.practices.web.common.dao.BaseDao;
import me.wener.practices.web.common.dao.Paging;

public interface DepartmentDao extends BaseDao<DepartmentEntity, Long>
{
    List<DepartmentEntity> getInfoOnly();
}
