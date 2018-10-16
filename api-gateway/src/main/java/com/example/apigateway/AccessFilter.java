package com.example.apigateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
@Component
public class AccessFilter extends ZuulFilter {
    @Override
public String filterType() { return "pre";
}
    @Override
    public int filterOrder() {
        return 0; }
    @Override
    public boolean shouldFilter() {
        return true; }
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContent = RequestContext.getCurrentContext(); HttpServletRequest httpServletRequest = requestContent.getRequest();
        Object accessToken = httpServletRequest.getParameter("accessToken"); if(accessToken == null) {
            requestContent.setSendZuulResponse(false);
            requestContent.setResponseStatusCode(401); }
        return null; }
}
