<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!-- saved from url=(0052)http://getbootstrap.com/docs/4.0/examples/dashboard/ -->
<html lang="en" >

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">

		<title>Dashboard Template for Bootstrap</title>
		<!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/static/css/dashboard.css" rel="stylesheet">
		<style type="text/css">
			/* Chart.js */
			
			@-webkit-keyframes chartjs-render-animation {
				from {
					opacity: 0.99
				}
				to {
					opacity: 1
				}
			}
			
			@keyframes chartjs-render-animation {
				from {
					opacity: 0.99
				}
				to {
					opacity: 1
				}
			}
			
			.chartjs-render-monitor {
				-webkit-animation: chartjs-render-animation 0.001s;
				animation: chartjs-render-animation 0.001s;
			}
		</style>
	</head>

	<body>
	<!--引入抽取的topbar-->
	<jsp:include page="${pageContext.request.contextPath}/commons/bar.jsp">
		<jsp:param value="staff" name="activeUri"/>
		<jsp:param name="title" value="添加员工"/>
	</jsp:include>
		<div class="container-fluid">
			<div class="row">
				<!--引入侧边栏-->

				<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
					<!--需要区分是员工修改还是添加；-->
					<form action="#" method="post">

						<div class="form-group">
							<label>LastName</label>
							<input name="lastName" type="text" class="form-control" placeholder="zhangsan" ">
						</div>
						<div class="form-group">
							<label>Email</label>
							<input name="email" type="email" class="form-control" placeholder="zhangsan@atguigu.com" ">
						</div>
						<div class="form-group">
							<label>Gender</label><br/>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="gender" value="1" ">
								<label class="form-check-label">男</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="gender" value="0" >
								<label class="form-check-label">女</label>
							</div>
						</div>
						<div class="form-group">
							<label>department</label>
							<!--提交的是部门的id-->
							<select class="form-control" name="department.id">
								<option >1</option>
							</select>
						</div>
						<div class="form-group">
							<label>Birth</label>
							<input name="birth" type="text" class="form-control" placeholder="zhangsan" >
						</div>
						<button type="submit" class="btn btn-primary" >添加</button>
					</form>
				</main>
			</div>
		</div>

		<!-- Bootstrap core JavaScript
    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
        <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.slim.min.js"></script>
        <script type="text/javascript"  src="${pageContext.request.contextPath}/static/js/popper.min.js"></script>
        <script type="text/javascript"  src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>

        <!-- Icons -->
        <script type="text/javascript"  src="${pageContext.request.contextPath}/static/js/feather.min.js"></script>

		<script>
			feather.replace()
		</script>

	</body>

</html>