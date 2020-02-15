package ek.zhou.crm.service.imp;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import ek.zhou.crm.dao.LinkmanDao;
import ek.zhou.crm.domain.Linkman;
import ek.zhou.crm.service.LinkmanService;
import ek.zhou.crm.utils.PageBean;

public class LinkmanServiceImp implements LinkmanService{
//注入联系人dao
	LinkmanDao linkmanDao;

	public LinkmanDao getLinkmanDao() {
		return linkmanDao;
	}

	public void setLinkmanDao(LinkmanDao linkmanDao) {
		this.linkmanDao = linkmanDao;
	}
	@Override
	public PageBean<Linkman> findAll(DetachedCriteria detachedCriteria, int pageNumber, int pageSize) {
		int totalRecord = linkmanDao.findCountByCondition(detachedCriteria);
		PageBean<Linkman> page = new PageBean<>(pageNumber, pageSize, totalRecord);
		List<Linkman> data = linkmanDao.findPageByCondition(detachedCriteria,page.getStartIndex(),pageSize);
		page.setData(data);
		return page;
	}

	@Override
	@Transactional
	public void add(Linkman linkman) {
		//调用dao进行保存
		linkmanDao.add(linkman);
	}

	@Override
	public Linkman findById(int lkm_id) {
		//调用dao根据id查询Linkman
		return linkmanDao.findById(lkm_id);
	}

	@Override
	@Transactional
	public void update(Linkman linkman) {
		//调用dao更新联系人
		linkmanDao.update(linkman);
	}

	@Override
	@Transactional
	public void delete(int lkm_id) {
		//调用dao查询联系人并删除联系人
		linkmanDao.delete(linkmanDao.findById(lkm_id));
	}
	
	
}
