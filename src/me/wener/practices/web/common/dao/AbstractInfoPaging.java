package me.wener.practices.web.common.dao;


import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
public abstract class AbstractInfoPaging<T> extends AbstractPaging<T>
{
    @Getter
    @Setter
    private int pageSize;

    @Getter
    @Setter
    private int currentPage;


}
