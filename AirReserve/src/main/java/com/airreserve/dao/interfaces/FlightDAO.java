package com.airreserve.dao.interfaces;

import com.airreserve.Entities.Flight;
import jakarta.persistence.PersistenceException;

import java.util.List;

public interface FlightDAO {
    public Flight create(Flight flight) throws PersistenceException;

    void update(Flight flightToUpdate) throws PersistenceException ;

    public Flight getFlightById(int flightId) throws  PersistenceException;
    public void deleteFlight(Flight flight) throws PersistenceException;

    List<Flight> getFlights() throws  PersistenceException ;

}
