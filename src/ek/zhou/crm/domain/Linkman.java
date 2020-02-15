package ek.zhou.crm.domain;
/**
 * 联系人实体
 * @author lhm
 *
 */
public class Linkman {
private int lkm_id;				//联系人id
private String lkm_name;		//联系人姓名
private String lkm_gender;		//联系人性别
private String lkm_phone;		//联系人办公电话
private String lkm_mobile;		//联系人手机
private String lkm_qq;			//联系人QQ
private String lkm_email;		//联系人邮箱
private String lkm_position;	//联系人职位
private String lkm_memo;		//联系人备注
//联系人所属客户
private Customer customer;

public Linkman() {
	// TODO Auto-generated constructor stub
}
public int getLkm_id() {
	return lkm_id;
}
public void setLkm_id(int lkm_id) {
	this.lkm_id = lkm_id;
}
public String getLkm_name() {
	return lkm_name;
}
public void setLkm_name(String lkm_name) {
	this.lkm_name = lkm_name;
}
public String getLkm_gender() {
	return lkm_gender;
}
public void setLkm_gender(String lkm_gender) {
	this.lkm_gender = lkm_gender;
}
public String getLkm_phone() {
	return lkm_phone;
}
public void setLkm_phone(String lkm_phone) {
	this.lkm_phone = lkm_phone;
}
public String getLkm_mobile() {
	return lkm_mobile;
}
public void setLkm_mobile(String lkm_mobile) {
	this.lkm_mobile = lkm_mobile;
}
public String getLkm_qq() {
	return lkm_qq;
}
public void setLkm_qq(String lkm_qq) {
	this.lkm_qq = lkm_qq;
}
public String getLkm_email() {
	return lkm_email;
}
public void setLkm_email(String lkm_email) {
	this.lkm_email = lkm_email;
}
public String getLkm_position() {
	return lkm_position;
}
public void setLkm_position(String lkm_position) {
	this.lkm_position = lkm_position;
}
public String getLkm_memo() {
	return lkm_memo;
}
public void setLkm_memo(String lkm_memo) {
	this.lkm_memo = lkm_memo;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
@Override
public String toString() {
	return "Linkman [lkm_id=" + lkm_id + ", lkm_name=" + lkm_name + ", lkm_gender=" + lkm_gender + ", lkm_phone="
			+ lkm_phone + ", lkm_mobile=" + lkm_mobile + ", lkm_qq=" + lkm_qq + ", lkm_email=" + lkm_email
			+ ", lkm_position=" + lkm_position + ", lkm_memo=" + lkm_memo + ", customer=" + customer + "]";
}



}
