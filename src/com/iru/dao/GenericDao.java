package com.iru.dao;

import java.util.List;

public interface GenericDao<T> {
    T findById(Long id) throws DaoException;

    List<T> list() throws DaoException;

    T create(T newInstance) throws DaoException;

    T update(T transientObject) throws DaoException;

    void delete(T persistentObject) throws DaoException;
}
