﻿
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
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

    <%--引入导航栏--%>
    <jsp:include page="${pageContext.request.contextPath}/new/top.jsp" flush="true"/>
    <%--引入侧边栏    --%>
    <jsp:include page="${pageContext.request.contextPath}/new/aside.jsp" flush="true"/>

    <div id="page-wrapper">
        <div id="page-inner">
            <%--表格标题--%>
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">
                        员工列表 <small>员工详情</small>
                    </h1>
                </div>
            </div>
            <%--操作按钮    --%>
            <div>
                <h2 style="float: left"><a class="btn btn-sm btn-success" href="${pageContext.request.contextPath}/staff/add.jsp" >添加员工</a></h2>
            </div>
            <%--表格--%>
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th>工号</th>
                        <th>姓名</th>
                        <th>电话</th>
                        <th>性别</th>
                        <th>年龄</th>
                        <th>身份证号</th>
                        <th>部门</th>
                        <th>岗位</th>
                        <th>薪酬</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:choose>
                        <c:when test="${not empty requestScope.page.pageData}">
                            <c:forEach var="staff" items="${requestScope.page.pageData}" varStatus="vs">
                                <tr>
                                    <td>${staff.userName }</td>
                                    <td>${staff.staffName }</td>
                                    <td>${staff.phoneNum}</td>
                                    <td>${staff.sex==0?'男':'女'}</td>
                                    <td>${staff.age}</td>
                                    <td>${staff.idCard}</td>
                                    <td>${staff.department.departName}</td>
                                    <td>${staff.station.stationName}</td>
                                    <td>${staff.wAges}</td>

                                    <td>
                                        <c:if test="${staff.userName !=sessionScope.get('loginInfo').userName}">
                                            <button type="button"
                                                    onclick="window.location.href='${pageContext.request.contextPath}/staff/delete?id=${staff.id}'"
                                                    href="${pageContext.request.contextPath}/staff/list/delete?id=${staff.id}"
                                                    class="btn btn-sm btn-danger ">辞退
                                            </button>

                                            <button type="button"
                                                    onclick="window.location.href='${pageContext.request.contextPath}/staff/change?id=${staff.id}'"
                                                    href="${pageContext.request.contextPath}/staff/change?id=${staff.id}"
                                                    class="btn btn-sm btn-danger">修改
                                            </button>
                                        </c:if>
                                    </td>

                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td colspan="3">对不起，没有你要找的数据</td>
                            </tr>
                        </c:otherwise>
                    </c:choose>

                    </tbody>
                </table>
                <%--页码--%>
                当前${requestScope.page.currentPage }/${requestScope.page.totalPage }页 &nbsp;&nbsp;
                <a href="${pageContext.request.contextPath }/staff/list?currentPage=1">首页</a>&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath }/staff/list?currentPage=${requestScope.page.currentPage>1?requestScope.page.currentPage-1:1}">上一页 </a>&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath }/staff/list?currentPage=${requestScope.page.currentPage<requestScope.page.totalPage?requestScope.page.currentPage+1:requestScope.page.totalPage}">下一页 </a>&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath }/staff/list?currentPage=${requestScope.page.totalPage}">末页</a>&nbsp;&nbsp;
            </div>
        </div>
    </div>
</div>


<%--引入js文件--%>
<script src="${pageContext.request.contextPath}/static/new/js/jquery-1.10.2.js"></script>
<script src="${pageContext.request.contextPath}/static/new/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/new/js/jquery.metisMenu.js"></script>
<script src="${pageContext.request.contextPath}/static/new/js/custom-scripts.js"></script>
</body>
</html>
