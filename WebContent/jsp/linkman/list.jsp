<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>联系人列表</TITLE> 
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
</SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id="customerForm" name="customerForm"
		action="${pageContext.request.contextPath }/findAllLinkman.action"
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
					<TD width=15 background="${pageContext.request.contextPath }/images/new_022.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：联系人管理 &gt; 联系人列表</TD>
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
													<TD>联系人名称：</TD>
													<TD>
														<INPUT class=textbox id=sChannel2
															style="WIDTH: 80px" maxLength=50 name="linkman.lkm_name" value="${linkman.lkm_name }">
													</TD>
													<TD>联系人性别：</TD>
													<TD>
														<s:select list="{'男','女'}" value="linkman.lkm_gender" name="linkman.lkm_gender" theme="simple" headerKey=""  headerValue="--请选择--"></s:select>
													</TD>
													
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
													<TD>联系人名称</TD>
													<TD>性别</TD>
													<TD>办公电话</TD>
													<TD>手机</TD>
													<TD>邮箱</TD>
													<TD>QQ</TD>
													<TD>职位</TD>
													<TD>备注</TD>
													<TD>客户名字</TD>
													<TD>操作</TD>
												</TR>
												<s:iterator value="page.data" var="l">
												
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<TD>${l.lkm_name }</TD>
													<TD>${l.lkm_gender }</TD>
													<TD>${l.lkm_phone }</TD>
													<TD>${l.lkm_mobile }</TD>
													<TD>${l.lkm_email }</TD>
													<TD>${l.lkm_qq }</TD>
													<TD>${l.lkm_position }</TD>
													<TD>${l.lkm_memo }</TD>
													<TD>${l.customer.cust_name }</TD>
													<TD>
													<a href="${pageContext.request.contextPath }/editLinkman.action?linkman.lkm_id=${l.lkm_id}">修改</a>
													&nbsp;&nbsp;
													<a href="${pageContext.request.contextPath }/deleteLinkman?linkman.lkm_id=${l.lkm_id}">删除</a>
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
