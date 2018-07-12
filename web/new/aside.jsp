<%--
  Created by IntelliJ IDEA.
  User: bzy
  Date: 18-7-11
  Time: 下午9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <div id="wrapper">
        <!--
        	作者：865584045@qq.com
        	时间：2018-07-11
        	描述：侧边栏
        -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">

                    <li>
                        <a class="active-menu" href="index.jsp"><i class="fa fa-dashboard"></i> 主页</a>
                    </li>
                    <li>
                        <a href="ui-elements.html"><i class="fa fa-desktop"></i> UI</a>
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
                        <a href="form.html"><i class="fa fa-edit"></i> from</a>
                    </li>


                    <li>
                        <a href="#"><i class="fa fa-sitemap"></i> 信息变更<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="../staff/list.jsp">员工管理</a>
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
                        <a href="empty.html"><i class="fa fa-fw fa-file"></i> Empty Page</a>
                    </li>
                </ul>

            </div>

        </nav>
    </div>

</body>
</html>

