<%--
  Created by IntelliJ IDEA.
  User: randall
  Date: 18-7-12
  Time: 下午6:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>个人信息</title>
    <!-- Bootstrap Styles-->
    <link href="${pageContext.request.contextPath}/static/new/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="${pageContext.request.contextPath}/static/new/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="${pageContext.request.contextPath}/static/new/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />

    <link href="${pageContext.request.contextPath}/static   /css/hucc.css" rel="stylesheet" />

</head>
<body>
        <jsp:include page="${pageContext.request.contextPath}/commons/nav.jsp">
            <jsp:param value="staff-list" name="active"/>
        </jsp:include>
        <div id="wrapper">
            <div id="page-wrapper" >
                <div id="page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <h1 class="page-header">
                                员工信息 <small>信息修改</small>
                            </h1>
                        </div>
                    </div>
                    <!-- /. ROW  -->


                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    修改员工信息
                                </div>
                                <!--<div class="panel-heading">-->
                                <!--基本信息表-->
                                <!--</div>-->
                                <div class="panel-body">

                                    <div class="row">

                                        <form role="form" action="${pageContext.request.contextPath}/staff/change" method="post">

                                        <div class="col-lg-6">



                                            <!--  以下为fixed表
                                            基本信息不可变
                                            @以 placeholder 显示 : 姓名 员工号 性别
                                            @以 option 显示 : 部门 职位
                                            -->

                                                    <input type="hidden" name="id" value="${change.id}">
                                                    <div class="form-group">
                                                        <label for="disabledInput-id">工号</label>
                                                        <input class="form-control" id="disabledInput-id" type="text" placeholder="${change.userName}" readonly>
                                                    </div>

                                                    <div class="form-group">
                                                        <label>姓名</label>
                                                        <input class="form-control" name="staffName" value="${change.staffName}" readonly>

                                                    </div>
                                                    <div class="form-group">
                                                        <label>证件</label>
                                                        <input class="form-control" name="idCard" value="${change.idCard}" readonly>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>年龄</label>
                                                        <input class="form-control" name="age" value="${change.age}" readonly>
                                                    </div>

                                                    <label>薪酬</label>
                                                    <div class="form-group input-group">
                                                        <span class="input-group-addon">$</span>
                                                        <input type="text" class="form-control" name="wAges" value="${change.wAges}" <c:if test="${change.id==sessionScope.loginInfo.staff.id}">readonly</c:if>>
                                                        <span class="input-group-addon">.00</span>
                                                    </div>





                                        </div>

                                        <!-- 以下可变信息表

                                        -->
                                        <div class="col-lg-6">


                                                <div class="form-group">
                                                    <label>联系方式</label>
                                                    <input class="form-control" name="phoneNum" value="${change.phoneNum}">
                                                </div>
                                                <div class="form-group">
                                                    <label>@EMAL<small class="form-control-static">&nbsp;&nbsp;例:email@example.com</small></label>
                                                    <input class="form-control" name="email" value="${change.email}">
                                                </div>
                                                <div class="form-group">
                                                    <label>详细住址:</label>
                                                    <textarea class="form-control" rows="3" style="height: 130px" name="address">${change.address}</textarea>
                                                </div>

                                                <div style="margin-left: 160px">
                                                    <button type="submit" value ="submit" class="btn btn-primary"  >修改</button>
                                                    <button type="reset"  value="reset"  class="btn btn-primary" style="margin-left: 20px">重置</button>

                                                </div>
                                        </div>
                                        </form>

                                    </div>
                                </div>





                            </div>

                        </div>
                    </div>
                    <footer><p></p></footer>
                </div>
            </div>



        </div>

<!-- JS Scripts-->
<!-- jQuery Js -->
<script src="${pageContext.request.contextPath}/static/new/js/jquery-1.10.2.js"></script>
<!-- Bootstrap Js -->
<script src="${pageContext.request.contextPath}/static/new/js/bootstrap.min.js"></script>
<!-- Metis Menu Js -->
<script src=".${pageContext.request.contextPath}/static/new/js/jquery.metisMenu.js"></script>
<!-- Custom Js -->
<script src="${pageContext.request.contextPath}/static/new/js/custom-scripts.js"></script>
</body>
</html>
