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
    <title>员工添加</title>
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
                        员工管理 <small>员工添加</small>
                    </h1>
                </div>
            </div>


            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            添加员工信息
                        </div>
                        <c:if test="${requestScope.get('msg')!=null}">
                            <h2 class="btn btn-sm btn-danger">${requestScope.get("msg")}</h2>
                        </c:if>



                        <div class="panel-body">

                            <div class="row">

                                <form role="form" action="${pageContext.request.contextPath}/staff/add" method="post">

                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label>姓名</label>
                                            <input class="form-control" name="staffName">
                                        </div>

                                        <div class="form-group">
                                            <label>年龄</label>
                                            <input class="form-control" name="age">
                                        </div>

                                        <div class="form-group">
                                            <label for="disabledSelect-sex">性别</label>
                                            <select id="disabledSelect-sex" class="form-control" name="sex">
                                                <option value="0">男</option>
                                                <option value="1">女</option>
                                            </select>
                                        </div>

                                        <div class="form-group">
                                            <label>身份证号</label>
                                            <input class="form-control" name="idCard">
                                        </div>

                                        <div class="form-group">
                                            <label>联系方式</label>
                                            <input class="form-control" name="phoneNum">
                                        </div>
                                    </div>

                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label>工号</label>
                                            <input class="form-control" name="userName">
                                        </div>

                                        <div class="form-group">
                                            <label for="disabledSelect-depart">部门</label>
                                            <select id="disabledSelect-depart" class="form-control" name="departMent" onchange="func(this.value)">
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
                                            <label for="disabledSelect-station">岗位</label>
                                            <select id="disabledSelect-station" class="form-control" name="station">
                                                <%--<c:choose>--%>
                                                    <%--<c:when test="${not empty requestScope.stations}">--%>
                                                        <%--<c:forEach var="stations" items="${requestScope.stations}" varStatus="vs">--%>
                                                            <%--<option value="${stations.id}">${stations.stationName}</option>--%>
                                                        <%--</c:forEach>--%>
                                                    <%--</c:when>--%>
                                                <%--</c:choose>--%>
                                            </select>

                                        </div>

                                        <div class="form-group">
                                            <label>薪酬</label>
                                            <input class="form-control" name="wAges">
                                        </div>
                                        <button type="submit" class="btn btn-primary" style="margin-left: 45%;margin-top: 5%">完成</button>
                                    </div>

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
<%--<c:out value="//申明"></c:out>--%>
<%--<c:choose>--%>
    <%--<c:when test="${not empty requestScope.departs}">--%>
        <%--<c:forEach var="departs" items="${requestScope.departs}" varStatus="vs">--%>
            <%--<option value="${departs.id}">${departs.departName}</option>--%>
        <%--</c:forEach>--%>
    <%--</c:when>--%>
<%--</c:choose>--%>

<script>
    var two = document.getElementById('disabledSelect-station');
    city = [];
    //定义二级数据
    city[1] = ['经理','副经理','主管','职工'];
    city[2] = ['经理','副经理','主管','职工'];
    city[3] = ['经理','副经理','主管','职工'];
    city[4] = ['经理','副经理','主管','职工'];
    city[5] = ['经理','副经理','主管','职工'];
    city[6] = ['经理','副经理','主管','职工'];
    city[7] = ['经理','副经理','主管','职工'];
    city[8] = ['经理','副经理','主管','职工'];
    function func(m){
        two.length = 1;

        //遍历生产option选项
        for (var i = 0; i < city[m].length; i++) {

            //创建一个option 把数据存储在option
            var op = new Option(city[m][i],i+4*(m-1)+1);

            //把带有数据的option 添加到第二个select
            two.add(op);
        };
    }
</script>

</body>
</html>

