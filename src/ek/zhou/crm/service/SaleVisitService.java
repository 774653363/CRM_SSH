package ek.zhou.crm.service;

import org.hibernate.criterion.DetachedCriteria;

import ek.zhou.crm.domain.SaleVisit;
import ek.zhou.crm.utils.PageBean;

public interface SaleVisitService {

	PageBean<SaleVisit> findAll(DetachedCriteria detachedCriteria, int pageNumber, int pageSize);

	void add(SaleVisit saleVisit);

	SaleVisit findById(String visit_id);

	void update(SaleVisit saleVisit);

	void delete(String visit_id);

}
