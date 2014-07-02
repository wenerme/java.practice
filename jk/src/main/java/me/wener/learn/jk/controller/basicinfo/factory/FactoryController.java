package me.wener.learn.jk.controller.basicinfo.factory;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import me.wener.learn.jk.domain.Factory;
import me.wener.learn.jk.service.FactoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/basicinfo/factory")
public class FactoryController
{
    public static final String LIST = "redirect:/basicinfo/factory/list";
    @Inject
    FactoryService service;

    @RequestMapping("list")
    public String list(Model model)
    {
        List<Factory> dataList = service.findAll();
        model.addAttribute("items", dataList);

        return "/basicinfo/factory/jFactoryList.jsp";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create()
    {
        return "/basicinfo/factory/jFactoryCreate.jsp";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(Factory factory)
    {
        factory.setId(UUID.randomUUID().toString());
        factory.setCreateTime(new Date());
        service.insert(factory);
        return LIST;
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") String id, Model model)
    {
        model.addAttribute("obj", service.findById(id));
        return "/basicinfo/factory/jFactoryUpdate.jsp";
    }
    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable("id") String id, Model model)
    {
        model.addAttribute("obj", service.findById(id));
        return "/basicinfo/factory/jFactoryView.jsp";
    }
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(Factory factory)
    {
        service.update(factory);
        return LIST;
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable("id") String id)
    {
        service.deleteById(id);
        return LIST;
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String deleteByIds(@RequestParam("ids") List<String> ids)
    {
        service.deleteByIds(ids);
        return LIST;
    }

    // 启用和停用 批量操作
    @RequestMapping(value = "disable", method = RequestMethod.POST)
    public String disable(@RequestParam("ids") List<String> ids)
    {
        service.changeState(ids, Factory.STATE_DISABLE);
        return LIST;
    }
    @RequestMapping(value = "enable", method = RequestMethod.POST)
    public String enable(@RequestParam("ids") List<String> ids)
    {
        service.changeState(ids, Factory.STATE_ENABLE);
        return LIST;
    }

    // 启用和停用单个操作
    @RequestMapping(value = "disable/{id}", method = RequestMethod.GET)
    public String disable(@PathVariable("id") String id)
    {
        service.changeState(id, Factory.STATE_DISABLE);
        return LIST;
    }
    @RequestMapping(value = "enable/{id}", method = RequestMethod.GET)
    public String enable(@PathVariable("id") String id)
    {
        service.changeState(id, Factory.STATE_ENABLE);
        return LIST;
    }
}
