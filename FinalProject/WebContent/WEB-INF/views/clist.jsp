<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="c" items="#{cla }">

<hr style="color: black; height:2px; " >
<tr>

<td><strong>���Ǹ�</strong>:&nbsp;${c.cname }</td><br><br>
<td><strong>���</strong>:&nbsp;${c.cordinal }</td><br><br>
<td><strong>����</strong>:&nbsp;${c.adname }</td><br><br>
<td><strong>������</strong>:&nbsp;${c.cbegin }</td><br><br>
<td><strong>������</strong>:&nbsp;${c.cend }</td><br><br>
<td><strong>���ǱⰣ</strong>:&nbsp;${c.totaldays }</td><br><br>
<td><input type="button" value="���Ǻ���" onclick="location.href='./classview?cnum=${c.cnum}'"></td>
</tr>
<hr style="color: black; height:2px;">
</c:forEach>
<tr>
</tr>

<td><input type="button" value="�� ���� ���" onclick="location.href='./create'"></td>
</body>
</html>