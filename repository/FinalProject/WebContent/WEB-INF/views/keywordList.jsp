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

${keyword } <br>
<c:forEach var="key" items="#{job }">
<tr>
<td><strong>�����</strong>:${key.cpname }</td>&nbsp;
<td><strong>�����ġ</strong>:${key.cploc }</td><br><br>
</tr>
</c:forEach>
<td><input type="button" onclick="location.href='./keywordtotal?keyword=${keyword}&cploc=${cploc }&page=1'" value="������"></td>



</body>
</html>