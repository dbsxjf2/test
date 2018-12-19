<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>kosta188기 메인입니다.</title>
<link rel="stylesheet" type="text/css" href="resources/css/default.css">
<style type="text/css">
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
</head>
<body>
   <div id="wrap">
      <div id="header">
         <ul>
            <li><a href="loginProcess">Home|</a></li>
            <li>
            <c:choose>
            <c:when test="${sessionScope.uid==null}">
            <a href="loginForm">로그인 |</a></c:when>
            <c:otherwise>${sessionScope.uname}님<a href="logout">로그아웃 |</a>
            </c:otherwise>
            </c:choose>
            </li>
            <li>
            <c:choose>
            <c:when test="${sessionScope.uid==null}">
            <a href="member">회원가입 </a>
            </c:when>
            <c:otherwise>
            <a href="mypage">마이페이지</a>
            </c:otherwise>
            </c:choose>
            |</li>
            <li><a href="">부서리스트</a></li>
            <li><a href="">사원리스트</a></li>
            <li>IP:${reip}</li>
         </ul>
      </div>
   