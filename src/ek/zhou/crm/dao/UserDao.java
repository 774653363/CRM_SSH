package ek.zhou.crm.dao;

import ek.zhou.crm.domain.User;

public interface UserDao {

	void save(User user);

	User login(User user);

}
