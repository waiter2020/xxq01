<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--<html xmlns="http://www.w3.org/1999/xhtml">--> 	 
	
    <!-- 主界面  -->

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>员工管理系统</title>
    <!-- echart引入部分-->
    <script src="${pageContext.request.contextPath}/static/new/echart/echarts.js"></script>
    <script src="${pageContext.request.contextPath}/static/new/echart/dataTool.js"></script>
	<script src="${pageContext.request.contextPath}/static/new/echart/jquery.js"></script>
    <!-- Bootstrap Styles-->
    <link href="${pageContext.request.contextPath}/static/new//css/bootstrap.css" rel="stylesheet" />
    
    <!-- FontAwesome Styles-->
    <link href="${pageContext.request.contextPath}/static/new/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="${pageContext.request.contextPath}/static/new/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="${pageContext.request.contextPath}/static/new/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
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
                <a class="navbar-brand" href="index.jsp">Ranlly</a>
            </div>

            <ul class="nav navbar-top-links navbar-right">
       
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
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
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
                        <a class="active-menu" href="index.html"><i class="fa fa-dashboard"></i> Dashboard</a>
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
                        <a href="form.html"><i class="fa fa-edit"></i> from</a>
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
                        <a href="empty.html"><i class="fa fa-fw fa-file"></i> Empty Page</a>
                    </li>
                </ul>

            </div>

        </nav>
        
        <!--
				center
        -->
        <div id="page-wrapper">
            <div id="page-inner">

                <div class="row">
                    <div class="col-md-12">
                        <h2 class="page-header">
                            	人力资源系统 <small>了解公司从这里开始</small>
                        </h2>
                        <div id="1" style="height: 750px;width: 700px; left: 100px;">
                        	
                        </div>
                    </div>
                </div>
                <!-- /. ROW  -->
                
				 <footer><p><!--Copyright &copy; All rights reserved。--> Serendipity-life</p></footer>
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="${pageContext.request.contextPath}/static/new/js/jquery-1.10.2.js"></script>
    <!-- Bootstrap Js -->
    <script src="${pageContext.request.contextPath}/static/new/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="${pageContext.request.contextPath}/static/new/js/jquery.metisMenu.js"></script>
    <!-- Morris Chart Js -->
    <script src="${pageContext.request.contextPath}/static/new/js/morris/raphael-2.1.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/new/js/morris/morris.js"></script>
    <!-- Custom Js -->
    <script src="${pageContext.request.contextPath}/static/new/js/custom-scripts.js"></script>
    
    <script>
    	
    var myChart = echarts.init(document.getElementById('1'));
    myChart.showLoading();
	$.get('${pageContext.request.contextPath}/static/new/echart/les-miserables.gexf', function (xml) {
    myChart.hideLoading();

    var graph = echarts.dataTool.gexf.parse(xml);
    var categories = [{name:'人事部'},{name:'董事会'},{name:'财务部'},{name:'出纳部'},{name:'市场部'},{name:'公关'},{name:'销售部'},{name:'后勤部'},{name:'设计部'}];
//  var categories = [];
//  for (var i = 0; i < 9; i++) {
//      categories[i] = {
//          name: '类目' + i
//      };
//  }
    graph.nodes.forEach(function (node) {
        node.itemStyle = null;
        node.value = node.symbolSize;
        node.symbolSize /= 1.5;
        node.label = {
            normal: {
                show: node.symbolSize > 10
            }
        };
        node.category = node.attributes.modularity_class;
    });
    option = {
        title: {
            text: '人事系统',
            subtext: 'Circular layout',
            top: 'bottom',
            left: 'left'
        },
        tooltip: {
        },
        legend: [{
            //selectedMode: 'single',
            data: categories.map(function (a) {
                return a.name;
            })
        }],
        animationDurationUpdate: 1500,
        animationEasingUpdate: 'quinticInOut',
        series : [
            {
                name: 'Les Miserables',
                type: 'graph',
                layout: 'circular',
                circular: {
                    rotateLabel: true
                },
                data: graph.nodes,
                links: graph.links,
                categories: categories,
                roam: true,
                label: {
                    normal: {
                        position: 'right',
                        formatter: '{b}'
                    }
                },
                lineStyle: {
                    normal: {
                        color: 'source',
                        curveness: 0.3
                    }
                }
            }
        ]
    };
    myChart.setOption(option);
}, 'xml');
    </script>

</body>

</html>