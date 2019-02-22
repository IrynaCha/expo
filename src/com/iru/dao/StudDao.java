package com.iru.dao;

import com.iru.domain.StudDomain;

public interface StudDao {
    StudDomain findByFullName(String firstName, String lastName) throws DaoException;
}
