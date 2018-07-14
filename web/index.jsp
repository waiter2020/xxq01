<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
	
    <!-- 主界面  -->

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Dream</title>
    <link href="${pageContext.request.contextPath}static/new/css/bootstrap.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}static/new/css/font-awesome.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}static/new/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}static/new/css/custom-styles.css" rel="stylesheet" />
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>

<body>
    <div id="wrapper">
        <jsp:include page="${pageContext.request.contextPath}/commons/nav.jsp">
            <jsp:param value="index" name="active"/>
        </jsp:include>

        <!--
				center
        -->
        <div id="page-wrapper">
            <div id="page-inner">

                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            	主页 <small>信息总和</small>
                        </h1>
                    </div>
                </div>
            </div>
            <!-- /. PAGE INNER  -->
        </div>
    </div>
    <script src="${pageContext.request.contextPath}static/new/js/jquery-1.10.2.js"></script>
    <script src="${pageContext.request.contextPath}static/new/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}static/new/js/jquery.metisMenu.js"></script>
    <script src="${pageContext.request.contextPath}static/new/js/morris/raphael-2.1.0.min.js"></script>
    <script src="${pageContext.request.contextPath}static/new/js/morris/morris.js"></script>
    <script src="${pageContext.request.contextPath}static/new/js/custom-scripts.js"></script>


</body>

</html>