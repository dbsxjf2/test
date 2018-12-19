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
<td><strong>강의명</strong>:&nbsp;${l.cname }</td><br><br>
<td><strong>강의명</strong>:&nbsp;${l.cordinal }</td><br><br>
<td><strong>강사</strong>:&nbsp;${l.adname }</td><br><br>
<td><strong>시작일</strong>:&nbsp;${l.cbegin }</td><br><br>
<td><strong>종료일</strong>:&nbsp;${l.cend }</td><br><br>
<td><strong>강의기간</strong>:&nbsp;${l.totaldays }</td><br><br>
<td><input type="button" value="강의보기" onclick="location.href='./classview?cnum=${l.cnum}'"></td>
</tr>
</c:forEach>
<td><input type="button" value="새 강의 등록" onclick="location.href='./create'"></td>
</body>
</html>