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
    <%--导航栏--%>
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
    <%--侧边栏--%>
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
                                <form>
                                <div class="col-lg-6">
                                    <%--<form role="form">--%>
                                        <div class="form-group">
                                            <label for="disabledSelect-depart">原部门</label>
                                            <select id="disabledSelect-depart" class="form-control">
                                                <option>开发部</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="disabledSelect-position">原职位</label>
                                            <select id="disabledSelect-position" class="form-control">
                                                <option>副经理</option>
                                            </select>
                                        </div>


                                    <%--</form>--%>
                                </div>

                                <div class="col-lg-6">
                                    <%--<form role="form">--%>
                                        <div class="form-group">
                                            <label for="disabledSelect-depart1">新部门</label>
                                            <select id="disabledSelect-depart1" class="form-control">
                                                <option>人事部</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="disabledSelect-position1">新职位</label>
                                            <select id="disabledSelect-position1" class="form-control">
                                                <option>经理</option>
                                            </select>
                                        </div>


                                    <%--</form>--%>
                                </div>
                                <button type="submit" class="btn btn-primary" style="height: 30px;margin-left: 48%">调动</button>
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
