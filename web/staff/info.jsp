<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Dream</title>
    <script src="${pageContext.request.contextPath}/static/new/echart/echarts.js"></script>
    <script src="${pageContext.request.contextPath}/static/new/echart/dataTool.js"></script>
    <script src="${pageContext.request.contextPath}/static/new/echart/jquery.js"></script>
    <!-- Bootstrap Styles-->
    <link href="${pageContext.request.contextPath}/static/new/css/bootstrap.css" rel="stylesheet" />
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
    <jsp:include page="${pageContext.request.contextPath}/commons/nav.jsp">
        <jsp:param value="staff-info" name="active"/>
    </jsp:include>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper" >
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">
                        员工信息 <small>详情展示</small>
                    </h1>
                </div>
            </div>
            <!-- /. ROW  -->

            <div class="row">
                <div class="col-md-12" style="padding: 0;">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            基本信息
                        </div>
                        <div class="panel-body">
                            <div class="col-lg-6">
                                <small>姓名:</small><h2>黄会凌</h2><br>
                                <small>部门及岗位:</small><h3>技术部经理</h3><br>
                                <small>证件号:</small><h3>1487319983249</h3><br>
                                <button class="btn btn-default">修改</button>
                            </div>
                            <div class="col-lg-6">
                                <small>联系方式:</small><h3>138762783478</h3><br>
                                <small>Email:</small><h3>3489287@qq.com</h3><br>
                                <small>住址:</small><h3>东风路234</h3><br>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /. ROW  -->
                <div class="row">

                    <div class="col-md-6 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                上月出勤情况
                            </div>
                            <div class="panel-body">
                                <div id="1" style="height: 400px;"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                前六月绩效
                            </div>
                            <div class="panel-body">
                                <div id="2" style="height: 400px;"></div>
                            </div>
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
    <script>
        var myChart1 = echarts.init(document.getElementById('1'));
        option = {
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                x: 'left',
                data:['出勤','缺勤']
            },
            series: [
                {
                    name:'访问来源',
                    type:'pie',
                    radius: ['50%', '70%'],
                    avoidLabelOverlap: false,
                    label: {
                        normal: {
                            show: false,
                            position: 'center'
                        },
                        emphasis: {
                            show: true,
                            textStyle: {
                                fontSize: '30',
                                fontWeight: 'bold'
                            }
                        }
                    },
                    labelLine: {
                        normal: {
                            show: true
                        }

                    },
                    data:[
                        {value:29, name:'出勤'},
                        {value:3, name:'缺勤'}
                    ]
                }
            ]
        };
        myChart1.setOption(option);
    </script>

    <script>
        var myChart2 = echarts.init(document.getElementById('2'));
        option = {
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
            },
            yAxis: {
                type: 'value'
            },
            series: [{
                data: [820, 932, 901, 934, 1290, 1330, 1320],
                type: 'line',
                areaStyle: {}
            }]
        };
        myChart2.setOption(option);
    </script>




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


</body>
</html>
