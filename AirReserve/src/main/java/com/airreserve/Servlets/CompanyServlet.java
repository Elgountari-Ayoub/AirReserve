package com.airreserve.Servlets;

import com.airreserve.Entities.Admin;
import com.airreserve.Entities.Company;
import com.airreserve.dao.implementations.AdminDAOImpl;
import com.airreserve.dao.implementations.CompanyDAOImpl;
import com.airreserve.dao.interfaces.AdminDAO;
import com.airreserve.dao.interfaces.CompanyDAO;
import jakarta.persistence.PersistenceException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/company", "/company/create", "/company/update", "/company/delete", "/company/find", "/company/all", "/company/filter"})
public class CompanyServlet extends HttpServlet {
    private CompanyDAO companyDAO;
    Company company;
    List<Company> companyList;
    AdminDAO adminDAO;
    Admin admin;
    List<Admin> admins;


    @Override
    public void init() throws ServletException {
        this.companyDAO = new CompanyDAOImpl();
        company = new Company();
        adminDAO = new AdminDAOImpl();
        admin = new Admin();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path != null) {
            switch (path) {
                case "/company/create":
//                    admin = adminDAO.getAdminById(1);
//                    request.setAttribute("admin", admin);
                    request.getRequestDispatcher( "view/company/create.jsp").forward(request, response);
                    break;
                case "/company/update":
                    request.getRequestDispatcher("view/company/update.jsp").forward(request, response);

                    break;
                case "/company/find":
                    if (request.getAttribute("id") != null) {
                        int companyId = (int) request.getAttribute("id");
                        company = companyDAO.getCompanyById(companyId);
                        request.setAttribute("company", company);
                        request.getRequestDispatcher("view/company/details.jsp").forward(request, response);
                    } else if ((String) request.getAttribute("name") != null) {
                        String name = (String) request.getAttribute("name");
                        List<Company> companyList = companyDAO.getAllCompanies();
                        request.setAttribute("companyList", companyList);
                        request.getRequestDispatcher("view/company/index.jsp").forward(request, response);

                    }
                    break;
                case "/company":
                    companyList = companyDAO.getAllCompanies();
                    request.setAttribute("companyList", companyList);
                    request.getRequestDispatcher("view/company/index.jsp").forward(request, response);
                    break;
                default:
                    List<Company> companyList = companyDAO.getAllCompanies();
                    request.setAttribute("companyList", companyList);
                    request.getRequestDispatcher("view/company/index.jsp").forward(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        System.out.println("PATH => " + path);

        if (path != null) {
            switch (path) {
                case "/company/create":
                    try {
                        company = companyDAO.create(company);
                        request.setAttribute("company", company);
                        response.sendRedirect("/company");
                    } catch (PersistenceException pe) {
                        pe.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
