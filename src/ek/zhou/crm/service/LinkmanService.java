package ek.zhou.crm.service;

import org.hibernate.criterion.DetachedCriteria;

import ek.zhou.crm.domain.Linkman;
import ek.zhou.crm.utils.PageBean;

public interface LinkmanService {

	PageBean<Linkman> findAll(DetachedCriteria detachedCriteria, int pageNumber, int pageSize);

	void add(Linkman linkman);

	Linkman findById(int lkm_id);

	void update(Linkman linkman);

	void delete(int lkm_id);

}
