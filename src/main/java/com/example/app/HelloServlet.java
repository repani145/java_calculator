package com.example.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Simple Java Application with version 1.1.1</title>");
        out.println("</head>");

        out.println("<body>");
        out.println("<h1>Hello from my Java Application!</h1>");
        out.println("<p>Application deployed successfully on Tomcat.</p>");
        out.println("</body>");

        out.println("</html>");
    }
}