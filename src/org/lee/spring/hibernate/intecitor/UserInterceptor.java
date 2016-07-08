package org.lee.spring.hibernate.intecitor;

import java.lang.reflect.Method;

import org.lee.spring.hibernate.model.Admin;
import org.lee.spring.hibernate.model.LibException;
import org.lee.spring.hibernate.model.Reader;
import org.lee.spring.hibernate.util.ActionUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class UserInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Admin a=(Admin) ActionContext.getContext().getSession().get("loginAdmin");
		Reader r=(Reader) ActionContext.getContext().getSession().get("loginReader");
		String name=invocation.getProxy().getMethod();
		Method method=invocation.getAction().getClass().getMethod(name);
		if(a==null&&r==null) {
			return "Login";
		}
		if(a!=null&&a.getStatus()==0) {
			return invocation.invoke();
		}
		int flag=ActionUtil.interceptorAuth(method);
		if(flag==1) {
			return invocation.invoke();
		}
		if(flag==2) {
			if(a!=null&&a.getStatus()==1) {
				return invocation.invoke();
			} else throw new LibException("您没有权限访问该页面");
		}
		if(flag==3) {
			if(a!=null&&a.getStatus()==2) {
				return invocation.invoke();
			} else throw new LibException("您没有权限访问该页面");
		}
		if(flag==0) {
			throw new LibException("您没有权限访问该页面");
		}
		return invocation.invoke();
	}

}
