<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>


</head>
<body>


	<h1>Ű���庰 ��� ��������Ʈ</h1>
<table>
<c:forEach var="key" items="#{job }">
<tr>
<th><strong>�����</strong><th>
<td>${key.cpname }</td>&nbsp;
</tr>
<tr>
<th><strong>�����ġ</strong></th>
<td">${key.cploc }</td>
</tr>
</c:forEach>
</table>

<td><input type="button" onclick="location.href='./keywordtotal?keyword=${keyword}&cploc=${cploc }&page=1'" value="������"></td>



</body>
</html>