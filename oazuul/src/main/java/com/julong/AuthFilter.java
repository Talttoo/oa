package com.julong;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Component
//public class AuthFilter extends ZuulFilter {
//
//    /**
//     * pre：路由之前
//     * routing：路由之时
//     * post： 路由之后
//     * error：发送错误调用
//     *
//     * @return
//     */
//    @Override
//    public String filterType() {
//        return "pre";
//    }
//
//    @Override
//    public int filterOrder() {
//        return 0;
//    }
//
//
//    @Override
//    public boolean shouldFilter() {
//        System.out.println("options....");
//        RequestContext ctx = RequestContext.getCurrentContext();
//        HttpServletRequest request = ctx.getRequest();
//        if (request.getMethod().equals("OPTIONS")) {
//            return false;
//        }
//        return true;
//    }
//
////    @Override
////    protected boolean preHandle(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
////        HttpServletRequest request = (HttpServletRequest) servletRequest;
////        HttpServletResponse response = (HttpServletResponse) servletResponse;
////        if(request.getMethod().equals(RequestMethod.OPTIONS.name()))
////        {
////            response.setStatus(HttpStatus.OK.value());
////            return false;
////        }
////        return super.preHandle(request, response);
////    }
//
//    @Override
//    public Object run() throws ZuulException {
//        return null;
//    }
//
//
//}