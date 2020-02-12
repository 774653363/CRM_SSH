package ek.zhou.crm.service;

import ek.zhou.crm.domain.User;

public interface UserService {

	void regist(User user);

	User login(User user);

}
