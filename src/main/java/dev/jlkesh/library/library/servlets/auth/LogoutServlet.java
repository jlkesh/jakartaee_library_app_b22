package dev.jlkesh.library.library.servlets.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/auth/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/auth/logout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getValue().equals(session.getId())) {
                    cookie.setMaxAge(0);
                }
            }
        }
        response.sendRedirect("/auth/login");
    }
}
