package dev.jlkesh.library.library.servlets.book;

import dev.jlkesh.library.library.dao.BookDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "BookGetServlet", urlPatterns = "/book/get/*")
public class BookGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getPathInfo().substring(1);
        response.sendError(404, "Book With id '%s' not found".formatted(bookId));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
