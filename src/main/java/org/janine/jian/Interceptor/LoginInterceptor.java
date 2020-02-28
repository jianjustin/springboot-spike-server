package org.janine.jian.Interceptor;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.janine.jian.domain.SysUser;
import org.janine.jian.utils.SessionUtils;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录拦截器
 * @author jian
 */
public class LoginInterceptor implements HandlerInterceptor{
	private org.slf4j.Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	logger.info(request.getRequestURI().toString());
    	String sessionid = request.getSession().getId();
    	SysUser sysUser = SessionUtils.sessions.get(sessionid);
        
        if (null == sysUser)  {
            response.sendRedirect("/login");
            logger.info("======请先登录=======");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("postHandle...");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("afterCompletion...");
    }

}
