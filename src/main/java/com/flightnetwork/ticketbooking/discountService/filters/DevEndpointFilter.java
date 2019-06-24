package com.flightnetwork.ticketbooking.discountService.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(1)
@Component
public class DevEndpointFilter implements Filter {

    private static final Logger logger = LogManager.getLogger(DevEndpointFilter.class);

    private static final String DEV_ENDPOINT_PREFIX = "/discount/dev/";

    @Value("${dev.port}")
    private Integer devPort;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if ((devPort.equals(request.getLocalPort()) && ((HttpServletRequest) request).getRequestURI().startsWith(DEV_ENDPOINT_PREFIX)) ||
                !((HttpServletRequest) request).getRequestURI().startsWith(DEV_ENDPOINT_PREFIX))
            chain.doFilter(request, response);
        else {
            logger.error(String.format("Cannot access development endpoints on regular port, %d", request.getLocalPort()));
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    @Override
    public void destroy() {
    }

}
