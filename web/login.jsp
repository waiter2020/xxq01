<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en"
	  xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="UTF-8">
	<title>登陆</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css">
</head>
<body>

<div class="bgpic">
	<div class="backfiler">
		<div class="loginBG">
			<div class="loginFiler">
				<div class="left">
					<h1>WHAT IS LOVE ?</h1>
				</div>
				<div class="right">
					<h1>登录</h1>
					<c:if test="${requestScope.get('msg')!=null}">
                        <h4>${requestScope.get('msg')}</h4>
                    </c:if>
					<form action="/do_login" method="post">
						<label for="name">用户名：</label><br>
						<input name="username" id="name" class="inputText"><br>
						<label for="passwd">密码：</label><br>
						<input name="password" type="password" id="passwd" class="inputText"><br>
						<button class="loginBtn">登录</button>
                        <button href="register" type="button" id="registerBtn" onclick="window.location.href='register'">注册</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
