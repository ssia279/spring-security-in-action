package com.johnsonwang.ssia.filters;

import org.springframework.security.web.csrf.CsrfToken;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Logger;

public class CsrfTokenLogger implements Filter {

    private Logger logger = Logger.getLogger(CsrfTokenLogger.class.getName());


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        Object o = servletRequest.getAttribute("_csrf");
        CsrfToken token = (CsrfToken) o;

        logger.info("CSRF token " + token.getToken());

        filterChain.doFilter(servletRequest, servletResponse);

    }
}
