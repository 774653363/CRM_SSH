package ek.zhou.crm.service.imp;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ek.zhou.crm.dao.UserDao;
import ek.zhou.crm.domain.User;
import ek.zhou.crm.service.UserService;
import ek.zhou.crm.utils.MD5Utils;

public class UserServiceImp implements UserService{
	//spring 注入dao对象
	UserDao userDao ;
	
	/**
	 * 业务层注册功能
	 */
	@Transactional(rollbackForClassName="Exception",propagation=Propagation.REQUIRED)
	@Override
	public void regist(User user) {
		System.out.println("用户管理的业务层注册方法执行了...");
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		user.setUser_state('1');
		//调用Dao
		userDao.save(user);
	}
	
	/**
	 * 业务层登录功能
	 */
	@Transactional(rollbackForClassName="Exception",propagation=Propagation.REQUIRED)
	@Override
	public User login(User user) {
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		return userDao.login(user);
	}
	
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
