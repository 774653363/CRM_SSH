package ek.zhou.crm.web.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;

import ek.zhou.crm.domain.Customer;
import ek.zhou.crm.domain.Linkman;
import ek.zhou.crm.domain.SaleVisit;
import ek.zhou.crm.service.CustomerService;
import ek.zhou.crm.service.SaleVisitService;
import ek.zhou.crm.utils.PageBean;

public class SaleVisitAction extends ActionSupport{
	//注入service
	private SaleVisitService saleVisitService;
	private CustomerService customerService;
	//分页信息
	private PageBean<SaleVisit> page;
	//当前页数
	private int pageNumber=1;
	//页面大小
	private int pageSize=5;
	//客户信息列表
	private List<Customer>customers;
	//拜访记录
	SaleVisit saleVisit;
	//条件查询中的拜访开始时间
	private String fromTime;
	//条件查询中的拜访结束时间
	private String toTime;
	/**
	 * 条件分页查询所有拜访记录
	 * @return
	 */
	public String findAll(){
		//调用service查询所有客户信息
		customers = customerService.findAll();
		//创建detachedCriteria对象
		DetachedCriteria  detachedCriteria = DetachedCriteria.forClass(SaleVisit.class);
		//设置条件
		System.out.println("fromTime:"+fromTime);
		System.out.println("toTime:"+toTime);
		if(saleVisit!=null){
			System.out.println(saleVisit.getCustomer().getCust_id());
			if(saleVisit.getCustomer().getCust_id()!=0){
				detachedCriteria.add(Restrictions.eq("customer.cust_id",saleVisit.getCustomer().getCust_id() ));
			}
		}
		if(null!=fromTime&&!"".equals(fromTime)){
			detachedCriteria.add(Restrictions.ge("visit_time", fromTime));
		}
		if(null!=toTime&&!"".equals(toTime)){
			detachedCriteria.add(Restrictions.le("visit_time", toTime));
		}
		//调用service查询
		page = saleVisitService.findAll(detachedCriteria,pageNumber,pageSize);
		return "list";
	}
	/**
	 * 先查询所有客户信息
	 * 跳转到添加页面
	 * @return
	 */
	public String addUI(){
		//调用service查询所有客户信息
		customers = customerService.findAll();
		return "addUI";
	}
	
	/**
	 * 保存拜访记录
	 * @return
	 */
	public String add(){
		//调用service保存拜访记录
		saleVisitService.add(saleVisit);
		
		return "listJsp";
	}
	/**
	 * 先查询所有客户信息和拜访记录信息
	 * 跳转到编辑页面
	 * @return
	 */
	public String edit(){
		//调用service查询拜访记录
		saleVisit = saleVisitService.findById(saleVisit.getVisit_id());
		//调用service查询所有客户信息
		customers = customerService.findAll();
		return "edit";
	}
	/**
	 * 更新拜访记录
	 * @return
	 */
	public String update(){
		//调用service更新拜访记录
		saleVisitService.update(saleVisit);
		return "listJsp";
	}
	
	/**
	 * 删除拜访记录
	 * @return
	 */
	public String delete(){
		//调用service更新拜访记录
		saleVisitService.delete(saleVisit.getVisit_id());
		return "listJsp";
	}
	
	public SaleVisitService getSaleVisitService() {
		return saleVisitService;
	}

	public void setSaleVisitService(SaleVisitService saleVisitService) {
		this.saleVisitService = saleVisitService;
	}
	public PageBean<SaleVisit> getPage() {
		return page;
	}
	public void setPage(PageBean<SaleVisit> page) {
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
	public CustomerService getCustomerService() {
		return customerService;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	public SaleVisit getSaleVisit() {
		return saleVisit;
	}
	public void setSaleVisit(SaleVisit saleVisit) {
		this.saleVisit = saleVisit;
	}
	public String getFromTime() {
		return fromTime;
	}
	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}
	public String getToTime() {
		return toTime;
	}
	public void setToTime(String toTime) {
		this.toTime = toTime;
	}
	
}
