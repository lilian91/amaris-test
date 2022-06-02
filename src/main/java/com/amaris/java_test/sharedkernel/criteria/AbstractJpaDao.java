package com.amaris.java_test.sharedkernel.criteria;

import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.*;

@Transactional
public abstract class AbstractJpaDao<T extends Serializable> {

    private Class<T> clazz;

    @PersistenceContext
    private EntityManager entityManager;

    public void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T entityLoad(Object object) throws IllegalAccessException {
        // Building the query
        String hql = "select obj from " + object.getClass().getSimpleName() + " obj";
        String where = " where ";
        // Adding filters to query by the attributes per object
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getName().equals("id"))
                where += " id = :" + field.getName();
        }
        Query query = entityManager.createQuery(hql + where);
        // Setting parameters to query by the values in object
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getName().equals("id"))
                query.setParameter(field.getName(), field.get(object));
        }
        // Returning query result
        return (T) query.getSingleResult();
    }

    public T findOne(long id) {
        return entityManager.find(clazz, id);
    }

    public List<T> findAll() {
        String hql = "from " + clazz.getName();
        return entityManager.createQuery(hql).getResultList();
    }

    public T save(T entity) throws IllegalAccessException {
        entityManager.persist(entity);
        entityManager.flush();
        entityManager.refresh(entityLoad(entity));
        return entityLoad(entity);
    }

    public T update(T entity) throws IllegalAccessException {
        entityManager.merge(entity);
        entityManager.flush();
        entityManager.refresh(entityLoad(entity));
        entityManager.close();
        return entityLoad(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entity);
        entityManager.flush();
    }

    public void deleteById(Long entityId) {
        T entity = findOne(entityId);
        delete(entity);
    }

    public void deleteAll() {
        List<T> all = findAll();
        for (T element : all) {
            delete(element);
        }
    }

    public Query getNativeQuery(String query) {
        return entityManager.createNativeQuery(query, this.clazz);
    }

    public Query getNativeQuery(String query, String mapping) {
        return entityManager.createNativeQuery(query, mapping);
    }

    public Query createNativeQuery(String query) {
        return entityManager.createNativeQuery(query);
    }

}
