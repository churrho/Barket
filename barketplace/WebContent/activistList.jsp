<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<% String url = application.getContextPath() + "/"; %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��� Activist list ȭ��</title>
</head>
<body>
<br><br><br>
<center>
<h3>��� ����� list</h3>
<hr><p>

<table border="1">
	<thead>
		<tr>
			<th>����� id</th><th>����� �̸�</th><th>�ֿ� �о�</th>
		</tr>
	</thead>
	

	
	<%--???
	 	��� ����� ���� ���� : ����� id�� Ŭ���ϸ� "��� �����"�� ���� ������ ����Ǿ�� �� --%>
	<c:forEach items="${activistAll}" var="data">
		    <tr>
		        <td>
		            <p align="center"><span style="font-size:9pt;"><a href="activist?id=${data.id}">${data.id}</a></span></p>
		        </td>
		        <td>
		            <p align="center"><span style="font-size:9pt;">${data.name}</span></p>
		        </td>
		        <td>
		       		<p align="center"><span style="font-size:9pt;">${data.major}</span></p>
		        </td>
		    </tr>
	</c:forEach>
	
	
	
</table>

<br><br><br>
<font color="blue">��� ����� id�� Ŭ���ϸ� �� ���� Ȯ���� �����մϴ�</font>

</center>
</body>
</html>