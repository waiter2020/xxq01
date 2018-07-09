<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- saved from url=(0052)http://getbootstrap.com/docs/4.0/examples/dashboard/ -->
<html lang="en" xmlns:th="http://www.thymeleaf.org">

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
            <jsp:param value="emp" name="activeUri"/>
            <jsp:param name="title" value="员工列表"/>
        </jsp:include>


		<div class="container-fluid">
			<div class="row">
				<!--引入侧边栏-->


				<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
					<h2><a class="btn btn-sm btn-success" href="emp" >员工添加</a></h2>
					<div class="table-responsive">
						<table class="table table-striped table-sm">
							<thead>
								<tr>
									<th>#</th>
									<th>lastName</th>
									<th>email</th>
									<th>gender</th>
									<th>department</th>
									<th>birth</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<%--<tr th:each="emp:${emps}">--%>
									<%--<td th:text="${emp.id}"></td>--%>
									<%--<td>[[${emp.lastName}]]</td>--%>
									<%--<td th:text="${emp.email}"></td>--%>
									<%--<td th:text="${emp.gender}==0?'女':'男'"></td>--%>
									<%--<td th:text="${emp.department.departmentName}"></td>--%>
									<%--<td th:text="${#dates.format(emp.birth, 'yyyy-MM-dd HH:mm')}"></td>--%>
									<%--<td>--%>
										<%--<a class="btn btn-sm btn-primary" th:href="@{/emp/}+${emp.id}">编辑</a>--%>
										<%--<button th:attr="del_uri=@{/emp/}+${emp.id}" class="btn btn-sm btn-danger deleteBtn">删除</button>--%>
									<%--</td>--%>
								<%--</tr>--%>
							</tbody>
						</table>
					</div>
				</main>
				<form id="deleteEmpForm"  method="post">
					<input type="hidden" name="_method" value="delete"/>
				</form>
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
		<script>
			$(".deleteBtn").click(function(){
			    //删除当前员工的
			    $("#deleteEmpForm").attr("action",$(this).attr("del_uri")).submit();
			    return false;
            });
		</script>
	</body>
</html>