<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>

<style>
.item1_jhp {
	grid-area: left;
}
.item2_jhp {
	grid-area: right;
}
.grid-container_jhp {
	display: grid;
	grid-template-areas: 'left left left left right right';
	grid-gap: 10px;
	padding: 10px;
	grid-gap: 10px;
}
.grid-container_jhp>div {
	text-align: center;
	padding: 20px 0;
	font-size: 30px;
}



</style>
</head>

<body>


<div class="grid-container_jhp">
<div class="item1_jhp">
<table>
<c:forEach var="j" items="#{jobinfo}">
<tr class="table-primary">
<th><strong>�����</strong></th>
<td>${j.cpname }</td>
</tr>
<tr class="table-primary">
<th><strong>�����ġ</strong></th>
<td>${j.cploc }</td>
</tr>
<tr class="table-primary">
<th><strong>�ʿ���</strong></th>
<td>${j.keyword }</td>
</tr>
<tr class="table-primary">
<th><strong>�����ũ</strong></th>
<td><a href="${j.cplink }">${j.cplink }</a></td>
</tr>
<tr class="table-primary">
<th><strong>��ǥ����</strong></th>
<td>${j.ceomail }&nbsp;<input type="button" onclick="location.href='./mail?ceomail=${j.ceomail}'" value="���Ͼ���"></td>
</tr>

</c:forEach>
</table>
</div>
</div>








</body>
</html>