package me.wener.practices.crm.sys.student.counsel.service;

import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.metamodel.Attribute;
import me.wener.practices.crm.sys.clazz.service.ClassService;
import me.wener.practices.crm.sys.student.counsel.dao.CounselInfoDao;
import me.wener.practices.crm.sys.student.counsel.entity.CounselInfoEntity;
import me.wener.practices.crm.sys.student.counsel.entity.CounselInfoEntity_;
import me.wener.practices.web.common.service.BaseServiceImpl;
import me.wener.practices.web.common.util.BeanHelper;


public class CounselInfoServiceImpl
        extends BaseServiceImpl<CounselInfoDao, CounselInfoEntity, Long>
        implements CounselInfoService
{
    @Inject
    ClassService classService;

    @Inject
    @Override
    public void setDao(CounselInfoDao dao)
    {
        super.setDao(dao);
    }

    @Override
    public CounselInfoEntity editTo(CounselInfoEntity model)
    {
        CounselInfoEntity entity = id(model.getId());

//        if (!Strings.isNullOrEmpty(model.getName()))
//            entity.setName(model.getName());
//
//        if (!Strings.isNullOrEmpty(model.getAddress()))
//            entity.setAddress(model.getAddress());
//
//        if (!Strings.isNullOrEmpty(model.getEducation()))
//            entity.setEducation(model.getEducation());
//
//        if (!Strings.isNullOrEmpty(model.getPhone()))
//            entity.setPhone(model.getPhone());
//
//        if (!Strings.isNullOrEmpty(model.getQQ()))
//            entity.setQQ(model.getQQ());
//
//        if (!Strings.isNullOrEmpty(model.getRemark()))
//            entity.setPhone(model.getPhone());
//
//        if (!Strings.isNullOrEmpty(model.getSchool()))
//            entity.setSchool(model.getSchool());
//
//        if (model.getAge() != null)
//            entity.setAge(model.getAge());
//
//        if (model.getSex() != null)
//            entity.setSex(model.getSex());
//
//

//        final SingularAttribute<CounselInfoEntity, ?>[] editAttrs = new SingularAttribute<CounselInfoEntity, ?>[]{
//                CounselInfoEntity_.name,
//                CounselInfoEntity_.address,
//                CounselInfoEntity_.education,
//                CounselInfoEntity_.phone,
//                CounselInfoEntity_.QQ,
//                CounselInfoEntity_.remark,
//                CounselInfoEntity_.school,
//                CounselInfoEntity_.age,
//                CounselInfoEntity_.sex,
//        };

//
        List<? extends Attribute<CounselInfoEntity, ?>> editAttrs =
                Lists.<Attribute<CounselInfoEntity, ?>>newArrayList(
                        CounselInfoEntity_.name,
                        CounselInfoEntity_.address,
                        CounselInfoEntity_.education,
                        CounselInfoEntity_.phone,
                        CounselInfoEntity_.QQ,
                        CounselInfoEntity_.remark,
                        CounselInfoEntity_.school,
                        CounselInfoEntity_.age,
                        CounselInfoEntity_.sex);


        // 这里是没有问题的,但是 IntelliJ 会在这里报错.
        BeanHelper.merge(entity, model, BeanHelper.skipNullOrEmpty(model, editAttrs));

        if (model.getIntentionClass() != null)
            if (model.getIntentionClass().getId() == null)
                entity.setIntentionClass(null);
            else
                entity.setIntentionClass(classService.id(model.getIntentionClass().getId()));

        return entity;
    }

}
