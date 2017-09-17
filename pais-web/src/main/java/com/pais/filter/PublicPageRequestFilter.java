package com.pais.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true,
        property = {"after-filter=Public Page Request Filter", "servlet-context-name=",
                "servlet-filter-name=Public Page Request Filter", "url-pattern=/web/*"},
        service = Filter.class)
public class PublicPageRequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        try {

            HttpServletResponse resp = (HttpServletResponse) response;

            // Force not to use cache
            resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            resp.setDateHeader("Expires", 0); // Proxies.
            
            chain.doFilter(request, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {}
}
