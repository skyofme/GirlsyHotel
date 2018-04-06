package com.etc.interceptor;

import java.util.Map;

import com.etc.bean.Emp;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// 获取用户会话信息
		System.out.println("AuthorizationInterceptor===========");
		Map session = invocation.getInvocationContext().getSession();
		Emp emp = (Emp) session.get("login");
//		System.out.println(emp.getEmpName());
		if (emp == null) {
			session.put("info", "请先登录！");
			return "gologin";
		} else {
			// 继续执行剩余的拦截器和Action
			return invocation.invoke();
		}
		//return invocation.invoke();
	}

}
