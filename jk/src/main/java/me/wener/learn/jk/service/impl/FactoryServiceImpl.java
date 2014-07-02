package me.wener.learn.jk.service.impl;

import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Named;
import me.wener.learn.jk.domain.Factory;
import me.wener.learn.jk.mapper.FactoryMapper;
import me.wener.learn.jk.service.FactoryService;
import org.springframework.transaction.annotation.Transactional;

@Named
public class FactoryServiceImpl
        extends BasicServiceImpl<Factory, String, FactoryMapper>
        implements FactoryService
{
    @Override
    @Transactional
    public int changeState(List<String> ids, String state)
    {
        return mapper().updateState(ids, state);
    }

    @Override
    @Transactional
    public int changeState(String id, String state)
    {
        return changeState(Lists.newArrayList(id), state);
    }
}
