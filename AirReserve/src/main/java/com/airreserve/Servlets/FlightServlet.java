package com.airreserve.Servlets;

import com.airreserve.Entities.AirPlane;
import com.airreserve.Entities.Flight;
import com.airreserve.dao.implementations.AirPlaneDAOImpl;
import com.airreserve.dao.implementations.FlightDAOImpl;
import com.airreserve.dao.interfaces.AirPlaneDAO;
import com.airreserve.dao.interfaces.FlightDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(urlPatterns = {"/flight"})
public class FlightServlet extends HttpServlet {
    private FlightDAO flightDAO;
    private Flight flight;
    private AirPlaneDAO airPlaneDAO;
    private AirPlane airPlane;

    String departureCity;
    String destination;
    String departureDateStr;
    LocalDateTime departureDate;
    String arrivalDateStr;
    LocalDateTime arrivalDate;
    String ticketPrice;
    int seatCount;
    int airPlaneId;

    String flightIdParam;

    List<Flight> flightList;

    @Override
    public void init() throws ServletException {
        this.flightDAO = new FlightDAOImpl();
        this.airPlaneDAO = new AirPlaneDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "create":
                    List<AirPlane> airPlanes = airPlaneDAO.getAirPlanes();
                    request.setAttribute("airPlanes", airPlanes);
                    request.getRequestDispatcher("view/flight/create.jsp").forward(request, response);
                    break;
                case "find":
                    flightIdParam = request.getParameter("flightId");
                    if (flightIdParam != null && !flightIdParam.isEmpty()) {
                        try {
                            int flightId = Integer.parseInt(flightIdParam);
                            Flight flight = flightDAO.getFlightById(flightId);
                            if (flight != null) {
                                request.setAttribute("flight", flight);
                                request.getRequestDispatcher("view/flight/details.jsp").forward(request, response);
                            } else {
                                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Flight not found with ID: " + flightId);
                            }
                        } catch (NumberFormatException e) {
                            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid flightId format");
                        }
                    } else {
                        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing flightId parameter");
                    }
                    break;
                case "update":
                    flightIdParam = request.getParameter("flightId");
                    if (flightIdParam != null && !flightIdParam.isEmpty()) {
                        try {
                            int flightId = Integer.parseInt(flightIdParam);
                            Flight flightToUpdate = flightDAO.getFlightById(flightId);
                            if (flightToUpdate != null) {
                                request.setAttribute("flightToUpdate", flightToUpdate);
                                request.getRequestDispatcher("view/flight/update.jsp").forward(request, response);
                            } else {
                                // Handle the case where the flight is not found
                                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Flight not found with ID: " + flightId);
                            }
                        } catch (NumberFormatException e) {
                            // Handle invalid flightId format
                            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid flightId format");
                        }
                    } else {
                        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing flightId parameter");
                    }
                    break;
                case "delete":
                    flightIdParam = request.getParameter("flightId");
                    if (flightIdParam != null && !flightIdParam.isEmpty()) {
                        try {
                            int flightId = Integer.parseInt(flightIdParam);
                            Flight flightToDelete = flightDAO.getFlightById(flightId);

                            if (flightToDelete != null) {
                                flightDAO.deleteFlight(flightToDelete);
                                response.sendRedirect("flight?action=all");
                            } else {
                                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Flight not found with ID: " + flightId);
                            }
                        } catch (NumberFormatException e) {
                            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid flightId format");
                        }
                    } else {
                        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing flightId parameter");
                    }
                    break;
                case "all":
                    flightList = flightDAO.getFlights();
                    request.setAttribute("flightList", flightList);
                    request.getRequestDispatcher("view/flight/index.jsp").forward(request, response);
                    break;
                default:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing flightId parameter");
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "create":
                    departureCity = request.getParameter("departureCity");
                    destination = request.getParameter("destination");
                    departureDateStr = request.getParameter("departureDate");
                    departureDate = LocalDateTime.parse(departureDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
                    arrivalDateStr = request.getParameter("arrivalDate");
                    arrivalDate = LocalDateTime.parse(arrivalDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));

                    String ticketPrice = request.getParameter("ticketPrice");
                    int seatCount = Integer.parseInt(request.getParameter("seatCount"));

                    airPlaneId = Integer.parseInt(request.getParameter("airPlane"));
                    airPlane = airPlaneDAO.getAirPlaneById(airPlaneId);


                    Flight flight = new Flight();
                    flight.setDepartureCity(departureCity);
                    flight.setDestination(destination);
                    flight.setDepartureDate(departureDate);
                    flight.setArrivalDate(arrivalDate);
                    flight.setTicketPrice(ticketPrice);
                    flight.setSeatCount(seatCount);
                    flight.setAirPlane(airPlane);
                    flight = flightDAO.create(flight);

                    if (flight != null) {
                        response.sendRedirect("flight?action=all");
                    } else {
                        response.sendError(HttpServletResponse.SC_NOT_FOUND, "Error while adding the flight: ");
                    }
                    break;
                case "update":
                    int flightId = Integer.parseInt(request.getParameter("flightId"));
                    departureCity = request.getParameter("departureCity");
                    destination = request.getParameter("destination");
                    departureDateStr = request.getParameter("departureDate");
                    LocalDateTime departureDate = LocalDateTime.parse(departureDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
                    arrivalDateStr = request.getParameter("arrivalDate");
                    LocalDateTime arrivalDate = LocalDateTime.parse(arrivalDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));

                    ticketPrice = request.getParameter("ticketPrice");
                    seatCount = Integer.parseInt(request.getParameter("seatCount"));

                    Flight flightToUpdate = flightDAO.getFlightById(flightId);

                    if (flightToUpdate != null) {
                        flightToUpdate.setDepartureCity(departureCity);
                        flightToUpdate.setDestination(destination);
                        flightToUpdate.setDepartureDate(departureDate);
                        flightToUpdate.setArrivalDate(arrivalDate);
                        flightToUpdate.setTicketPrice(ticketPrice);
                        flightToUpdate.setSeatCount(seatCount);

                        // Use your FlightDAO to update the flight in the database
                        flightDAO.update(flightToUpdate);

                        // Redirect to the flight details page after the update
                        response.sendRedirect("flight?action=find&flightId=" + flightId);
                    } else {
                        response.sendError(HttpServletResponse.SC_NOT_FOUND, "Flight not found with ID: " + flightId);
                    }
                    break;
                default:
                    response.sendRedirect("view/index");
                    break;
            }
        }
    }
}
