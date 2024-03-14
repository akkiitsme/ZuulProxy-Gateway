package com.gatewayservice.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;

@Component
public class RouteValidationFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "error";
       // return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1; // Set order to run before other pre-filters
       // return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        // Customize the error response
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.setResponseBody("The requested URL is not found");
        ctx.getResponse().setContentType("application/json");
        ctx.setResponseStatusCode(404);
       // HttpServletRequest request =  ctx.getRequest();
       // System.out.println("Request: "+request.getRemoteAddr());
        return null;
    }


}
