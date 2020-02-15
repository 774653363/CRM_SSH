package ek.zhou.crm.service.imp;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import ek.zhou.crm.dao.SaleVisitDao;
import ek.zhou.crm.domain.SaleVisit;
import ek.zhou.crm.service.SaleVisitService;
import ek.zhou.crm.utils.PageBean;

public class SaleVisitServiceImp implements SaleVisitService{
	//注入SaleVisitDao
	SaleVisitDao saleVisitDao;

	public SaleVisitDao getSaleVisitDao() {
		return saleVisitDao;
	}

	public void setSaleVisitDao(SaleVisitDao saleVisitDao) {
		this.saleVisitDao = saleVisitDao;
	}

	@Override
	public PageBean<SaleVisit> findAll(DetachedCriteria detachedCriteria, int pageNumber, int pageSize) {
		//调用Dao获取该条件下的记录总数
		int totalRecord = saleVisitDao.findCountByCondition(detachedCriteria);
		PageBean<SaleVisit> page = new PageBean<>(pageNumber, pageSize, totalRecord);
		//调用Dao获取该条件下的列表
		List<SaleVisit> data = saleVisitDao.findPageByCondition(detachedCriteria, page.getStartIndex(), pageSize);
		page.setData(data);
		
		return page;
	}

	@Override
	@Transactional
	public void add(SaleVisit saleVisit) {
		//调用dao保存拜访记录
		saleVisitDao.add(saleVisit);
	}

	@Override
	@Transactional
	public SaleVisit findById(String visit_id) {
		// 调用Dao查询拜访记录
		return saleVisitDao.findById(visit_id);
	}

	@Override
	@Transactional
	public void update(SaleVisit saleVisit) {
		//调用dao更新拜访记录
		saleVisitDao.update(saleVisit);
	}

	@Override
	@Transactional
	public void delete(String visit_id) {
		saleVisitDao.delete(saleVisitDao.findById(visit_id));
	}
	
}
