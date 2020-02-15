package ek.zhou.crm.web.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import ek.zhou.crm.domain.Customer;
import ek.zhou.crm.service.CustomerService;
import ek.zhou.crm.utils.PageBean;
import ek.zhou.crm.utils.UUIDUtils;

public class CustomerAction extends ActionSupport{
	//struts2的文件上传需要在Action提供三个属性
	private File upload;//上传的文件
	private String uploadFileName;//上传文件名
	private String uploadContentType;//上传文件类型
	//注入Service
	private CustomerService customerService;
	//Customer对象
	private Customer customer;
	//Customer列表
	private PageBean<Customer> page;
	//当前页数
	int pageNumber = 1;
	//分页大小
	int pageSize = 5;
	/**
	 * 分页查询客户数据
	 * @return
	 */
	public String findAll(){
		
		//封装离线条件查询对象
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		//设置条件
		if(null!=customer){
				if(null!=customer.getCust_name()&&!"".equals(customer.getCust_name())){
					System.out.println("cust_name:"+customer.getCust_name());
				detachedCriteria.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
				}
			
				if(null!=customer.getCust_level()){
					if(null!=customer.getCust_level().getDict_id()&&!"".equals(customer.getCust_level().getDict_id())){
						detachedCriteria.add(Restrictions.eq("cust_level.dict_id", customer.getCust_level().getDict_id()));
					}
				}
				if(null!=customer.getCust_industry()){
					if(null!=customer.getCust_industry().getDict_id()&&!"".equals(customer.getCust_industry().getDict_id())){
						detachedCriteria.add(Restrictions.eq("cust_industry.dict_id", customer.getCust_industry().getDict_id()));
					}
				}
				if(null!=customer.getCust_source()){
					if(null!=customer.getCust_source().getDict_id()&&!"".equals(customer.getCust_source().getDict_id())){
						detachedCriteria.add(Restrictions.eq("cust_source.dict_id", customer.getCust_source().getDict_id()));
					}
				}
		}
		//调用业务层查询
		page = customerService.findAll(detachedCriteria,pageNumber,pageSize);
		return "list";
	}
	/**
	 * 跳转到添加页面
	 * @return
	 */
	public String addUI(){
		return "addUI";
	}
	/**
	 * 添加客户
	 * @return
	 * @throws IOException 
	 */
	public String add() throws IOException{
		if(upload!=null){
			//完成文件上传
			String uuidFileName = UUIDUtils.getUUID()+uploadFileName.substring(uploadFileName.lastIndexOf("."));
			String path=ServletActionContext.getServletContext().getRealPath("customer/images")+"/"+uuidFileName;
			File destFile = new File(path);
			FileUtils.copyFile(upload, destFile);
			System.out.println(path);
			customer.setCust_image("customer/images/"+uuidFileName);
		}
		//调用业务层保存
		customerService.add(customer);
		return "listJsp";
	}
	/**
	 * 删除客户
	 * @return
	 */
	public String delete(){
		//调用业务层删除
		customerService.delete(customer.getCust_id());
		return "listJsp";
	}
	/**
	 * 查询客户并跳转到编辑页面
	 * @return
	 */
	public String edit(){
		//调用业务层查询客户
		customer = customerService.findById(customer.getCust_id());
		return "edit";
	}
	/**
	 * 更新客户
	 * @return
	 * @throws IOException 
	 */
	public String update() throws IOException{
		if(upload!=null){
			//删除原文件
			String oldPath=ServletActionContext.getServletContext().getRealPath("/")+"/"+customer.getCust_image();
			File oldFile = new File(oldPath);
			System.out.println("oldPath"+oldPath);
			if(oldFile.exists()){
				oldFile.delete();
			}
			//完成文件上传
			String uuidFileName = UUIDUtils.getUUID()+uploadFileName.substring(uploadFileName.lastIndexOf("."));
			String path=ServletActionContext.getServletContext().getRealPath("customer/images")+"/"+uuidFileName;
			File destFile = new File(path);
			System.out.println(path);
			FileUtils.copyFile(upload, destFile);
			customer.setCust_image("customer/images/"+uuidFileName);
		}
		//调用业务层更新客户
		customerService.update(customer);
		return "listJsp";
	}
	
	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}



	public PageBean<Customer> getPage() {
		return page;
	}

	public void setPage(PageBean<Customer> page) {
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
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	
}
