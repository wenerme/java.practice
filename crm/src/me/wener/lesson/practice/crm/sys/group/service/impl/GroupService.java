package me.wener.lesson.practice.crm.sys.group.service.impl;

import com.google.common.base.Joiner;
import me.wener.lesson.practice.crm.sys.common.dao.Paging;
import me.wener.lesson.practice.crm.sys.group.dao.impl.GroupDao;
import me.wener.lesson.practice.crm.sys.group.entity.Group;
import me.wener.lesson.practice.crm.sys.group.service.inter.IGroupService;

import java.sql.SQLException;
import java.util.List;

public class GroupService implements IGroupService
{

    public static void main(String[] args) throws Exception
    {
        GroupService serv = new GroupService();
        Paging<Group> page = serv.findAll();

        System.out.println(page);
        while (page.hasNext())
        {
            System.out.printf("\nPageNO: %d", page.getCurrentPageNo());
            List<Group> list = page.next();
            System.out.printf(" Items:\n%s", Joiner.on("\n").join(list));
        }

        page = serv.findGroupByDepartment("财务部");
        System.out.println("\n\n" + page);
        while (page.hasNext())
        {
            System.out.printf("\nPageNO: %d", page.getCurrentPageNo());
            List<Group> list = page.next();
            System.out.printf(" Items:\n%s", Joiner.on("\n").join(list));
        }
    }

    @Override
    public Paging<Group> findAll() throws Exception
    {
        try
        {
            return new GroupDao().selectPage();
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void delete(int id)
    {

    }

    @Override
    public Group add(Group group) throws Exception
    {
        try
        {
            new GroupDao().insert(group);
            return group;
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Paging<Group> findGroupByDepartment(String department)
            throws Exception
    {
        return new GroupDao().findGroupByDepartment(department);
    }

}
