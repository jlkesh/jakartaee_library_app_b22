package dev.jlkesh.library.library.filters.security;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Log
@WebFilter(urlPatterns = "/*")
public class SecurityFilter implements Filter {

    private static final List<String> WHITE_LIST = List.of(
            "/",
            "/book",
            "/auth/login",
            "/auth/register",
            "/resources/.+",
            "/download"
    );

    private static final Predicate<String> isSecure = (uri) -> {
        for (String item : WHITE_LIST)
            if (uri.matches(item))
                return false;
        return true;
    };

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String requestURI = request.getRequestURI();
        log.info(requestURI);
        if (!isSecure.test(requestURI))
            chain.doFilter(request, response);
        else {
            Cookie[] cookies = Objects.requireNonNullElse(request.getCookies(), new Cookie[]{});
            Arrays.stream(cookies)
                    .filter(cookie -> cookie.getName().equals("sessionID"))
                    .findFirst()
                    .ifPresentOrElse((cookie -> {
                        try {
                            chain.doFilter(request, response);
                        } catch (IOException | ServletException e) {
                            throw new RuntimeException(e);
                        }
                    }), () -> {
                        try {
                            response.sendRedirect("/auth/login?next=" + requestURI);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }
    }
}
