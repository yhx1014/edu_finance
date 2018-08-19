package com.edu.finance.framework.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.edu.finance.framework.context.SpringContextHolder;
import com.edu.finance.model.DaisyUserVO;
import com.edu.finance.service.IDaisyUserService;
import com.edu.finance.util.Constant;
import com.edu.finance.util.JSONUtil;
import com.edu.finance.util.Toolkit;

/**
 * api调用拦截
 *
 */
public class APIInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String accessKey = request.getParameter("accessKey");
		String account = request.getParameter("account");
		Map<String, Object> error = null; 
		if (Toolkit.isEmpty(account)){
			error = new HashMap<String, Object>();
			error.put("code", Constant.STATUS_NO_ACCOUNT);
			error.put("msg", "未传账户信息");
		} else if(Toolkit.isEmpty(accessKey)){
			error = new HashMap<String, Object>();
			error.put("code", Constant.STATUS_NO_ACCESSKEY);
			error.put("msg", "未传访问凭证");
		} 
		else {
			//判断accessKey是否合法
			IDaisyUserService userService = SpringContextHolder.getBean(IDaisyUserService.class);
			DaisyUserVO user = userService.findUserByCode(account);
			
			if (user == null){
				error = new HashMap<String, Object>();
				error.put("code", Constant.STATUS_ACCOUNT_INVALID);
				error.put("msg", "账户不存在");
			}else{
				if (!accessKey.equals(user.getsAccessKey())){
					error = new HashMap<String, Object>();
					error.put("code", Constant.STATUS_ACCOUNT_INVALID);
					error.put("msg", "访问凭证错误");
				}else if (user.getiStatus() != 1){
					error = new HashMap<String, Object>();
					error.put("code", Constant.STATUS_ACCOUNT_INVALID);
					error.put("msg", "账户异常");
				}
			}
		}
		if (error != null){
			response.setCharacterEncoding("utf-8");
			response.setHeader("Access-Control-Allow-Origin","*");
			response.getWriter().write(JSONUtil.toJson(error));
			response.getWriter().flush();
			response.getWriter().close();
		}
		return error == null;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
}
