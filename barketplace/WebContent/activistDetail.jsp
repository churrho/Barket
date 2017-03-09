<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<% String url = application.getContextPath() + "/"; %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>재능 기부자 상세 정보 화면</title>
</head>
<body>
<br><br><br>
<center>

${requestScope.successMsg}

<h3>재능 기부자</h3>
<hr><p>

<!-- ???
	EL tag로 출력 로직 완성하기
 -->
 
<table border="1">
	<tr>
		<th>기부자 id</th><th>기부자명</th><th>전공분야</th>
	</tr>
 	<tr>
		<td>
			<p align="center"><span style="font-size:9pt;">${activist.id}</span></p>
		</td>
		<td>
		    <p align="center"><span style="font-size:9pt;">${activist.name}</span></p>
		</td>
		<td>
			<p align="center"><span style="font-size:9pt;">${activist.major}</span></p>
		</td>
 	</tr>
</table>

<br><br><br>
<a href="activistUpdateReq?id=${activist.id}">수정하기</a>

<a href="activistDelete?id=${activist.id}">탈퇴하기</a>

&nbsp;&nbsp;&nbsp;<a href="<%=url%>index.html">메인 화면 이동</a>

</center>
</body>
</html>