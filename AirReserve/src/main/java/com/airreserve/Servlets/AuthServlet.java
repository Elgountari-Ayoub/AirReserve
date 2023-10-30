package com.airreserve.Servlets;

import com.airreserve.Entities.Client;
import com.airreserve.dao.interfaces.ClientDAO;
import jakarta.persistence.PersistenceException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/register", "/login"})
public class AuthServlet extends HttpServlet {
    private ClientDAO clientDAO;

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

        switch (path){
            case "/register":
                request.getRequestDispatcher("view/register.jsp").forward(request, response);
                break;
            case "/login":
                request.getRequestDispatcher("view/login.jsp").forward(request, response);
            default:break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve registration form parameters from the request
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Client client = new Client();
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setPhone(phone);
        client.setEmail(email);
        client.setPassword(password);

        try {
            client  = clientDAO.register(client);
            req.setAttribute("client", client);
        }catch (PersistenceException pe){
            pe.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();

        }
    }
}
