<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>



</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<body>

 
	<tr>
		<td><strong>Ű����</strong>: <select id="keywordValue">
				<c:forEach var="l" items="#{list }">
					<option>${l.keyword }</option>
				</c:forEach>
		</select></td>

		<td><strong>��ġ</strong>: <select id="cplocValue">
				<c:forEach var="l2" items="#{list2 }">
					<option>${l2.cploc }</option>
				</c:forEach>
		</select></td>

		<td><input type="button" id="keywordBtn" value="�˻�"></td>
	</tr>

	<fieldset>
		<legend>Ű���� �˻�����Ʈ</legend>
		<div id="target"></div>
		
		
		
	</fieldset>
	<br>
	<br>


	<tr>
		<td><strong>����</strong>: <select id="classValue">
				<c:forEach var="l3" items="#{list3 }">
					<option>${l3.cname }</option>
				</c:forEach>
		</select></td>
		<td><input type="button" id="classBtn" value="�˻�"></td>
	</tr>

	<fieldset>
		<legend>���� ���� �������Ʈ</legend>
		<div id="target2"></div>
	</fieldset>




</body>
<script>
$(function(){
	$("#keywordBtn").click(function(){
     $.ajax({
    	
    	url:"./keyword?keywordValue="+$('#keywordValue option:selected').val()
    			+"&cplocValue="+$('#cplocValue option:selected').val(),
    	success:function(data){
    		$('#target').html(data);
    	}		
    		 
     });
	});
	});

</script>
</html>
