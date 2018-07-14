<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="bean.Staff" %>
<%@ page import="utils.PageBean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Dream</title>
    <%--引入css文件--%>

    <link href="${pageContext.request.contextPath}/static/new/css/bootstrap.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/static/new/css/font-awesome.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/static/new/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/static/new/css/custom-styles.css" rel="stylesheet" />
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'/>
</head>
<body>
    <div id="wrapper">
        <jsp:include page="${pageContext.request.contextPath}/commons/nav.jsp">
            <jsp:param value="staff-list" name="active"/>
        </jsp:include>

        <div id="page-wrapper" >
            <div id="page-inner">
                <%--头--%>
			 <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            	员工管理 <small>员工详情</small>
                        </h1>
                    </div>
             </div>

               
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                             	了解员工详细情况
                        </div>
                        <c:if test="${requestScope.get('msg')!=null}">
                            <script>confirm("${requestScope.get('msg')}")</script>
                        </c:if>

                        <div class="panel-body">
                            <table class="table table-striped table-sm">
                                <thead>
                                <tr>
                                    <th>工号<small style=" color: gray">&nbsp;&nbsp;点击修改</small></th>
                                    <th>姓名</th>
                                    <th>联系方式</th>
                                    <th>性别</th>
                                    <th>年龄</th>
                                    <th>身份证号</th>
                                    <th>部门</th>
                                    <th>岗位</th>
                                    <th>薪酬</th>
                                    <th style="text-align: center">操作</th>
                                    <button type="button"
                                            onclick="window.location.href='${pageContext.request.contextPath}/staff/add'"
                                            href="${pageContext.request.contextPath}/staff/add"
                                            class="btn btn-default">添加一个新员工
                                    </button>
                                </tr>
                                </thead>
                                <tbody>
                                <c:choose>
                                    <c:when test="${not empty requestScope.page.pageData}">
                                        <c:forEach var="staff" items="${requestScope.page.pageData}" varStatus="vs">
                                            <tr>
                                                <td><a href="${pageContext.request.contextPath}/staff/change?id=${staff.id}">${staff.userName }</a></td>
                                                <td>${staff.staffName }</td>
                                                <td>${staff.phoneNum}</td>
                                                <td>${staff.sex==0?'男':'女'}</td>
                                                <td>${staff.age}</td>
                                                <td>${staff.idCard}</td>
                                                <td>${staff.department.departName}</td>
                                                <td>${staff.station.stationName}</td>
                                                <td>${staff.wAges}</td>

                                                <td>
                                                    <c:if test="${staff.userName !=sessionScope.get('loginInfo').userName}">
                                                        <%--<button type="button"--%>
                                                                <%--onclick="window.location.href='${pageContext.request.contextPath}/staff/change?id=${staff.id}'"--%>
                                                                <%--href="${pageContext.request.contextPath}/staff/change?id=${staff.id}"--%>
                                                                <%--class="btn btn-primary">修改--%>
                                                        <%--</button>--%>
                                                        <button type="button"
                                                                onclick="window.location.href='${pageContext.request.contextPath}/staff/turn?id=${staff.id}'"
                                                                href="${pageContext.request.contextPath}/staff/turn?id=${staff.id}"
                                                                class="btn btn-default"
                                                                >转正
                                                        </button>
                                                        <button type="button"
                                                                onclick="window.location.href='${pageContext.request.contextPath}/staff/transfer?id=${staff.id}'"
                                                                href="${pageContext.request.contextPath}/staff/transfer?id=${staff.id}"
                                                                class="btn btn-default"
                                                                >调动
                                                        </button>
                                                        <button type="button"
                                                                onclick="cuitui()"
                                                                href="${pageContext.request.contextPath}/staff/delete?id=${staff.id}"
                                                                class="btn btn-primary"
                                                                style="height: 30px">辞退
                                                        </button>
                                                        <script>
                                                                function  cuitui(){
                                                                var r=confirm("确定辞退吗？");
                                                                if(r==true)
                                                                {
                                                                    window.location.href='${pageContext.request.contextPath}/staff/delete?id=${staff.id}';
                                                                }
                                                            }
                                                        </script>
                                                    </c:if>
                                                </td>

                                            </tr>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <tr>
                                            <td colspan="3">对不起，没有你要找的数据</td>
                                        </tr>
                                    </c:otherwise>
                                </c:choose>

                                </tbody>
                            </table>
                            当前${requestScope.page.currentPage }/${requestScope.page.totalPage }页     &nbsp;&nbsp;

                            <a href="${pageContext.request.contextPath }/staff/list?currentPage=1">首页</a>&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/staff/list?currentPage=${requestScope.page.currentPage>1?requestScope.page.currentPage-1:1}">上一页 </a>&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/staff/list?currentPage=${requestScope.page.currentPage<requestScope.page.totalPage?requestScope.page.currentPage+1:requestScope.page.totalPage}">下一页 </a>&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/staff/list?currentPage=${requestScope.page.totalPage}">末页</a>&nbsp;&nbsp;

                            <%--<button type="button"--%>
                                    <%--onclick="window.location.href='${pageContext.request.contextPath}/staff/add'"--%>
                                    <%--href="${pageContext.request.contextPath}/staff/add"--%>
                                    <%--class="btn btn-default">添加一个新员工--%>
                            <%--</button>--%>
                            <button type="button"
                                    style="margin-left: 1px;height: 30px"
                                    onclick="window.location.href='${pageContext.request.contextPath}/staff/select.jsp'"
                                    href="${pageContext.request.contextPath}/staff/select.jsp"
                                    class="btn btn-default">查找
                            </button>
                        </div>
                    </div>

                </div>
            </div>

            </div>
				 <footer><p></p></footer>
         </div>

    </div>

    <%--引入js文件--%>
    <script src="${pageContext.request.contextPath}/static/new/js/jquery-1.10.2.js"></script>
    <script src="${pageContext.request.contextPath}/static/new/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/new/js/jquery.metisMenu.js"></script>
    <script src="${pageContext.request.contextPath}/static/new/js/custom-scripts.js"></script>
    
   
</body>
</html>
