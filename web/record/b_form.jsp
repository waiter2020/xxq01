<%--
  Created by IntelliJ IDEA.
  User: randall
  Date: 18-7-14
  Time: 下午8:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>部门调动表</title>
    <!-- Bootstrap Styles-->
    <link href="${pageContext.request.contextPath}/static/new/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="${pageContext.request.contextPath}/static/new/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="${pageContext.request.contextPath}/static/bootstrap-dtp/css/bootstrap.min.css" rel="stylesheet" media="screen" />

    <!-- Custom Styles-->
    <link href="${pageContext.request.contextPath}/static/new/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <!-- TABLE STYLES-->
    <link href="${pageContext.request.contextPath}/static/new/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />

</head>
<body>
<div id="wrapper">
    <jsp:include page="${pageContext.request.contextPath}/commons/nav.jsp">
        <jsp:param value="b-form" name="active"/>
    </jsp:include>


    <div id="page-wrapper" >
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">
                        部门调动 <small> 根据时间得到部门调动信息</small>
                    </h1>
                </div>
            </div>
            <!-- /. ROW  -->

            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">



                        <div class="panel-body">
                            <form role="form" method="post" action="/record/b_form">
                                <div class="col-lg-6">

                                    <div id="form-group">
                                    <div class="form_date">
                                        <label class="control-label">开始时间:</label>
                                        <input type="text" size="10" class="form-control"  name="start">
                                    </div>
                                    </div>

                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <label>结束时间：</label>
                                        <input  type="text"  class="form-control" size="10" name="end" >

                                    </div>
                                </div>
                                <button type="submit" class="btn btn-default" >生成</button>

                            </form>
                        </div>
                    </div>
                </div>
            </div>



            <div class="panel-heading"  >
                <p1  style="margin-left:40%; font-size: large;">部门调动表 </p1>
            </div>


            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">



                        <div class="panel-body">
                            <div class="table-responsive" style="margin:10px 10px 10px 10px ;">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-e">
                                    <thead>
                                    <tr>
                                        <th>姓名</th>
                                        <th>工号</th>
                                        <th>电话号码</th>
                                        <th>部门</th>
                                        <th>工号</th>
                                    </tr>
                                    </thead>

                                    <tbody>
                                    <c:choose>
                                        <c:when test="${not empty requestScope.list}">
                                            <c:forEach var="list1" items="${requestScope.list}" varStatus="vs">
                                                <tr>
                                                    <td>${list1.staff.staffName}</td>
                                                    <td>${list1.staff.userName}</td>
                                                    <td>${list1.staff.phoneNum}</td>
                                                    <td>${list1.staff.departMent.departName}</td>
                                                    <td>${list1.staff.station.stationName}</td>
                                                </tr>
                                            </c:forEach>
                                        </c:when>

                                    </c:choose>

                                    </tbody>
                                </table>
                            </div>



                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>
            <!-- /. ROW  -->

        </div>
        <footer><p> &copy; Serendipity-life</p></footer>
    </div>
    <!-- /. PAGE INNER  -->
</div>
<!-- /. PAGE WRAPPER  -->
<!-- /. WRAPPER  -->
<!-- JS Scripts-->
<!-- jQuery Js -->
<script src="${pageContext.request.contextPath}/static/bootstrap-dtp/jquery/jquery-1.8.3.min.js"></script>
<!-- Bootstrap Js -->
<script src="${pageContext.request.contextPath}/static/new/js/bootstrap.min.js"></script>
<!-- Metis Menu Js -->
<script src="${pageContext.request.contextPath}/static/new/js/jquery.metisMenu.js"></script>
<!-- DATA TABLE SCRIPTS -->
<script src="${pageContext.request.contextPath}/static/new/js/dataTables/jquery.dataTables.js"></script>
<script src="${pageContext.request.contextPath}/static/new/js/dataTables/dataTables.bootstrap.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        $('.form-control').datetimepicker({
            format:'yyyy-mm-dd',
            language:  'zh-CN',
            weekStart: 1,
            todayBtn:  1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });
    })
</script>
<script>
    $(document).ready(function () {
        $('#dataTables-e').dataTable();
    })

</script>
<!-- Custom Js -->

<script src="${pageContext.request.contextPath}/static/new/js/custom-scripts.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/bootstrap-dtp/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/bootstrap-dtp/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/bootstrap-dtp/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>

</body>

</html>
