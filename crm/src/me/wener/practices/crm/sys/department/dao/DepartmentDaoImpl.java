package me.wener.practices.crm.sys.department.dao;


import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import me.wener.practices.crm.sys.department.entity.DepartmentEntity;
import me.wener.practices.web.common.dao.BaseDaoImpl;

import javax.inject.Named;

@Named
public class DepartmentDaoImpl extends BaseDaoImpl<DepartmentEntity, Long> implements DepartmentDao
{
    @Override
    public List<DepartmentEntity> getInfoOnly()
    {
        CriteriaQuery<DepartmentEntity> cq = em().getCriteriaBuilder().createQuery(DepartmentEntity.class);
        Root<DepartmentEntity> root = cq.from(DepartmentEntity.class);
        cq.multiselect(root.get("id"), root.get("name"),root.get("description"));
        TypedQuery<DepartmentEntity> query = em().createQuery(cq);

        return query.getResultList();
    }
}
