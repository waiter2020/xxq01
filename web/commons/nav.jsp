<%--
  Created by IntelliJ IDEA.
  User: bzy
  Date: 18-7-11
  Time: 下午9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

    <div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">${sessionScope.loginInfo.staff.staffName}</a>
            </div>

            <ul class="nav navbar-top-links navbar-right">

                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="${pageContext.request.contextPath}/user/change.jsp"><i class="fa fa-user fa-fw"></i> 个人信息</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/user/change_pwd.jsp"><i class="fa fa-gear fa-fw"></i> 修改密码</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/do_login"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
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
                        <a  <%
                            String active = request.getParameter("active");
                            out.println("class=\""+ (active.equals("index")?"active-menu":" ")+"\"");
                        %>
                                href="${pageContext.request.contextPath}/"><i class="fa fa-dashboard"></i> 主页</a>
                    </li>
                    <li>
                        <a <%
                            active = request.getParameter("active");
                            out.println("class=\""+ (active.equals("staff-list")?"active-menu":" ")+"\"");
                            %>
                                href="${pageContext.request.contextPath}/staff/list">
                            <i class="fa fa-desktop"></i> 员工管理
                        </a>
                    </li>
                    <li>
                        <a <%
                            active = request.getParameter("active");
                            out.println("class=\""+ (active.equals("depart-list")?"active-menu":" ")+"\"");
                        %>
                                href="${pageContext.request.contextPath}/depart/list">
                            <i class="fa fa-bar-chart-o"></i> 部门管理
                        </a>
                    </li>
                    <li>
                        <a <%
                            active = request.getParameter("active");
                            out.println("class=\""+ (active.equals("station-list")?"active-menu":" ")+"\"");
                        %>
                                href="${pageContext.request.contextPath}/station/list">
                            <i class="fa fa-qrcode"></i>  岗位管理
                        </a>
                    </li>

                    <li>
                        <a href="#"><i class="fa fa-table"></i> 报表 </a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-edit"></i> from</a>
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
                        <a <%
                            active = request.getParameter("active");
                            out.println("class=\""+ (active.equals("empty")?"active-menu":" ")+"\"");
                        %>
                                href="${pageContext.request.contextPath}/commons/empty.jsp">
                            <i class="fa fa-fw fa-file"></i> Empty Page
                        </a>
                    </li>
                </ul>

            </div>

        </nav>
    </div>

</body>
</html>
