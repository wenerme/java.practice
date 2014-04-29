package me.wener.practices.web.common.dao;


import java.util.List;
import javax.persistence.criteria.Predicate;
import javax.persistence.metamodel.SingularAttribute;

public interface IQueryClause<E>
{
    public IQueryClause<E> skipNull();
    public IQueryClause<E> skipEmpty();
    public IQueryClause<E> skipNullOrEmpty();
    public IQueryClause<E> on(SingularAttribute<E, ?> attr);
    public IQueryClause<E> on(SingularAttribute<E, ?> ... attrs);
    public IQueryClause<E> on(List<SingularAttribute<E, ?>> attrs);
    public Predicate done();
}
