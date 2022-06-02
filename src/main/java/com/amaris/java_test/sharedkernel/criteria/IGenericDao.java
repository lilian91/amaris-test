package com.amaris.java_test.sharedkernel.criteria;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T extends Serializable> {

    T findOne(final long id);

    List<T> findAll();

    T entityLoad(final Object object) throws IllegalAccessException;

    T create(final T entity) throws IllegalAccessException;

    T update(final T entity) throws IllegalAccessException;

    void deleteById(final Long entityId);

    void deleteAll();

    Query getNativeQuery(String query);

    Query getNativeQuery(String query, String mapping);

    Query createNativeQuery(String query);
}
