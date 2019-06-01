package com.stats.tracker.be.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import xxx.joker.libs.core.datetime.JkDuration;
import xxx.joker.libs.core.format.JkOutput;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        logger.info("BEFORE request [{}, {}]", request.getMethod(), request.getRequestURL().toString());
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        long startTime = (Long) request.getAttribute("startTime");
        long elapsedTime = System.currentTimeMillis() - startTime;
        String strElapsed = JkDuration.toStringElapsed(elapsedTime);
        logger.info("AFTER request [{}, {}]: elapsed time: {}", request.getMethod(), request.getRequestURL().toString(), strElapsed);
    }

}