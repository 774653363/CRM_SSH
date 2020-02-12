package ek.zhou.crm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import ek.zhou.crm.domain.Customer;

public interface CustomerDao {

	int findCountByCondition(DetachedCriteria detachedCriteria);

	List<Customer> findPageByCondition(DetachedCriteria detachedCriteria, int startIndex, int pageSize);

	void add(Customer customer);

	Customer findById(int cust_id);

	void delete(Customer customer);

	void update(Customer customer);

}
