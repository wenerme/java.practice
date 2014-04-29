package me.wener.practices.crm.sys.department.service;

import com.google.common.base.Strings;
import java.util.List;
import me.wener.practices.crm.sys.department.dao.DepartmentDao;
import me.wener.practices.crm.sys.department.entity.DepartmentEntity;
import me.wener.practices.web.common.dao.Paging;
import me.wener.practices.web.common.service.BaseServiceImpl;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class DepartmentServiceImpl
        extends BaseServiceImpl<DepartmentDao, DepartmentEntity, Long>
        implements DepartmentService
{
    @Inject
    @Override
    public void setDao(DepartmentDao dao)
    {super.setDao(dao);}

    @Override
    public List<DepartmentEntity> getInfoList()
    {
        return dao().getInfoOnly();
    }

    @Override
    public DepartmentEntity editTo(DepartmentEntity model)
    {
        DepartmentEntity entity = id(model.getId());

        if (!Strings.isNullOrEmpty(model.getName()))
            entity.setName(model.getName());
        if (!Strings.isNullOrEmpty(model.getDescription()))
            entity.setDescription(model.getDescription());

        return entity;
    }

    public Paging<DepartmentEntity> search()
    {
        return null;
    }
}
