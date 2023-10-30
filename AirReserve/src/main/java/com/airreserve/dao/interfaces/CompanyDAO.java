package com.airreserve.dao.interfaces;

import com.airreserve.Entities.Company;
import jakarta.persistence.PersistenceException;

import java.util.List;

public interface CompanyDAO {
    public Company create(Company company) throws PersistenceException;
    public Company getCompanyById (int id) throws PersistenceException;
    public List<Company> getCompaniesByName (String name) throws PersistenceException;
    public List<Company> getAllCompanies() throws PersistenceException;
}
