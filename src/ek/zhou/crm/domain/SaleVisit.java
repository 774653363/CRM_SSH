package ek.zhou.crm.domain;

import java.util.Date;

/**
 * 客户拜访记录实体
 * @author lhm
 *
 */
public class SaleVisit {
private String visit_id;//主键id
private String visit_time;//拜访时间
private String visit_addr;//拜访地址
private String visit_detail;//拜访详情
private String visit_nexttime;//下次拜访时间
private Customer customer;//客户
private User user;//业务员
public SaleVisit() {
	// TODO Auto-generated constructor stub
}
public String getVisit_id() {
	return visit_id;
}
public void setVisit_id(String visit_id) {
	this.visit_id = visit_id;
}
public String getVisit_time() {
	return visit_time;
}
public void setVisit_time(String visit_time) {
	this.visit_time = visit_time;
}
public String getVisit_addr() {
	return visit_addr;
}
public void setVisit_addr(String visit_addr) {
	this.visit_addr = visit_addr;
}
public String getVisit_detail() {
	return visit_detail;
}
public void setVisit_detail(String visit_detail) {
	this.visit_detail = visit_detail;
}
public String getVisit_nexttime() {
	return visit_nexttime;
}
public void setVisit_nexttime(String visit_nexttime) {
	this.visit_nexttime = visit_nexttime;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

}
