package me.wener.practices.crm.sys.student.counsel.service;


import java.util.List;
import me.wener.practices.crm.sys.clazz.entity.ClassEntity;
import me.wener.practices.crm.sys.student.counsel.entity.CounselInfoEntity;
import me.wener.practices.web.common.service.BaseService;

public interface CounselInfoService extends BaseService<CounselInfoEntity, Long>
{
    CounselInfoEntity editTo(CounselInfoEntity model);
}
