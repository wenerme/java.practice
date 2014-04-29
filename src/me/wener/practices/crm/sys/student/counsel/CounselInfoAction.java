package me.wener.practices.crm.sys.student.counsel;

import javax.inject.Inject;
import me.wener.practices.crm.sys.clazz.service.ClassService;
import me.wener.practices.crm.sys.student.counsel.entity.CounselInfoEntity;
import me.wener.practices.crm.sys.student.counsel.service.CounselInfoService;
import me.wener.practices.web.common.action.ListDominateAction;


public class CounselInfoAction extends ListDominateAction<CounselInfoService, CounselInfoEntity>
{
    @Inject
    private ClassService classService;
    @Inject
    @Override
    public void setService(CounselInfoService service)
    {
        super.setService(service);
    }

    @Inject
    @Override
    public void setModel(CounselInfoEntity model)
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
    public String add() throws Exception
    {
        valueStack("classList",classService.all());
        return super.add();
    }

    @Override
    public String edit() throws Exception
    {
        valueStack("classList",classService.all());
        return super.edit();
    }
}
