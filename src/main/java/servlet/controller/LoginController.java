package servlet.controller;

import servlet.business.LoginBusiness;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {

    private String userName;
    private String password;

    // TODO: Navigating back from the account page to the login page throws an null pointer error

    // TODO Need to implement a controller to register a new account

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginController class called");

        request.setAttribute("currentPage", "account.jsp");

        userName = request.getParameter("userNameLoginInput");
        password = request.getParameter("passwordLoginInput");

        try {
            boolean loginStatus = LoginBusiness.validCredentials(userName, password);

            if (loginStatus) {
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