package me.wener.learn.jk.mapper;


import java.util.List;
import javax.inject.Named;
import me.wener.learn.jk.domain.Factory;
import org.apache.ibatis.annotations.Param;

@Named
public interface FactoryMapper extends BaseMapper<Factory, String>
{
    int updateState(@Param("list") List<String> ids,@Param("state") String state);
}
