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

<table>
<c:forEach var="j" items="#{jobinfo}">
<tr>
<th><strong>�����</strong></th>
<td>${j.cpname }</td>
</tr>
<tr>
<th><strong>�����ġ</strong></th>
<td>${j.cploc }</td>
</tr>
<tr>
<th><strong>�ʿ���</strong></th>
<td>${j.keyword }</td>
</tr>
<tr>
<th><strong>�����ũ</strong></th>
<td><a href="${j.cplink }">${j.cplink }</a></td>
</tr>
<tr>
<th><strong>��ǥ����</strong></th>
<td>${j.ceomail }&nbsp;<input type="button" onclick="location.href='./mail?ceomail=${j.ceomail}'" value="���Ͼ���"></td>
</tr>

</c:forEach>
</table>


</body>
</html>