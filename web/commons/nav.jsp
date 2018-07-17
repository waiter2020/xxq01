<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <a class="navbar-brand" href="/">HRMS</a>
            </div>

            <ul class="nav navbar-top-links navbar-right">
                <a class="navbar-brand" href="/" style="text-align: right">${sessionScope.loginInfo.staff.staffName}</a>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="${pageContext.request.contextPath}/staff/staff_report?id=${sessionScope.loginInfo.staff.id}"><i class="fa fa-user fa-fw"></i> 个人信息</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/user/change_pwd.jsp"><i class="fa fa-gear fa-fw"></i> 修改密码</a>
                        </li>
                        <li><a onclick="logout()" href="javascript:void(0)"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                            <script>
                                function logout() {
                                    var r=confirm("确定退出吗？");
                                    if(r==true){
                                        window.location.href="${pageContext.request.contextPath}/do_logout";
                                    }
                                }
                            </script>
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
                    <c:if test="${sessionScope.loginInfo.grade==0||sessionScope.loginInfo.staff.id==sessionScope.loginInfo.staff.departMent.staffid}">
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
                    </c:if>
                    <li>
                        <a <%
                            active = request.getParameter("active");
                            out.println("class=\""+ (active.equals("record-list")?"active-menu":" ")+"\"");
                        %>
                        href="${pageContext.request.contextPath}/record/list">
                            <i class="fa fa-table"></i> 绩效查询
                        </a>
                    </li>

<c:if test="${sessionScope.loginInfo.grade==0||sessionScope.loginInfo.staff.id==sessionScope.loginInfo.staff.departMent.staffid}">

                    <li>
                        <a <%
                            active = request.getParameter("active");
                            out.println("class=\""+ (active.equals("report")?"active-menu":" ")+"\"");
                        %>
                                href="${pageContext.request.contextPath}/record/report.jsp">
                            <i class="fa fa-edit"></i> 人事月报
                        </a>
                    </li>


                    <li>
                        <a <%
                            active = request.getParameter("active");
                            if(active=="r-form"||active=="l-form"||active=="b-form"||active=="g-form")
                                out.println("class=\"active-menu\"");
                        %>
                                href="${pageContext.request.contextPath}"><i class="fa fa-sitemap"></i> 报表查询<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a <%
                                    active = request.getParameter("active");
                                    out.println("class=\""+ (active.equals("r-form")?"active-menu":" ")+"\"");
                                %>
                                        href="${pageContext.request.contextPath}/record/r_form.jsp">新聘员工表</a>
                            </li>
                            <li>
                                <a <%
                                    active = request.getParameter("active");
                                    out.println("class=\""+ (active.equals("l-form")?"active-menu":" ")+"\"");
                                %>
                                        href="${pageContext.request.contextPath}/record/l_form.jsp">离职员工表</a>
                            </li>
                            <li>
                                <a <%
                                    active = request.getParameter("active");
                                    out.println("class=\""+ (active.equals("b-form")?"active-menu":" ")+"\"");
                                %>
                                        href="${pageContext.request.contextPath}/record/b_form.jsp">部门调动表</a>
                            </li>
                            <li>
                                <a <%
                                    active = request.getParameter("active");
                                    out.println("class=\""+ (active.equals("g-form")?"active-menu":" ")+"\"");
                                %>
                                        href="${pageContext.request.contextPath}/record/g_form.jsp">岗位调动表</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a <%
                            active = request.getParameter("active");
                            out.println("class=\""+ (active.equals("depart-add")?"active-menu":" ")+"\"");
                        %>
                                href="${pageContext.request.contextPath}/depart/add.jsp">
                            <i class="fa fa-fw fa-file"></i> 部门添加
                        </a>
                    </li>
</c:if>
                </ul>

            </div>

        </nav>
    </div>

</body>
</html>
