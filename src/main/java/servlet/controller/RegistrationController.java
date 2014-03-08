package servlet.controller;

import servlet.business.RegistrationBusiness;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationController extends HttpServlet {

    private String userName;
    private String password;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RegistrationController class called");

        request.setAttribute("currentPage", "account.jsp");

        userName = request.getParameter("userNameRegisterInput");
        password = request.getParameter("passwordRegisterInput");

        try {
            boolean registerStatus = RegistrationBusiness.validateRegistration(userName, password);

            if (registerStatus) {
                request.setAttribute("isUserLoggedIn", "true");
                request.setAttribute("currentUserName", userName);
            } else {
                request.setAttribute("isUserLoggedIn", "false");
            }
            getServletContext().getRequestDispatcher("/" + request.getAttribute("currentPage")).forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
