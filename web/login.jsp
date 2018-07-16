<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/frontpage.css"/>
		<meta charset="utf-8" />
		<link href='http://fonts.font.im/css?family=Ubuntu' rel='stylesheet' type='text/css'>
		<link href='http://fonts.font.im/css?family=Amatic+SC:700' rel='stylesheet' type='text/css'>
		<title></title>
	</head>
	<body style="background-image: url(${pageContext.request.contextPath}/static/images/s1.jpg); background-size: cover;">
		<div class="container">
			<div style="float: left; margin-top: 0px; font-family: 'Amatic SC', cursive; font-size: 20px;"><h1 style="margin-top: 0;">Produced by 5352</h1></div>
			<div class="user-login">
				<c:if test="${requestScope.get('msg')!=null}">
					<script>confirm("${requestScope.get('msg')}")</script>
				</c:if>
				<form class="form-login" method="post" action="/do_login">
					<p> Username</p>
					<script>
                        function t1(value){
                            var a1=document.getElementById('a1');
                            if(/^[a-z0-9_-]{3,16}$/.test(value)==true){
                                a1.style.borderColor='white';
                            }
                            else{
                                a1.style.borderColor='red';
                            }
                        }
					</script>
					<li class="base" id='a1'>
						<input type="text" name="username" autocomplete="off" oninput="t1(this.value)"/>
					</li>
					<p> Password </p>
					<li class="base">						
						<input type="password" name="password"/>
					</li>
					<div class="base">
						<input type="submit" value="Login Now"/>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>
