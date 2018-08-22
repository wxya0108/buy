package com.buy.interceptor;

import com.buy.entity.IMoocJSONResult;
import com.buy.utils.JsonUtils;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by win7 on 2018/8/3.
 */
public class TwoInterceptor implements HandlerInterceptor{

    /**
     * 在请求处理之前进行调用(Controller方法调用之前)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Two方法已拦截，放行");

        IMoocJSONResult result = new IMoocJSONResult();
        result.setMsg("Two方法拦截");
        returnErrorResponse(response,result);
        return true;
    }

    /**
     * 在请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后)
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("Two方法已拦截，该请求结束");
    }

    /**
     * 在整个请求结束之后进行调用，也就是在DispatcherServlet渲染了对应的视图之后执行
     * （主要用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }

    public void returnErrorResponse(HttpServletResponse response, IMoocJSONResult result) throws IOException {
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/json");
            out = response.getWriter();
            out.write(JsonUtils.objectToJson(result));
            out.flush();
        }finally {
            if(out!=null){
                out.close();
            }
        }
    }
}
