package me.wener.practices.crm.sys.employee.service;

import com.google.common.base.Strings;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import lombok.ToString;
import me.wener.practices.crm.sys.department.dao.DepartmentDao;
import me.wener.practices.crm.sys.department.entity.DepartmentEntity;
import me.wener.practices.crm.sys.employee.dao.UserDao;
import me.wener.practices.crm.sys.employee.entity.UserEntity;
import me.wener.practices.web.common.service.BaseServiceImpl;

@ToString
public class UserServiceImpl extends BaseServiceImpl<UserDao, UserEntity, Long> implements UserService
{
    @Inject
    DepartmentDao departmentDao;

    @Inject
    @Override
    public void setDao(UserDao dao)
    {
        super.setDao(dao);
    }

    @Override
    public UserEntity login(String account, String password)
    {
        UserEntity entity = new UserEntity();
        entity.setAccount(account).setPassword(password);

        return dao().exampleUnique(entity);
    }

    @Override
    public boolean isAccountExists(String account)
    {
        UserEntity entity = new UserEntity();
        entity.setAccount(account);
        return dao().exampleCount(entity) > 0;
    }

    @Override
    public UserEntity register(UserEntity user)
    {
        user.setJoinDate(new Date()).setNumber(generateNumber(user));
        dao().save(user);
        return user;
    }

    @Override
    public List<DepartmentEntity> departments()
    {
        return dao().departments();
    }

    @Override
    public UserEntity editTo(UserEntity model)
    {
        UserEntity entity = id(model.getId());

        if (model.getBirthday() != null)
            entity.setBirthday(model.getBirthday());

        if (model.getJoinDate() != null)
            entity.setJoinDate(model.getJoinDate());

        if (model.getSex() != null)
            entity.setSex(model.getSex());

        if (model.getNumber() != null)
            entity.setNumber(model.getNumber());

        if (model.getName() != null)
            entity.setName(model.getName());

        if (model.getDepartment() != null)
        {
            entity.setDepartment(departmentDao.find(model.getDepartment().getId()));
        }


        return entity;
    }

    protected String generateNumber(UserEntity user)
    {
        String number = null;
        number = new SimpleDateFormat("yyyyMMdd").format(user.getJoinDate());
        number += Strings.padStart(String.valueOf((user.getJoinDate().getTime() / 1000) % 999), 3, '0');
        return number;
    }
}
