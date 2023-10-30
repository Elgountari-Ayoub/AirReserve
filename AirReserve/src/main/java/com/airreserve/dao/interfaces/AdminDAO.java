package com.airreserve.dao.interfaces;

import com.airreserve.Entities.Admin;
import jakarta.persistence.PersistenceException;

public interface AdminDAO {

    Admin create (Admin admin) throws PersistenceException;
    public Admin getAdminById(int adminId) throws PersistenceException;

}
