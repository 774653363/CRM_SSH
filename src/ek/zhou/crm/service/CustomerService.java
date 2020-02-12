package ek.zhou.crm.service;

import org.hibernate.criterion.DetachedCriteria;

import ek.zhou.crm.domain.Customer;
import ek.zhou.crm.utils.PageBean;

public interface CustomerService {

	PageBean<Customer> findAll(DetachedCriteria detachedCriteria, int pageNumber, int pageSize);

	void add(Customer customer);

	void delete(int cust_id);

	Customer findById(int cust_id);

	void update(Customer customer);

}
