<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>客户列表</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<SCRIPT language=javascript>
	function to_page(page){
		if(page){
			$("#page").val(page);
		}
		document.customerForm.submit();
		
	}
$(function(){
		
		
		var url = "${pageContext.request.contextPath}/findByTypeCodeDictionary?dictionary.dict_type_code=001";
		var data = {};
		$.post(url,data,function(result){
			json=JSON.parse(result);
			$.each(json,function(i,n){
				$("#cust_industry").append("<option value ='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
			});
			
			$("#cust_industry option[value='${customer.cust_industry.dict_id}']").attr("selected","selected");
			
		});
		
		var url = "${pageContext.request.contextPath}/findByTypeCodeDictionary?dictionary.dict_type_code=002";
		var data = {};
		$.post(url,data,function(result){
			json=JSON.parse(result);
			$.each(json,function(i,n){
				$("#cust_source").append("<option value ='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
			});
			
			$("#cust_source option[value='${customer.cust_source.dict_id}']").attr("selected","selected");
			
		});
		
		var url = "${pageContext.request.contextPath}/findByTypeCodeDictionary?dictionary.dict_type_code=006";
		var data = {};
		$.post(url,data,function(result){
			json=JSON.parse(result);
			$.each(json,function(i,n){
				$("#cust_level").append("<option value ='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
			});
			
			$("#cust_level option[value='${customer.cust_level.dict_id}']").attr("selected","selected");
			
		});
	});

</SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<s:debug></s:debug>
	<FORM id="customerForm" name="customerForm"
		action="${pageContext.request.contextPath }/findAllCustomer.action"
		method=post>
		
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; 客户列表</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0
							width="100%" align=center border=0>
							<TBODY>
								<TR>
									<TD height=25>
										<TABLE cellSpacing=0 cellPadding=2 border=0>
											<TBODY>
												<TR>
													<TD>客户名称：</TD>
													<TD><INPUT class=textbox id=sChannel2		value="${ customer.cust_name}"
														style="WIDTH: 80px" maxLength=50 name="customer.cust_name"></TD>
													<td>客户级别 ：</td>
													<td>
													<select id="cust_level" name="customer.cust_level.dict_id" >
														<option value="">--请选择--</option>
													</select>
													
													</td>
													<td>信息来源 ：</td>
													<td>
													<select id="cust_source" name="customer.cust_source.dict_id" >
														<option value="">--请选择--</option>
													</select>
													</td>
													<td>所属行业 ：</td>
													<td>
													<select id="cust_industry" name="customer.cust_industry.dict_id" >
														<option value="">--请选择--</option>
													</select>
													</td>
								
													<TD><INPUT class=button id=sButton2 type=submit
														value=" 筛选 " name=sButton2></TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
							    
								<TR>
									<TD>
										<TABLE id=grid
											style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
											cellSpacing=1 cellPadding=2 rules=all border=0>
											<TBODY>
												<TR
													style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<TD>客户名称</TD>
													<TD>客户来源</TD>
													<TD>客户行业</TD>
													<TD>客户级别</TD>
													<TD>联系人</TD>
													<TD>电话</TD>
													<TD>手机</TD>
													<TD>操作</TD>
												</TR>
												<s:iterator var="c" value="page.data">
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<TD>${c.cust_name }</TD>
													<TD>${c.cust_source.dict_item_name }</TD>
													<TD>${c.cust_industry.dict_item_name }</TD>
													<TD>${c.cust_level.dict_item_name }</TD>
													<TD>${c.cust_linkman }</TD>
													<TD>${c.cust_phone }</TD>
													<TD>${c.cust_mobile }</TD>
													<TD>
													<a href="${pageContext.request.contextPath }/editCustomer.action?customer.cust_id=${c.cust_id}">修改</a>
													&nbsp;&nbsp;
													<a href="${pageContext.request.contextPath }/deleteCustomer.action?customer.cust_id=${c.cust_id}&pageSize=${pageSize}">删除</a>
													</TD>
												</TR>
												</s:iterator>

											</TBODY>
										</TABLE>
									</TD>
								</TR>
								
								<TR>
									<TD><SPAN id=pagelink>
											<DIV style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">
												共[<B>${page.totalRecord}</B>]条记录,[<B>${page.totalPage}</B>]页
												,每页显示
												<select name="pageSize" onchange="to_page(1)">
													<option value="5" ${page.pageSize==5 ?"selected" :""}>5</option>
													<option value="10"  ${page.pageSize==10 ?"selected" :""}>10</option>
												</select>
												条
												
												<s:if test="page.pageNumber!=1">
													[<A href="javascript:to_page(${page.pageNumber-1})">前一页</A>]
												</s:if>
												<s:bean name="org.apache.struts2.util.Counter" id="counter">
													<s:param name="first" value="1"></s:param>
													<s:param name="last" value="page.totalPage"></s:param>
													<s:iterator>
															<A href="javascript:to_page(<s:property/>)"><s:property/></A>
													</s:iterator>
												</s:bean>
												
												
												<s:if test="page.pageNumber!=page.totalPage">
													[<A href="javascript:to_page(${page.pageNumber+1})">后一页</A>] 
												</s:if>
												
												到
												<input type="text" size="3" id="page" name="pageNumber" />
												页
												
												<input type="button" value="Go" onclick="to_page()"/>
											</DIV>
									</SPAN></TD>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
