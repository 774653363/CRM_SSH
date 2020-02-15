package ek.zhou.crm.web.action;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import ek.zhou.crm.domain.Customer;
import ek.zhou.crm.domain.Linkman;
import ek.zhou.crm.service.CustomerService;
import ek.zhou.crm.service.LinkmanService;
import ek.zhou.crm.utils.PageBean;

public class LinkmanAction extends ActionSupport{
	//注入联系人service
	private LinkmanService linkmanService;
	//注入客户service
	private CustomerService customerService;
	//联系人对象
	private Linkman linkman;
	//联系人分页信息
	private PageBean<Linkman> page;
	//客户列表
	private List<Customer> customers;
	//当前页数
	private int pageNumber=1;
	//页面大小
	private int pageSize=5;
	/**
	 * 条件分页查询所有联系人
	 * @return
	 */
	public String findAll(){
		//创建离线条件查询对象
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Linkman.class);
		//设置条件
		if(null!=linkman){
			if(linkman.getLkm_name()!=null&&!"".equals(linkman.getLkm_name())){
				detachedCriteria.add(Restrictions.like("lkm_name", "%"+linkman.getLkm_name()+"%"));
			}
			if(linkman.getLkm_gender()!=null&&!"".equals(linkman.getLkm_gender())){
				System.out.println("gender:"+linkman.getLkm_gender());
				detachedCriteria.add(Restrictions.eq("lkm_gender", linkman.getLkm_gender()));
			}
			
		}
		//业务层调用获取列表
		page = linkmanService.findAll(detachedCriteria,pageNumber,pageSize);
		
		//页面跳转
		return "list";
	}
	/**
	 * 查询所有客户并跳转到添加页面
	 * @return
	 */
	public String addUI(){
		customers = customerService.findAll();
//		ActionContext.getContext().getValueStack().push(customers);
		System.out.println(customers);
		return "addUI";
	}
	/**
	 * 添加联系人
	 * @return
	 */
	public String add(){
		//调用service进行保存
		linkmanService.add(linkman);
		return "listJsp";
	}
	/**
	 * 根据联系人id查询联系人
	 * 并查询客户列表
	 * 跳转到编辑页面
	 * @return
	 */
	public String edit(){
		//调用service查询linkman
		linkman = linkmanService.findById(linkman.getLkm_id());
		//调用service查询客户列表
		customers = customerService.findAll();
		return "edit";
	}
	/**
	 * 更新联系人信息
	 * @return
	 */
	public String update(){
		//调用service更新联系人
		linkmanService.update(linkman);
		return "listJsp";
	}
	/**
	 * 根据id删除联系人
	 * @return
	 */
	public String delete(){
		//调用service删除联系人
		linkmanService.delete(linkman.getLkm_id());
		return "listJsp";
	}
	public LinkmanService getLinkmanService() {
		return linkmanService;
	}

	public void setLinkmanService(LinkmanService linkmanService) {
		this.linkmanService = linkmanService;
	}

	public Linkman getLinkman() {
		return linkman;
	}

	public void setLinkman(Linkman linkman) {
		this.linkman = linkman;
	}


	public PageBean<Linkman> getPage() {
		return page;
	}
	public void setPage(PageBean<Linkman> page) {
		this.page = page;
	}
	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	public CustomerService getCustomerService() {
		return customerService;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
}
