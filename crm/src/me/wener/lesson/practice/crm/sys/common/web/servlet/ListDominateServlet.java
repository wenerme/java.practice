package me.wener.lesson.practice.crm.sys.common.web.servlet;

import me.wener.lesson.practice.crm.sys.common.dao.Paging;
import me.wener.lesson.practice.crm.sys.common.web.IGeneralService;
import me.wener.lesson.practice.crm.sys.common.web.RequestMethod;
import me.wener.lesson.practice.crm.sys.common.web.ServletAction;
import me.wener.lesson.practice.crm.sys.common.web.Sessions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public abstract class ListDominateServlet<T> extends ComplexServlet
{
    @ServletAction(asDefault = true, method = {RequestMethod.GET}, errorMessage = "获取列表失败,请返回重试")
    public void list(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        showList(request, response);
    }

    protected Paging<T> getPage(HttpServletRequest request) throws Exception
    {
        Object o = request.getSession().getAttribute("page");
        Paging<T> page = null;
        if (o instanceof Paging && ((Paging) o).getType().equals(getType()))
        {
            page = (Paging<T>) o;
        } else
        {
            page = getService().findAll();
        }

        return page;
    }

    protected void showList(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        showList(getPage(request), request, response);
    }

    protected void showList(Paging<T> page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException
    {
        String pageNoStr = request.getParameter("pageNo");
        long pageNo = 1;
        if (pageNoStr != null)
        {
            switch (pageNoStr)
            {
                case "last":
                    pageNo = page.getPageCount();
                    break;
                case "first":
                    pageNo = 1;
                    break;
                default:
                    pageNo = Long.parseLong(pageNoStr);
                    break;
            }
            // 校正页号
            pageNo = pageNo < 1 ? 1 : pageNo;
            pageNo = pageNo > page.getPageCount() ? page.getPageCount() : pageNo;

            page.setCurrentPageNo(pageNo);
        }

        List<T> list = page.getItems();

        Sessions.WithSession session = Sessions.on(request);

        session.set("page", page);

        request.getRequestDispatcher(getListUrl()).forward(request, response);

    }

    /**
     * 需要继续传递的 session 属性
     */
    protected String[] chainSession()
    {
        return new String[]{"page"};
    }



    /**
     * 需要继续传递的 请求属性
     */
    protected String[] chainAttribute()
    {
        return new String[]{};
    }




    public abstract IGeneralService<T> getService();

    public abstract Class<T> getType();

    public abstract String getListUrl();
}
