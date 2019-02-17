package com.iru.dao;

import com.iru.domain.StudDomain;

import java.util.List;

public interface StudDao {
    StudDomain findById(Long id) throws DaoException;

    StudDomain findByFullName(String firstName, String lastName) throws DaoException;

    List<StudDomain> list() throws DaoException;

    StudDomain create(StudDomain student) throws DaoException;

    StudDomain update(StudDomain student) throws DaoException;

    void delete(StudDomain student) throws DaoException;
}
