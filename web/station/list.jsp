<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="bean.Station" %>
<%@ page import="utils.PageBean" %>
<%@ page import="bean.Depart"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Dream</title>
	<!-- Bootstrap Styles-->
	<link href="${pageContext.request.contextPath}/static/new/css/bootstrap.css" rel="stylesheet" />
	<!-- FontAwesome Styles-->
	<link href="${pageContext.request.contextPath}/static/new/css/font-awesome.css" rel="stylesheet" />
	<!-- Morris Chart Styles-->

	<!-- Custom Styles-->
	<link href="${pageContext.request.contextPath}/static/new/css/custom-styles.css" rel="stylesheet" />
	<!-- Google Fonts-->
	<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
	<!-- TABLE STYLES-->
	<link href="${pageContext.request.contextPath}/static/new/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
</head>
<body>
<div id="wrapper">
	<jsp:include page="${pageContext.request.contextPath}/commons/nav.jsp">
		<jsp:param value="station-list" name="active"/>
	</jsp:include>
	<div id="page-wrapper" >
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<h1 class="page-header">
						岗位管理 <small>岗位详情</small>
					</h1>
				</div>
			</div>
			<!-- /. ROW  -->

			<div class="row">
				<div class="col-md-12">
					<!-- Advanced Tables -->
					<div class="panel panel-default">
						<div class="panel-heading">
							了解部门下岗位详情
						</div>
						<div class="panel-body">
							<div>
								<form action="${pageContext.request.contextPath }/station/list" method="get">
									<div class="form-group">
										<label>Selects</label>
										<select id="se" class="form-control">
											<option>请选择部门</option>
										<c:choose>
											<c:when test="${not empty requestScope.departs}">
												<c:forEach var="dep" items="${requestScope.departs}" varStatus="vs">
													<option onclick="location='${pageContext.request.contextPath }/station/list?depart=${dep.id}'"  <c:if test="${requestScope.depart==dep.id}"> selected="selected"</c:if>> ${dep.departName} </option>
												</c:forEach>
											</c:when>
										</c:choose>
										</select>
									</div>
								</form>
							</div>
							<table class="table table-striped table-sm">
								<thead>
								<tr>
									<th>岗位号</th>
									<th>岗位名</th>
									<th>岗位人数</th>
								</tr>
								</thead>
								<tbody>
								<%
									PageBean pageBean = (PageBean) request.getAttribute("page");
									if(pageBean!=null){
										LinkedList<Station> pageData = pageBean.getPageData();
										for(Station l:pageData){
											out.println("<tr>");
											out.println("<td>"+l.getId()+"</td>");
											out.println("<td>"+l.getStationName()+"</td>");
											out.println("<td>"+l.getCount()+"</td>");
											out.println("</tr>");
										}
									}
								%>
								</tbody>
							</table>
							当前${requestScope.page.currentPage }/${requestScope.page.totalPage }页     &nbsp;&nbsp;

							<a href="${pageContext.request.contextPath }/station/list?depart=${requestScope.depart}&currentPage=1">首页</a>&nbsp;&nbsp;
							<a href="${pageContext.request.contextPath }/station/list?depart=${requestScope.depart}&currentPage=${requestScope.page.currentPage>1?requestScope.page.currentPage-1:1}">上一页 </a>&nbsp;&nbsp;
							<a href="${pageContext.request.contextPath }/station/list?depart=${requestScope.depart}&currentPage=${requestScope.page.currentPage<requestScope.page.totalPage?requestScope.page.currentPage+1:requestScope.page.totalPage}">下一页 </a>&nbsp;&nbsp;
							<a href="${pageContext.request.contextPath }/station/list?depart=${requestScope.depart}&currentPage=${requestScope.page.totalPage}">末页</a>&nbsp;&nbsp;
						</div>
					</div>
					<!--End Advanced Tables -->
				</div>
			</div>
			<!-- /. ROW  -->
		</div>
		<footer><p><!--Copyright &copy; All rights reserved。--> Serendipity-life</p></footer>
	</div>
	<!-- /. PAGE INNER  -->
</div>
<!-- /. PAGE WRAPPER  -->
<!-- /. WRAPPER  -->
<!-- JS Scripts-->
<!-- jQuery Js -->
<script src="${pageContext.request.contextPath}/static/new/js/jquery-1.10.2.js"></script>
<!-- Bootstrap Js -->
<script src="${pageContext.request.contextPath}/static/new/js/bootstrap.min.js"></script>
<!-- Metis Menu Js -->
<script src="${pageContext.request.contextPath}/static/new/js/jquery.metisMenu.js"></script>
<!-- DATA TABLE SCRIPTS -->
<script src="${pageContext.request.contextPath}/static/new/js/dataTables/jquery.dataTables.js"></script>
<script src="${pageContext.request.contextPath}/static/new/js/dataTables/dataTables.bootstrap.js"></script>
<!-- Custom Js -->
<script src="${pageContext.request.contextPath}/static/new/js/custom-scripts.js"></script>


</body>
</html>
