package com.airreserve.dao.interfaces;

import com.airreserve.Entities.Client;

import jakarta.persistence.PersistenceException;
import java.util.List;

public interface ClientDAO {
    Client register(Client client) throws PersistenceException;

    Client login(String email, String password) throws PersistenceException;

    Client get(int id) throws PersistenceException;

    List<Client> getAll() throws PersistenceException;

    void update(Client client) throws PersistenceException;

    void delete(int id) throws PersistenceException;
}
