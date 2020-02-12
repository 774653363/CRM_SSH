package ek.zhou.crm.dao.imp;



import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import ek.zhou.crm.dao.UserDao;
import ek.zhou.crm.domain.User;

public class UserDaoImp extends HibernateTemplate implements UserDao{

	public void save(User user) {
		super.save(user);
	}

	public User login(User user) {
		List<User> users = (List<User>) super.find("from User u where u.user_code=? and u.user_password=?", user.getUser_code(),user.getUser_password());
		if(users.size()>0){
		return users.get(0);
		}else{
			return null;
		}
	}

}
