package dev.jlkesh.library.library.servlets.auth;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/auth/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("next", request.getParameter("next"));
        request.getRequestDispatcher("/auth/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String username = request.getParameter("username");
        final String password = request.getParameter("password");
        HttpSession session = request.getSession();
        Cookie cookie = new Cookie("sessionID", session.getId());
        cookie.setPath("/");
        cookie.setMaxAge(5 * 60 * 60);
        response.addCookie(cookie);
        response.sendRedirect(request.getParameter("next"));
    }
}
