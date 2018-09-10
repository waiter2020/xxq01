<%--
  Created by IntelliJ IDEA.
  User: bzy
  Date: 18-7-13
  Time: 下午2:47
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
    <title>员工调动</title>
    <%--引入css文件--%>

    <link href="${pageContext.request.contextPath}/static/new/css/bootstrap.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/static/new/css/font-awesome.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/static/new/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/static/new/css/custom-styles.css" rel="stylesheet" />
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'/>
</head>
<body>
<div id="wrapper">
    <jsp:include page="/commons/nav.jsp">
        <jsp:param value="staff-list" name="active"/>
    </jsp:include>

    <div id="page-wrapper" >
        <div id="page-inner">
            <%--头--%>
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">
                        员工管理 <small>员工调动</small>
                    </h1>
                </div>
            </div>


            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            员工调动操作
                        </div>
                        <c:if test="${requestScope.get('msg')!=null}">
                            <h2 class="btn btn-sm btn-danger">${requestScope.get("msg")}</h2>
                        </c:if>


                        <div class="panel-body">
                            <div class="row">
                                <form action="${pageContext.request.contextPath}/staff/transfer" method="post">
                                <div class="col-lg-6">
                                    <%--<form role="form">--%>
                                    <input name="mark" type="hidden" value="3"/>
                                    <input name="id" type="hidden" value="${staff.id}"/>
                                        <div class="form-group">
                                            <label for="disabledInput-depart">原部门</label>
                                            <input class="form-control" id="disabledInput-depart" type="text"  placeholder="${staff.departMent.departName}" disabled="">
                                        </div>
                                        <div class="form-group">
                                            <label for="disabledInput-station">原职位</label>
                                            <input class="form-control" id="disabledInput-station" type="text" placeholder="${staff.station.stationName}" disabled="">
                                        </div>

                                    <%--</form>--%>
                                </div>

                                <div class="col-lg-6">
                                    <%--<form role="form">--%>
                                        <div class="form-group">
                                            <label for="disabledSelect-depart1">新部门</label>
                                            <select id="disabledSelect-depart1" name="resDepart" class="form-control">
                                                <c:choose>
                                                    <c:when test="${not empty requestScope.departs}">
                                                        <c:forEach var="departs" items="${requestScope.departs}" varStatus="vs">
                                                            <option value="${departs.id}">${departs.departName}</option>
                                                        </c:forEach>
                                                    </c:when>
                                                </c:choose>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="disabledSelect-position1">新职位</label>
                                            <select id="disabledSelect-position1" name="resStation" class="form-control">
                                                <c:choose>
                                                    <c:when test="${not empty requestScope.stations}">
                                                        <c:forEach var="stations" items="${requestScope.stations}" varStatus="vs">
                                                            <option value="${stations.id}">${stations.stationName}</option>
                                                        </c:forEach>
                                                    </c:when>
                                                </c:choose>
                                            </select>
                                        </div>


                                    <%--</form>--%>
                                </div>
                                <button type="submit"

                                        class="btn btn-primary"
                                        style="height: 30px;margin-left: 48%">调动
                                </button>
                                </form>
                            </div>
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

