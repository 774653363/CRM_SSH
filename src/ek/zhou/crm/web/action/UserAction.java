package ek.zhou.crm.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import ek.zhou.crm.domain.User;
import ek.zhou.crm.service.UserService;

public class UserAction extends ActionSupport{
	//spring注入user业务对象
	private UserService userService;
	//模型驱动使用的对象
	private User user;
	
	/**
	 * 用户注册
	 * @return
	 */
	public String regist(){
		//调用业务层完成用户注册功能
		
		userService.regist(user);
		return "login";
	}
	/**
	 * 跳转到注册页面
	 * @return
	 */
	public String registUI(){
		
		return "registUI";
	}
	/**
	 * 用户登录功能
	 * @return
	 */
	public String login(){
		User existUser = userService.login(user);
		if(null==existUser){
			//登录失败,添加错误信息
			this.addActionError("用户名或密码错误!");
			//跳转页面
			return"fail";
		}else{
			//登录成功,将user存入session
			ActionContext.getContext().getSession().put("existUser", existUser);
			//跳转页面
			return "success";
		}
	}
	
	
	
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
