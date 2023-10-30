package com.airreserve;

import java.io.*;

import com.airreserve.Utils.HibernateUtil;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.SessionFactory;

@WebServlet(name = "helloServlet", value = {"/hello-servlet"})
public class HelloServlet extends HttpServlet {
    private String message;
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<a href=\"register\">register</a>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}