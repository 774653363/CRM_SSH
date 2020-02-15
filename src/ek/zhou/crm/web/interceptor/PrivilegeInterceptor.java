package ek.zhou.crm.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import ek.zhou.crm.domain.User;

public class PrivilegeInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		User existUser = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if(null==existUser){
			//没有登陆
			ActionSupport actionSupport = (ActionSupport) actionInvocation.getAction();
			actionSupport.addActionError("您没有登陆,没有访问权限!请先登陆!");
			return "fail";
		}
		return actionInvocation.invoke();
	}

}
