package ek.zhou.crm.dao.imp;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateTemplate;

import ek.zhou.crm.dao.CustomerDao;
import ek.zhou.crm.domain.Customer;

public class CustomerDaoImp extends HibernateTemplate implements CustomerDao{

	@Override
	public int findCountByCondition(DetachedCriteria detachedCriteria) {
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) super.findByCriteria(detachedCriteria);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Customer> findPageByCondition(DetachedCriteria detachedCriteria, int startIndex, int pageSize) {
		detachedCriteria.setProjection(null);
		return (List<Customer>) super.findByCriteria(detachedCriteria, startIndex, pageSize);
	}

	@Override
	public void add(Customer customer) {
		this.save(customer);
	}

	public Customer findById(int cust_id) {
		return super.get(Customer.class, cust_id);
	}

	public void delete(Customer customer) {
		super.delete(customer);
	}

	public void update(Customer customer) {
		super.update(customer);
	}

}
