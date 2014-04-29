package me.wener.practices.web.common.action;


import me.wener.practices.web.common.entity.ISearcher;
import me.wener.practices.web.common.service.BaseService;

public abstract class SearchableListDominateAction<SVC extends BaseService<T, Long>, T> extends ListDominateAction<SVC, T>
{
    public abstract ISearcher<T> getSearcher();

    //region 搜索功能的实现
    public String search() throws Exception
    {
        String result = TO_LIST;
        if (isPost())
        {
            result = handlerSearch();
            result = result != null? result: SEARCH;
        }
        return result;
    }

    protected abstract String handlerSearch();
    //endregion
}
