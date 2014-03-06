package servlet.service;

import dao.scripts.StartUpScripts;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Initialize extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Initialize class called");

        StartUpScripts.updateDB();

        response.setContentType("text/html");

        request.setAttribute("currentPage", "login.jsp");
        request.setAttribute("currentUserName", "Guest");
        request.setAttribute("isUserLoggedIn", "false");

        getServletContext().getRequestDispatcher("/" + request.getAttribute("currentPage")).forward(request, response);
    }
}