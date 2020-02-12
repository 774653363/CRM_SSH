package ek.zhou.crm.service.imp;

import java.io.File;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import ek.zhou.crm.dao.CustomerDao;
import ek.zhou.crm.domain.Customer;
import ek.zhou.crm.service.CustomerService;
import ek.zhou.crm.utils.PageBean;

public class CustomerServiceImp  implements CustomerService{
	//注入Dao
	CustomerDao customerDao;


	@Override
	public PageBean<Customer> findAll(DetachedCriteria detachedCriteria, int pageNumber, int pageSize) {
		int totalRecord = customerDao.findCountByCondition(detachedCriteria);
		PageBean<Customer> page = new PageBean<>(pageNumber, pageSize, totalRecord);
		List<Customer> data = customerDao.findPageByCondition(detachedCriteria,page.getStartIndex(),pageSize);
		page.setData(data);
		return page;
	}
	
	

	/**
	 * 保存客户信息
	 */
	@Transactional
	@Override
	public void add(Customer customer) {
		//调用dao保存信息
		customerDao.add(customer);
	}

	@Transactional
	@Override
	public void delete(int cust_id) {
		Customer customer = customerDao.findById(cust_id);
		//删除图片
		if(null!=customer.getCust_image()&&!"".equals(customer.getCust_image())){
			String oldPath=ServletActionContext.getServletContext().getRealPath("/")+"/"+customer.getCust_image();
			File oldFile = new File(oldPath);
			if(oldFile.exists()){
				oldFile.delete();
			}
		}
		customerDao.delete(customer);
	}

	@Transactional
	@Override
	public Customer findById(int cust_id) {
		return customerDao.findById(cust_id);
	}

	@Transactional
	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
	}

	public CustomerDao getCustomerDao() {
		return customerDao;
	}
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
}
