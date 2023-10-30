package com.airreserve.dao.interfaces;

import com.airreserve.Entities.AirPlane;
import jakarta.persistence.PersistenceException;

import java.util.List;

public interface AirPlaneDAO {
    public AirPlane create(AirPlane airPlane) throws PersistenceException;
    public AirPlane getAirPlaneById(int id) throws PersistenceException;
    public List<AirPlane> getAirPlanes() throws PersistenceException;
}
