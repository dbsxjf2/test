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
<th><strong>기업명</strong></th>
<td>${j.cpname }</td>
</tr>
<tr class="table-primary">
<th><strong>기업위치</strong></th>
<td>${j.cploc }</td>
</tr>
<tr class="table-primary">
<th><strong>필요기술</strong></th>
<td>${j.keyword }</td>
</tr>
<tr class="table-primary">
<th><strong>기업링크</strong></th>
<td><a href="${j.cplink }">${j.cplink }</a></td>
</tr>
<tr class="table-primary">
<th><strong>대표메일</strong></th>
<td>${j.ceomail }&nbsp;<input type="button" onclick="location.href='./mail?ceomail=${j.ceomail}'" value="메일쓰기"></td>
</tr>

</c:forEach>
</table>
</div>
</div>








</body>
</html>