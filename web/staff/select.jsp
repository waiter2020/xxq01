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
        <jsp:param value="staff-list" name="active"/>
    </jsp:include>

    <div id="page-wrapper" >
        <div id="page-inner">
            <%--头--%>
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">
                        员工管理 <small>员工查询</small>
                    </h1>
                </div>
            </div>


            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            查询员工信息
                        </div>
                        <c:if test="${requestScope.get('msg')!=null}">
                            <h2 class="btn btn-sm btn-danger">${requestScope.get("msg")}</h2>
                        </c:if>

                        <div class="panel-body">
                            <div class="row">
                                <form action="${pageContext.request.contextPath}/staff/select" method="get">
                                    <div class="col-lg-6">

                                        <div class="form-group">
                                            <label for="disabledSelect-op">查询类型</label>
                                            <select id="disabledSelect-op" name="op" class="form-control">
                                                <option value="1">工号</option>
                                                <option value="2">姓名</option>
                                                <option value="3">部门</option>
                                                <option value="4">薪酬（高于）</option>
                                                <option value="5">薪酬（低于）</option>
                                            </select>
                                        </div>

                                    </div>

                                    <div class="col-lg-6">
                                        <label for="disabledSelect-op">查询条件</label>
                                        <div class="form-group input-group">
                                            <input type="text" class="form-control" name="condition">
                                            <span class="input-group-btn">
                                                <button class="btn btn-default" type="submit">
                                                     <i class="fa fa-search"></i>
                                                 </button>
                                            </span>
                                        </div>


                                    </div>

                                </form>
                            </div>
                        </div>

                        <div class="panel-body">
                            <table class="table table-striped table-sm">
                                <thead>
                                <tr>
                                    <th>工号</th>
                                    <th>姓名</th>
                                    <th>联系方式</th>
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
                                                <td><a href="${pageContext.request.contextPath}/staff/change?id=${staff.id}">${staff.userName }</a></td>
                                                <td>${staff.staffName }</td>
                                                <td>${staff.phoneNum}</td>
                                                <td>${staff.sex==0?'男':'女'}</td>
                                                <td>${staff.age}</td>
                                                <td>${staff.idCard}</td>
                                                <td>${staff.department.departName}</td>
                                                <td>${staff.station.stationName}</td>
                                                <td>${staff.wAges}</td>
                                            </tr>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <tr>
                                            <c:if test="${requestScope.page!=null}">
                                            <td colspan="3">对不起，没有你要找的数据</td>
                                            </c:if>
                                        </tr>
                                    </c:otherwise>
                                </c:choose>

                                </tbody>
                            </table>
                            当前${requestScope.page.currentPage }/${requestScope.page.totalPage }页     &nbsp;&nbsp;

                            <a href="${pageContext.request.contextPath }/staff/select?currentPage=1">首页</a>&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/staff/select?currentPage=${requestScope.page.currentPage>1?requestScope.page.currentPage-1:1}">上一页 </a>&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/staff/select?currentPage=${requestScope.page.currentPage<requestScope.page.totalPage?requestScope.page.currentPage+1:requestScope.page.totalPage}">下一页 </a>&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/staff/select?currentPage=${requestScope.page.totalPage}">末页</a>&nbsp;&nbsp;
                        </div>

                    </div>

                </div>
            </div>

        </div>
        <footer><p></p></footer>
    </div>

</div>

<%--引入js文件--%>
<script src="${pageContext.request.contextPath}/static/new/js/jquery-1.10.2.js"></script>
<script src="${pageContext.request.contextPath}/static/new/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/new/js/jquery.metisMenu.js"></script>
<script src="${pageContext.request.contextPath}/static/new/js/custom-scripts.js"></script>


</body>
</html>