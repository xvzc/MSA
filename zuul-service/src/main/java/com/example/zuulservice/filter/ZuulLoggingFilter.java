package com.example.zuulservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@Slf4j
public class ZuulLoggingFilter extends ZuulFilter {
    // Slf4j 애너테이션을 붙여주면 Logger 객체를 생성해주지 않아도 된다.
    // Logger logger = LoggerFactory.getLogger(ZuulLoggingFilter.class);

    @Override
    public Object run() throws ZuulException {
        log.info("************ printing logs:");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("************ log ends:");
        return null;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        // 필터가 여러개 있을 때 순서
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

}
