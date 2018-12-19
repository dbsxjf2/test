<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="header.jsp"%>
<div id="content">
<fieldset>
<legend>로그인 폼</legend>
<form action="loginProcess" method="post" autocomplete="off">
<p>
<label>아이디</label>
<input type="text" name="id" id="id">
</p>

<p>
<label>비밀번호</label>
<input type="password" name="pwd" id="pwd">
</p>
<p style="text-align: right;">

<input type="submit" value="로그인">
</p>
</form>
</fieldset>
</div>
<%@ include file="footer.jsp"%>