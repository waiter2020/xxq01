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
	<nav class="navbar navbar-default top-navbar" role="navigation">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.html">Dream</a>
		</div>

		<ul class="nav navbar-top-links navbar-right">
			<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
					<i class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
				</a>
				<ul class="dropdown-menu dropdown-messages">
					<li>
						<a href="#">
							<div>
								<strong>John Doe</strong>
								<span class="pull-right text-muted">
                                        <em>Today</em>
                                    </span>
							</div>
							<div>Lorem Ipsum has been the industry's standard dummy text ever since the 1500s...</div>
						</a>
					</li>
					<li class="divider"></li>
					<li>
						<a href="#">
							<div>
								<strong>John Smith</strong>
								<span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
							</div>
							<div>Lorem Ipsum has been the industry's standard dummy text ever since an kwilnw...</div>
						</a>
					</li>
					<li class="divider"></li>
					<li>
						<a href="#">
							<div>
								<strong>John Smith</strong>
								<span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
							</div>
							<div>Lorem Ipsum has been the industry's standard dummy text ever since the...</div>
						</a>
					</li>
					<li class="divider"></li>
					<li>
						<a class="text-center" href="#">
							<strong>Read All Messages</strong>
							<i class="fa fa-angle-right"></i>
						</a>
					</li>
				</ul>
				<!-- /.dropdown-messages -->
			</li>
			<!-- /.dropdown -->
			<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
					<i class="fa fa-tasks fa-fw"></i> <i class="fa fa-caret-down"></i>
				</a>
				<ul class="dropdown-menu dropdown-tasks">
					<li>
						<a href="#">
							<div>
								<p>
									<strong>Task 1</strong>
									<span class="pull-right text-muted">60% Complete</span>
								</p>
								<div class="progress progress-striped active">
									<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
										<span class="sr-only">60% Complete (success)</span>
									</div>
								</div>
							</div>
						</a>
					</li>
					<li class="divider"></li>
					<li>
						<a href="#">
							<div>
								<p>
									<strong>Task 2</strong>
									<span class="pull-right text-muted">28% Complete</span>
								</p>
								<div class="progress progress-striped active">
									<div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="28" aria-valuemin="0" aria-valuemax="100" style="width: 28%">
										<span class="sr-only">28% Complete</span>
									</div>
								</div>
							</div>
						</a>
					</li>
					<li class="divider"></li>
					<li>
						<a href="#">
							<div>
								<p>
									<strong>Task 3</strong>
									<span class="pull-right text-muted">60% Complete</span>
								</p>
								<div class="progress progress-striped active">
									<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
										<span class="sr-only">60% Complete (warning)</span>
									</div>
								</div>
							</div>
						</a>
					</li>
					<li class="divider"></li>
					<li>
						<a href="#">
							<div>
								<p>
									<strong>Task 4</strong>
									<span class="pull-right text-muted">85% Complete</span>
								</p>
								<div class="progress progress-striped active">
									<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="85" aria-valuemin="0" aria-valuemax="100" style="width: 85%">
										<span class="sr-only">85% Complete (danger)</span>
									</div>
								</div>
							</div>
						</a>
					</li>
					<li class="divider"></li>
					<li>
						<a class="text-center" href="#">
							<strong>See All Tasks</strong>
							<i class="fa fa-angle-right"></i>
						</a>
					</li>
				</ul>
				<!-- /.dropdown-tasks -->
			</li>
			<!-- /.dropdown -->
			<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
					<i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
				</a>
				<ul class="dropdown-menu dropdown-alerts">
					<li>
						<a href="#">
							<div>
								<i class="fa fa-comment fa-fw"></i> New Comment
								<span class="pull-right text-muted small">4 min</span>
							</div>
						</a>
					</li>
					<li class="divider"></li>
					<li>
						<a href="#">
							<div>
								<i class="fa fa-twitter fa-fw"></i> 3 New Followers
								<span class="pull-right text-muted small">12 min</span>
							</div>
						</a>
					</li>
					<li class="divider"></li>
					<li>
						<a href="#">
							<div>
								<i class="fa fa-envelope fa-fw"></i> Message Sent
								<span class="pull-right text-muted small">4 min</span>
							</div>
						</a>
					</li>
					<li class="divider"></li>
					<li>
						<a href="#">
							<div>
								<i class="fa fa-tasks fa-fw"></i> New Task
								<span class="pull-right text-muted small">4 min</span>
							</div>
						</a>
					</li>
					<li class="divider"></li>
					<li>
						<a href="#">
							<div>
								<i class="fa fa-upload fa-fw"></i> Server Rebooted
								<span class="pull-right text-muted small">4 min</span>
							</div>
						</a>
					</li>
					<li class="divider"></li>
					<li>
						<a class="text-center" href="#">
							<strong>See All Alerts</strong>
							<i class="fa fa-angle-right"></i>
						</a>
					</li>
				</ul>
				<!-- /.dropdown-alerts -->
			</li>
			<!-- /.dropdown -->
			<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
					<i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
				</a>
				<ul class="dropdown-menu dropdown-user">
					<li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
					</li>
					<li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
					</li>
					<li class="divider"></li>
					<li><a href="#"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
					</li>
				</ul>
				<!-- /.dropdown-user -->
			</li>
			<!-- /.dropdown -->
		</ul>
	</nav>
	<!--/. NAV TOP  -->
	<nav class="navbar-default navbar-side" role="navigation">
		<div class="sidebar-collapse">
			<ul class="nav" id="main-menu">

				<li>
					<a href="index.html"><i class="fa fa-dashboard"></i> Dashboard</a>
				</li>
				<li>
					<a href="ui-elements.html"><i class="fa fa-desktop"></i> UI Elements</a>
				</li>
				<li>
					<a href="chart.html"><i class="fa fa-bar-chart-o"></i> Charts</a>
				</li>
				<li>
					<a href="tab-panel.html"><i class="fa fa-qrcode"></i> Tabs & Panels</a>
				</li>

				<li>
					<a href="table.html" class="active-menu"><i class="fa fa-table"></i> Responsive Tables</a>
				</li>
				<li>
					<a href="form.html"><i class="fa fa-edit"></i> Forms </a>
				</li>


				<li>
					<a href="#"><i class="fa fa-sitemap"></i> Multi-Level Dropdown<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li>
							<a href="#">Second Level Link</a>
						</li>
						<li>
							<a href="#">Second Level Link</a>
						</li>
						<li>
							<a href="#">Second Level Link<span class="fa arrow"></span></a>
							<ul class="nav nav-third-level">
								<li>
									<a href="#">Third Level Link</a>
								</li>
								<li>
									<a href="#">Third Level Link</a>
								</li>
								<li>
									<a href="#">Third Level Link</a>
								</li>

							</ul>

						</li>
					</ul>
				</li>
				<li>
					<a href="empty.html"><i class="fa fa-fw fa-file"></i> Empty Page</a>
				</li>
			</ul>

		</div>

	</nav>
	<!-- /. NAV SIDE  -->
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
