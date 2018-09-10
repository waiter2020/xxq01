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
    <link href="${pageContext.request.contextPath}/static/new/css/bootstrap.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/static/new/css/font-awesome.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/static/new/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/static/new/css/custom-styles.css" rel="stylesheet" />
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>

<body>
    <div id="wrapper">

        <jsp:include page="/commons/nav.jsp">
            <jsp:param value="index" name="active"/>
        </jsp:include>
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

                
				 <footer><p></p></footer>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/static/new/js/jquery-1.10.2.js"></script>
    <script src="${pageContext.request.contextPath}/static/new/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/new/js/jquery.metisMenu.js"></script>
    <script src="${pageContext.request.contextPath}/static/new/js/morris/raphael-2.1.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/new/js/morris/morris.js"></script>
    <script src="${pageContext.request.contextPath}/static/new/js/custom-scripts.js"></script>
    
    <script>
    	
    var myChart = echarts.init(document.getElementById('1'));
    myChart.showLoading();
	$.get('${pageContext.request.contextPath}/static/new/echart/les-miserables.gexf', function (xml) {
    myChart.hideLoading();

    var graph = echarts.dataTool.gexf.parse(xml);
    var categories = [{name:'人事部'},{name:'董事会'},{name:'财务部'},{name:'出纳部'},{name:'市场部'},{name:'公关部'},{name:'销售部'},{name:'后勤部'},{name:'设计部'}];
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