<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<div id="warp">
	<fieldset>
		<legend>�л����� �̷¼�_�󼼺���</legend>
		<form action="company_upload" method="post">
			<input type="hidden" id="cpfnum" name="cpfnum" value="${cpfnum}">
			<p>
				<textarea id="content" name="content" rows="5" cols="150">${content}</textarea>
			</p>
			<p>
				<input type="submit" value="�����ϱ� / ����ϱ�">
			</p>
		</form>
	</fieldset>

</div>