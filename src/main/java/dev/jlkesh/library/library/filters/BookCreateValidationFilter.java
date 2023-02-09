package dev.jlkesh.library.library.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "BookCreateValidationFilter", urlPatterns = "/book/add")
public class BookCreateValidationFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        var req = (HttpServletRequest) request;
        var res = (HttpServletResponse) response;
        String publisher = req.getParameter("publisher");
        if (req.getMethod().equalsIgnoreCase("post")) {
            if (publisher == null || publisher.isBlank()) {
                request.setAttribute("publisher_error", "Publisher can not be null");
                RequestDispatcher dispatcher = req.getRequestDispatcher("/book/create.jsp");
                dispatcher.forward(req, res);
            } else chain.doFilter(req, res);
        } else
            chain.doFilter(req, res);
    }
}
