<%--
  Created by IntelliJ IDEA.
  User: bzy
  Date: 18-7-12
  Time: 下午10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="bean.Staff" %>
<%@ page import="utils.PageBean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Dream</title>
    <%--引入css文件--%>

    <link href="${pageContext.request.contextPath}/static/new/css/bootstrap.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/static/new/css/font-awesome.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/static/new/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/static/new/css/custom-styles.css" rel="stylesheet" />
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'/>
</head>
<body>
<div id="wrapper">
    <jsp:include page="${pageContext.request.contextPath}/commons/nav.jsp">
        <jsp:param value="report" name="active"/>
    </jsp:include>
<form action="${pageContext.request.contextPath}/record/report" method="post">
    <div id="page-wrapper" >
        <div id="page-inner">
            <%--头--%>
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">
                        人事月报 <small>详细报表信息</small>
                    </h1>
                </div>
            </div>
                <div class="col-lg-6">
                    <%--<form role="form">--%>
                    <div class="form-group">
                        <label for="disabledSelect-month">月份</label>
                        <select id="disabledSelect-month" name="date" class="form-control">
                            <option value="1" <c:if test="${requestScope.date==1}"> selected="selected"</c:if>>一月</option>
                            <option value="2" <c:if test="${requestScope.date==2}"> selected="selected"</c:if>>二月</option>
                            <option value="3" <c:if test="${requestScope.date==3}"> selected="selected"</c:if>>三月</option>
                            <option value="4" <c:if test="${requestScope.date==4}"> selected="selected"</c:if>>四月</option>
                            <option value="5" <c:if test="${requestScope.date==5}"> selected="selected"</c:if>>五月</option>
                            <option value="6" <c:if test="${requestScope.date==6}"> selected="selected"</c:if>>六月</option>
                        </select>
                    </div>
                </div>
                <div class="col-lg-6">
                    <%--<form role="form">--%>
                    <div class="form-group">
                        <button type="submit" class="btn btn-default" style="margin-top: 25px;margin-bottom: 20px">查询</button>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                部门绩效及考勤
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>部门</th>
                                            <th>平均绩效</th>
                                            <th>平均考勤</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                            <c:choose>
                                                <c:when test="${not empty requestScope.a1}">
                                                    <c:forEach var="performance" items="${requestScope.a1}" varStatus="vs">
                                                    <tr>
                                                        <td>${vs.count}</td>
                                                        <td>${performance.departName}</td>
                                                        <td>${performance.avgScore}</td>
                                                        <td>${performance.avgPresent}</td>
                                                    </tr>
                                                    </c:forEach>
                                                </c:when>
                                            </c:choose>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                部门年龄结构
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>部门</th>
                                            <th>平均年龄</th>
                                            <th>在职人数</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:choose>
                                            <c:when test="${not empty requestScope.a10}">
                                                <c:forEach var="performance" items="${requestScope.a10}" varStatus="vs">
                                                    <tr>
                                                        <td>${vs.count}</td>
                                                        <td>${performance.departName}</td>
                                                        <td>${performance.avgAge}</td>
                                                        <td>${performance.zNum}</td>
                                                    </tr>
                                                </c:forEach>
                                            </c:when>
                                        </c:choose>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


        </div>
        <footer><p></p></footer>
    </div>
</form>
</div>

<%--引入js文件--%>
<script src="${pageContext.request.contextPath}/static/new/js/jquery-1.10.2.js"></script>
<script src="${pageContext.request.contextPath}/static/new/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/new/js/jquery.metisMenu.js"></script>
<script src="${pageContext.request.contextPath}/static/new/js/custom-scripts.js"></script>


</body>
</html>

