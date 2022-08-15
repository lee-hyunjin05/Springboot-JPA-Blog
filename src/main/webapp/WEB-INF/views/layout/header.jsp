<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">
	<!-- 
	<script>
		alert("로그인이 된 사용자입니다.")
	</script>
	 -->
	 <sec:authentication property="principal" var="principal"/>
</sec:authorize>

<!DOCTYPE html>
<html lang="UTF-8">
<head>
	<title>hyunjin blog</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">  
<!-- 	<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.js"></script> -->
<!-- 	<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script> -->
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<!-- 			jquery.slim은 아작스 지원 안하나봄 -->
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<!-- 	<script src="https://jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script> -->
<!-- 	<script src="https://jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script> -->
<!-- 	<script src="https://jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script> -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
	<h1>principal : ${principal }</h1>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	<a class="navbar-brand" href="/">HYUNJIN</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="collapsibleNavbar">		
	<c:choose>
<%-- 		<c:when test="${empty sessionScope.principal }"> --%>
		<c:when test="${empty principal }">
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link" href="/auth/loginForm">로그인</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/auth/joinForm">회원가입</a>
				</li>
			</ul>
		</c:when>
		<c:otherwise>		
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link" href="/board/saveForm">글쓰기</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/user/updateForm">회원정보</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/logout">로그아웃</a>
				</li>
			</ul>
		</c:otherwise>
	</c:choose>
	</div>  
</nav>
<br>