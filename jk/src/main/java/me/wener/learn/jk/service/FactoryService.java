package me.wener.learn.jk.service;

import java.util.List;
import me.wener.learn.jk.domain.Factory;

public interface FactoryService extends BasicService<Factory, String>
{
    int changeState(List<String> ids, String state);
    int changeState(String id, String state);
}
