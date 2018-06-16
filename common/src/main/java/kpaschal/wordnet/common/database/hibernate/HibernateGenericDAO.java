package kpaschal.wordnet.common.database.hibernate;

import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

/**
 *
 * @author
 */
public class HibernateGenericDAO<T extends Serializable, I extends Serializable> {

    private Class<T> entityClass;
    private SessionFactory sessionFactory;

    public HibernateGenericDAO(Class<T> entityClass, SessionFactory sessionFactory) {
        this.entityClass = entityClass;
        this.sessionFactory = sessionFactory;
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    
    public I save(T model) {
        return (I)getSession().save(model);
    }

    
    public void saveOrUpdate(T model) {
        getSession().saveOrUpdate(model);
    }

    
    public void update(T model) {
        getSession().update(model);
    }

    
    public void merge(T model) {
        getSession().merge(model);
    }

    
    public void delete(T model) {
        getSession().delete(model);
    }

    
    public T getById(I id) {
        return (T) getSession().get(entityClass, id);
    }

    
    public T loadbyId(I id) {
        return (T) getSession().load(entityClass, id);
    }

    
    public Iterable<T> get(int from, int maxResults) {
        return getSession().createCriteria(entityClass).setFirstResult(from).setMaxResults(maxResults).list();
    }

    
    public Iterable<T> getAll() {
        return getSession().createCriteria(entityClass).list();
    }

    
    public void refresh(T model) {
        getSession().refresh(model);
    }

    
    public Integer getRowCount() {
        return (Integer) getSession().createCriteria(entityClass)
                .setProjection(Projections.rowCount()).uniqueResult();
    }
}
