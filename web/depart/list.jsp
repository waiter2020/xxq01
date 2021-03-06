﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="bean.Depart" %>
<%@ page import="utils.PageBean" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>部门列表</title>
	<!-- Bootstrap Styles-->
    <link href="${pageContext.request.contextPath}/static/new/css/bootstrap.css" rel="stylesheet" />
     <!-- FontAwesome Styles-->
    <link href="${pageContext.request.contextPath}/static/new/css/font-awesome.css" rel="stylesheet" />
     <!-- Morris Chart Styles-->
   
        <!-- Custom Styles-->
    <link href="${pageContext.request.contextPath}/static/new/css/custom-styles.css" rel="stylesheet" />
     <!-- Google Fonts-->
   <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
     <!-- TABLE STYLES-->
    <link href="${pageContext.request.contextPath}/static/new/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
</head>
<body>
    <div id="wrapper">

        <jsp:include page="/commons/nav.jsp">
            <jsp:param value="depart-list" name="active"/>
        </jsp:include>
        <div id="page-wrapper" >
            <div id="page-inner">
			 <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            	部门管理 <small>部门详情</small>
                        </h1>
                    </div>
                </div> 
                 <!-- /. ROW  -->
               
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                             	了解部门详细情况
                        </div>
                        <div class="panel-body">
                                <table class="table table-striped table-sm">
                                    <thead>
                                        <tr>
                                            <th>部门号</th>
                                            <th>部门名</th>
                                            <th>部门详情</th>
                                            <th>总人数</th>
                                        </tr>
                                    </thead>
                                <tbody>
                                    <%
                                        PageBean pageBean = (PageBean) request.getAttribute("page");
                                        if(pageBean!=null){
		                                LinkedList<Depart> pageData = pageBean.getPageData();
		                                for(Depart l:pageData){
		                                    out.println("<tr>");
		                                    out.println("<td>"+l.getId()+"</td>");
		                                    out.println("<td>"+l.getDepartName()+"</td>");
		                                    out.println("<td>"+l.getDescribe()+"</td>");
                                            out.println("<td>"+l.getCount()+"</td>");
		                                    out.println("</tr>");
		                                }
		                            }
                                    %>
                                    </tbody>
                                    </table>
                                    当前${requestScope.page.currentPage }/${requestScope.page.totalPage }页     &nbsp;&nbsp;
	
					                        <a href="${pageContext.request.contextPath }/depart/list?currentPage=1">首页</a>&nbsp;&nbsp;
					                        <a href="${pageContext.request.contextPath }/depart/list?currentPage=${requestScope.page.currentPage>1?requestScope.page.currentPage-1:1}">上一页 </a>&nbsp;&nbsp;
					                        <a href="${pageContext.request.contextPath }/depart/list?currentPage=${requestScope.page.currentPage<requestScope.page.totalPage?requestScope.page.currentPage+1:requestScope.page.totalPage}">下一页 </a>&nbsp;&nbsp;
					                        <a href="${pageContext.request.contextPath }/depart/list?currentPage=${requestScope.page.totalPage}">末页</a>&nbsp;&nbsp;
					                            
                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>
                <!-- /. ROW  -->
        </div>
				 <footer><p><!--Copyright &copy; All rights reserved。--> Serendipity-life</p></footer>
    </div>
             <!-- /. PAGE INNER  -->
            </div>
         <!-- /. PAGE WRAPPER  -->
     <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="${pageContext.request.contextPath}/static/new/js/jquery-1.10.2.js"></script>
      <!-- Bootstrap Js -->
    <script src="${pageContext.request.contextPath}/static/new/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="${pageContext.request.contextPath}/static/new/js/jquery.metisMenu.js"></script>
     <!-- DATA TABLE SCRIPTS -->
    <script src="${pageContext.request.contextPath}/static/new/js/dataTables/jquery.dataTables.js"></script>
    <script src="${pageContext.request.contextPath}/static/new/js/dataTables/dataTables.bootstrap.js"></script>
         <!-- Custom Js -->
    <script src="${pageContext.request.contextPath}/static/new/js/custom-scripts.js"></script>
    
   
</body>
</html>
