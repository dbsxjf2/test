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
<c:forEach var="l" items="#{list }">
<hr color="black">
<tr>
<td><strong>���Ǹ�</strong>:&nbsp;${l.cname }</td><br><br>
<td><strong>���Ǹ�</strong>:&nbsp;${l.cordinal }</td><br><br>
<td><strong>����</strong>:&nbsp;${l.adname }</td><br><br>
<td><strong>������</strong>:&nbsp;${l.cbegin }</td><br><br>
<td><strong>������</strong>:&nbsp;${l.cend }</td><br><br>
<td><strong>���ǱⰣ</strong>:&nbsp;${l.totaldays }</td><br><br>
<td><input type="button" value="���Ǻ���" onclick="location.href='./classview?cnum=${l.cnum}'"></td>
</tr>
</c:forEach>
<td><input type="button" value="�� ���� ���" onclick="location.href='./create'"></td>
</body>
</html>