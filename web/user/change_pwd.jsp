<%--
  Created by IntelliJ IDEA.
  User: randall
  Date: 18-7-13
  Time: 下午2:55
  To change this template use File | Settings | File Templates.

  user密码修改
    使其一半 左右表格 可以一试

    date:7-14 11:30 能用
    sereAlert 未能实现
    需要了解 : html页面执行顺序

--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Dream</title>
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
<c:set  var="msg" value="${requestScope.get('msg')}"/>
<%--<body onload="sereAlert(${msg})">--%>
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
                        <li><a href="${pageContext.request.contextPath}/user/change.jsp"><i class="fa fa-user fa-fw"></i>个人信息</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/user/change_pwd.jsp"><i class="fa fa-gear fa-fw"></i> 密码修改</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/logout.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
        </nav>

                <!--
                作者：865584045@qq.com
                时间：2018-07-11
                描述：侧边栏
                -->
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
                        <a href="table.html"><i class="fa fa-table"></i>报表</a>
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
                <!--
                作者：865584045@qq.com
                时间：2018-07-11
                描述：center
                -->


            <div id="page-wrapper" >
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">
                        修改密码 <small> 更改您的登录密码</small>
                    </h1>
                </div>
            </div>
            <!-- /. ROW  -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">

                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">


                                    <c:if test="${msg!=null}">
                                       <p ><c:out value="${msg}"/></p>
                                    </c:if>
                                    <form role="form" action="${pageContext.request.contextPath}/user/change_pwd" method="post">
                                        <div class="form-group">
                                            <label>原密码</label>
                                            <input class="form-control" type="password" id="oldPwd" required>
                                            <p class="help-block"></p>


                                        </div>
                                        <div class="form-group">
                                            <label>新密码</label>
                                            <input class="form-control" id="newPwd1" type="password" onchange="pwdMeet1()" required>
                                            <p id="meet1"></p>

                                        </div>

                                        <div class="form-group">
                                            <label>再次输入新密码</label>
                                            <input class="form-control" name="pwd" id="newPwd2" type="password" onchange="pwdMeet2()" required>
                                            <p id="meet2"></p>

                                        </div>
                                        <div style="margin-left: 37%">
                                        <button type="submit" value="submit"  class="btn btn-default">修改</button>
                                        <button type="reset"  value="reset"  class="btn btn-default">重置</button>
                                        </div>
                                    </form>
                                </div>
                                <!-- /.col-lg-6 (nested) -->

                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <footer><p><!--Copyright &copy; All rights reserved。--> Serendipity-life</p></footer>
        </div>
        <!-- /. PAGE INNER  -->
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

<script src="${pageContext.request.contextPath}/static/new/js/userAform/change_pwd.js"></script>


</body>
</html>
