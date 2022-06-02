package com.amaris.java_test.sharedkernel.criteria;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Repository
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class GenericJpaDao<T extends Serializable> extends AbstractJpaDao<T> implements IGenericDao<T> {

    @Override
    public T findOne(long id) {
        return super.findOne(id);
    }

    @Override
    public List<T> findAll() {
        return super.findAll();
    }

    @Override
    public T entityLoad(Object object) throws IllegalAccessException {
        return super.entityLoad(object);
    }

    @Override
    public T create(T entity) throws IllegalAccessException {
        return super.save(entity);
    }

    @Override
    public T update(T entity) throws IllegalAccessException {
        return super.update(entity);
    }

    @Override
    public void deleteById(Long entityId) {
        super.deleteById(entityId);
    }

    @Override
    public void deleteAll() {
        super.deleteAll();
    }

    @Override
    public Query getNativeQuery(String query) {
        return super.getNativeQuery(query);
    }

    @Override
    public Query getNativeQuery(String query, String mapping) {
        return super.getNativeQuery(query, mapping);
    }

    @Override
    public Query createNativeQuery(String query) {
        return super.createNativeQuery(query);
    }

}
