package dev.jlkesh.library.library.servlets.errors;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ErrorHandler", urlPatterns = "/error")
public class ErrorHandler extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

/*
        "jakarta.servlet.forward.request_uri
        "jakarta.servlet.forward.context_path
        "jakarta.servlet.forward.servlet_path
        "jakarta.servlet.forward.path_info
        "jakarta.servlet.forward.mapping
        "jakarta.servlet.error.message
        "jakarta.servlet.error.servlet_name
        "jakarta.servlet.error.request_uri
        "jakarta.servlet.error.status_code
*/
        Exception exception = (Exception) request.getAttribute("jakarta.servlet.error");
        request.setAttribute("code", request.getAttribute("jakarta.servlet.error.status_code"));
        request.setAttribute("message", request.getAttribute("jakarta.servlet.error.message"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/errors/error.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
