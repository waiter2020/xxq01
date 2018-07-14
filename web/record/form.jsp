<%--
  Created by IntelliJ IDEA.
  User: randall
  Date: 18-7-13
  Time: 下午2:55
  To change this template use File | Settings | File Templates.

  报表页面
  实现 入职 离职 岗位调动 部门调动的合一
  以 三级联动进行 选择
  三级联动 在 hucc.js
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>人事报表</title>
    <!-- Bootstrap Styles-->
    <link href="${pageContext.request.contextPath}/static/new/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="${pageContext.request.contextPath}/static/new/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="${pageContext.request.contextPath}/static/new/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />

    <link href="${pageContext.request.contextPath}/static/css/hucc.css" rel="stylesheet" />

</head>
<body>
<div id="wrapper">



    <!--
作者：865584045@qq.com
时间：2018-07-11
描述：上边栏
-->
    <nav class="navbar navbar-default top-navbar" role="navigation">
        <div class="navbar-header">
            <a class="navbar-brand" href="personal.jsp">Ranlly</a>
        </div>

        <ul class="nav navbar-top-links navbar-right">

            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                    <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="personal.html"><i class="fa fa-user fa-fw"></i>个人信息</a>
                    </li>
                    <li><a href="change_pwd.jsp"><i class="fa fa-gear fa-fw"></i>密码修改</a>
                    </li>
                    <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i>LOGOUT</a>
                    </li>
                </ul>
                <!-- /.dropdown-user -->
            </li>
            <!-- /.dropdown -->
        </ul>
    </nav>


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
                    <a href="table.html" class="active-menu"><i class="fa fa-table"></i>报表</a>
                </li>
                <li>
                    <a href="form.html"><i class="fa fa-edit"></i> Forms </a>
                </li>


                <li>
                    <a href="#"><i class="fa fa-sitemap"></i> 信息变更<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="#">员工管理</a>
                        </li>
                        <li>
                            <a href="#">部门管理</a>
                        </li>
                        <li>
                            <a href="#">岗位管理</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="personal.html"><i class="fa fa-fw fa-file"></i> 个人信息</a>
                </li>
            </ul>

        </div>

    </nav>



    <div id="page-wrapper" >
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">
                        人事报表 <small>根据类型及时间查询</small>
                    </h1>
                </div>
            </div>


            <div class="row">
                <div class="col-md-12">

                    <div class="panel panel-default">

                        <form action="#"  >
                            <div class="form-group" style="margin-left: 45%; margin:20px 33px auto 60px">
                                <label>报表类型:</label>
                                <select id="searchType" onchange="linkage(this.value)">
                                    <option>--请选择--</option>
                                    <option value="0">入职报表</option>
                                    <option value="1">离职报表</option>
                                    <option value="2">部门异动</option>
                                    <option value="3">岗位移动</option>

                                </select>
                                <label>详细查询:</label>
                                <select id="search1" >
                                    <option>--请选择--</option>
                                </select>


                                <select id="search2" >
                                    <option>--请选择--</option>
                                </select>
                            </div>

                            <div style="margin-left: 30%">
                                <label>开始时间:</label>
                                <input type="date" id="time-b" min="2010-10-01" >
                                <label>结束时间:</label>
                                <input type="date" id="time-e" min="2010-10-01" max="2020-1-1">
                            </div>

                            <div style="margin-left: 46%">
                                <button type="submit" class="btn btn-default">查找</button>
                            </div>
                        </form>

                        <div class="panel-heading" >
                            报表
                        </div>

                        <div class="panel-body">
                            <table class="table table-striped table-sm">
                                <thead>
                                <tr>
                                    <th>工号</th>
                                    <th>姓名</th>
                                    <th>电话</th>
                                    <th>部门</th>
                                    <th>岗位</th>

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
                                                <td>${staff.department.departName}</td>
                                                <td>${staff.station.stationName}</td>
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
                            当前${requestScope.page.currentPage }/${requestScope.page.totalPage }页     &nbsp;&nbsp;

                            <a href="${pageContext.request.contextPath }/staff/list?currentPage=1">首页</a>&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/staff/list?currentPage=${requestScope.page.currentPage>1?requestScope.page.currentPage-1:1}">上一页 </a>&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/staff/list?currentPage=${requestScope.page.currentPage<requestScope.page.totalPage?requestScope.page.currentPage+1:requestScope.page.totalPage}">下一页 </a>&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/staff/list?currentPage=${requestScope.page.totalPage}">末页</a>&nbsp;&nbsp;

                        </div>
                    </div>

                </div>
            </div>

        </div>
        <footer><p></p></footer>
    </div>


</div>








<!-- /. WRAPPER  -->
<!-- JS Scripts-->
<!-- jQuery Js -->
<script src="${pageContext.request.contextPath}/static/new/js/jquery-1.10.2.js"></script>
<!-- Bootstrap Js -->
<script src="${pageContext.request.contextPath}/static/new/js/bootstrap.min.js"></script>
<!-- Metis Menu Js -->
<script src="${pageContext.request.contextPath}/static/new/js/jquery.metisMenu.js"></script>
<!-- Custom Js -->
<script src="${pageContext.request.contextPath}/static/new/js/custom-scripts.js"></script>
<!--hucc js -->
<script src="${pageContext.request.contextPath}/static/new/js/userAform/hucc.js"></script>


</body>
</html>
