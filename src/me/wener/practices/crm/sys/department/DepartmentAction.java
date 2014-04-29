package me.wener.practices.crm.sys.department;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import me.wener.practices.crm.sys.department.entity.DepartmentEntity;
import me.wener.practices.crm.sys.department.service.DepartmentService;
import me.wener.practices.web.common.action.ListDominateAction;
import me.wener.practices.web.common.dao.Paging;

import javax.inject.Inject;


public class DepartmentAction extends ListDominateAction<DepartmentService, DepartmentEntity>
{
    @Inject
    @Override
    public void setService(DepartmentService service)
    {
        super.setService(service);
    }

    @Inject
    @Override
    public void setModel(DepartmentEntity model)
    {
        super.setModel(model);
    }
    @Override
    protected String handleEdit()
    {
        service().editTo(model());
        return null;
    }

    @Override
    protected Paging<DepartmentEntity> getListPage()
    {
        Paging<DepartmentEntity> page = service().page();
        return page;
    }
}
