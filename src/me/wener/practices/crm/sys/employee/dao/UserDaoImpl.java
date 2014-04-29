package me.wener.practices.crm.sys.employee.dao;

import com.google.common.base.Strings;
import com.googlecode.genericdao.search.Search;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import me.wener.practices.crm.sys.department.entity.DepartmentEntity;
import me.wener.practices.crm.sys.employee.UserAction;
import me.wener.practices.crm.sys.employee.entity.UserEntity_;
import me.wener.practices.crm.sys.employee.entity.UserSearcher;
import me.wener.practices.web.common.dao.BaseDaoImpl;
import me.wener.practices.crm.sys.employee.entity.UserEntity;

import java.util.List;
import me.wener.practices.web.common.dao.Paging;


public class UserDaoImpl extends BaseDaoImpl<UserEntity, Long> implements UserDao
{
    @Override
    public List<DepartmentEntity> departments()
    {
        return em().createQuery("SELECT d FROM DepartmentEntity d", DepartmentEntity.class).getResultList();
    }
}
