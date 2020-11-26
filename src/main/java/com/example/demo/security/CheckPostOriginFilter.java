package com.example.demo.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * 为了避免rest接口的scrf问题，需要检查所有post请求的origin头，确保请求是由我们自己域名下的页面发来的
 */
@Component
@Slf4j
public class CheckPostOriginFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        if (HttpMethod.GET.matches(httpServletRequest.getMethod())) {
            chain.doFilter(request, response);
            return;
        }

        String origin = httpServletRequest.getHeader(HttpHeaders.ORIGIN);
        boolean isLegal = Objects.equals(origin, "https://gaolf.com");
        if (!isLegal) {
            log.warn("request origin check error! origin: " + origin);
            httpServletResponse.sendError(403, "access denied, illegal origin");
            return;
        }
        chain.doFilter(request, response);
    }
}
