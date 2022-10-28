package com.example.lab_1_ultalast;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/ask_name.jsp");
        requestDispatcher.forward(request,response);
        // Hello
       /* PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");*/
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("dataInput");
        if(name.isEmpty()){
            response.sendRedirect("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
            return;
        }
        request.setAttribute("name",name);
        getServletContext().getRequestDispatcher("/views/hello.jsp").forward(request, response);

    }

    public void destroy() {
    }
}