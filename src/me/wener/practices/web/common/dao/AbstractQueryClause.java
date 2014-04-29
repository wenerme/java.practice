package me.wener.practices.web.common.dao;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.criteria.Predicate;
import javax.persistence.metamodel.SingularAttribute;
import lombok.Getter;
import lombok.Setter;
import me.wener.practices.web.common.util.ValueTester;

public abstract class AbstractQueryClause<E> implements IQueryClause<E>
{

    @Setter
    @Getter
    private ValueTester tester;
    @Getter
    private boolean skipNull = false;
    @Getter
    private boolean skipEmpty = false;

    @Getter
    private List<SingularAttribute<E, ?>> attributes = new ArrayList<>();

    @Override
    public IQueryClause<E> skipNull()
    {
        skipNull = true;
        return this;
    }

    @Override
    public IQueryClause<E> skipEmpty()
    {
        skipEmpty = true;
        return this;
    }

    @Override
    public IQueryClause<E> skipNullOrEmpty()
    {
        skipNull();
        skipEmpty();
        return this;
    }

    @Override
    public IQueryClause<E> on(SingularAttribute<E, ?> attr)
    {
        attributes.add(attr);
        return this;
    }

    @Override
    public IQueryClause<E> on(SingularAttribute<E, ?>... attrs)
    {
        attributes.addAll(Arrays.asList(attrs));
        return this;
    }

    @Override
    public IQueryClause<E> on(List<SingularAttribute<E, ?>> attrs)
    {
        attributes.addAll(attrs);
        return this;
    }

    protected boolean isValid(Object val)
    {
        boolean valid;
        valid = isSkipNull() || tester.isNull(val);
        valid = valid && isSkipEmpty() || tester.isEmpty(val);
        return valid;
    }

    @Override
    public abstract Predicate done();
}
