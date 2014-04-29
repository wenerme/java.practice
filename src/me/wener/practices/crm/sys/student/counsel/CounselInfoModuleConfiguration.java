package me.wener.practices.crm.sys.student.counsel;

import me.wener.practices.crm.sys.student.counsel.dao.CounselInfoDao;
import me.wener.practices.crm.sys.student.counsel.dao.CounselInfoDaoImpl;
import me.wener.practices.crm.sys.student.counsel.entity.CounselInfoEntity;
import me.wener.practices.crm.sys.student.counsel.service.CounselInfoService;
import me.wener.practices.crm.sys.student.counsel.service.CounselInfoServiceImpl;
import me.wener.practices.web.common.annotation.NonSingleton;
import me.wener.practices.web.common.util.AbstractModuleConfiguration;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class CounselInfoModuleConfiguration extends AbstractModuleConfiguration
{
    @Bean
    @NonSingleton
    public CounselInfoEntity counselInfoEntity()
    {
        return newEntity(CounselInfoEntity.class);
    }

    @Bean
    public CounselInfoService counselInfoService()
    {
        return newInstance(CounselInfoServiceImpl.class);
    }

    @Bean
    public CounselInfoDao counselInfoDao()
    {
        return newInstance(CounselInfoDaoImpl.class);
    }
}
