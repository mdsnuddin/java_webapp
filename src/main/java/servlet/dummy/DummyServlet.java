package servlet.dummy;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DummyServlet extends HttpServlet {

    private String message;

    public void init() throws ServletException {
        message = "Hello World";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");

        System.out.println("DummyServlet class called");

        request.setAttribute("dummyName", "dummyValue");
        getServletContext().getRequestDispatcher("/dummy_home.jsp").forward(request, response);


        /*RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/dummy_home.jsp");
        requestDispatcher.forward(request, response);*/
    }

    public void destroy() {
        // do nothing.
    }
}