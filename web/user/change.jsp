<%--
  Created by IntelliJ IDEA.
  User: randall
  Date: 18-7-12
  Time: 下午9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
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
    <body>
        <div id="wrapper">

                    <!--
                作者：865584045@qq.com
                时间：2018-07-11
                描述：上边栏
                -->
                <nav class="navbar navbar-default top-navbar" role="navigation">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="index.html">Ranlly</a>
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


                 <!--
                     作者：865584045@qq.com
                     时间：2018-07-11
                     描述：center
                 -->
                <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">

                <li>
                    <a  href="index.html"><i class="fa fa-dashboard"></i> Dashboard</a>
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
                    <a href="table.html"><i class="fa fa-table"></i> 报表 </a>
                </li>
                <li>
                    <a href="form.html"><i class="fa fa-edit"></i>个人信息变更</a>
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
                            <a href="form.html">岗位管理</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a class="active-menu" href="personal.html"><i class="fa fa-fw fa-file"></i>个人信息</a>
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
                                    个人信息 <small>查看或修改.</small>
                                </h1>
                            </div>
                        </div>
                        <!-- /. ROW  -->


                        <div class="row">
                            <div class="col-lg-12">
                                <div class="panel panel-default">

                                    <!--基本信息表-->
                                    <!--</div>-->
                                    <div class="panel-body">

                                        <div class="row">


                                            <div class="col-lg-6">

                                                <!--  以下为fixed表
                                                    基本信息本人不可变更

                                                -->
                                                <h4>个人基本信息</h4>

                                                <form role="form">
                                                    <fieldset disabled="">

                                                        <div class="form-group">
                                                            <label for="disabledInput-name">姓名</label>
                                                            <input class="form-control" id="disabledInput-name" type="text" placeholder="${sessionScope.loginInfo.staff.staffName}" disabled="">
                                                        </div>

                                                        <div class="form-group">
                                                            <label for="disabledInput-sex">性别</label>
                                                            <input class="form-control" id="disabledInput-sex" type="text" placeholder="${sessionScope.loginInfo.staff.sex==1? '女':'男'}" disabled="">
                                                        </div>

                                                        <div class="form-group">
                                                            <label for="disabledInput-id">员工号</label>
                                                            <input class="form-control" id="disabledInput-id" type="text" placeholder="${sessionScope.loginInfo.staff.userName}" disabled="">
                                                        </div>

                                                        <div class="form-group">
                                                            <label for="disabledSelect-depart">部门</label>
                                                            <select id="disabledSelect-depart" class="form-control">
                                                                <option>${sessionScope.loginInfo.staff.departMent.departName}</option>
                                                            </select>
                                                        </div>

                                                        <div class="form-group">
                                                            <label for="disabledSelect-position">职位</label>
                                                            <select id="disabledSelect-position" class="form-control">
                                                                <option>${sessionScope.loginInfo.staff.station.stationName}</option>
                                                            </select>
                                                        </div>
                                                        <!-- 一个假的提交按钮 -->
                                                        <div align="center">
                                                            <button type="submit" class="btn btn-primary"  >保存</button>
                                                        </div>
                                                    </fieldset>
                                                </form>





                                            </div>
                                            <!-- /.col-lg-6 (nested) -->



                                            <!--
                                                以下可变信息表
                                                可变内容为 电话 邮箱 住址
                                            -->
                                            <div class="col-lg-6">
                                                <c:set var="msg" value="${requestScope.get('msg')}"/>
                                                <c:if test="${msg!=null}">
                                                    <p ><c:out value="${msg}"/></p>
                                                </c:if>
                                                <h4>个人可变信息</h4>
                                                <form role="form" action="${pageContext.request.contextPath}/user/change" method="post">
                                                    <div class="form-group">
                                                        <label>Telephone Number</label>
                                                        <input class="form-control " name="phoneNum" value="${sessionScope.loginInfo.staff.phoneNum}">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>@EMAL</label>
                                                        <input class="form-control" name="email" value="${sessionScope.loginInfo.staff.email}">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>其形式如:</label>
                                                        <p class="form-control-static">email@example.com</p>
                                                    </div>

                                                    <div class="form-group">
                                                        <label>详细住址:</label>
                                                        <textarea class="form-control" rows="4      " name="address">${sessionScope.loginInfo.staff.address}</textarea>
                                                    </div>

                                                    <div align="center">
                                                        <button type="submit" value ="submit" class="btn btn-default">保存</button>
                                                        <button type="reset"  value="reset"  class="btn btn-default">重置</button>
                                                    </div>
                                                </form>
                                            </div>




                                        </div>
                                        <!-- /.row (nested) -->
                                    </div>
                                    <!-- /.panel-body -->
                                </div>
                                <!-- /.panel -->
                            </div>
                            <!-- /.col-lg-12 -->
                        </div>
                        <footer><p><!--Copyright &copy; All rights reserved。--> Serendipity-Life</p></footer>
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

    </body>
</html>
