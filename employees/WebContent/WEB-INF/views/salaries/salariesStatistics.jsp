<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body class="container">
	<div>
		<a href="${pageContext.request.contextPath}/index" class="btn btn-success">홈으로</a>
	</div>
	<table class="table">
		<thead class="table-secondary">
			<tr>
				<th>금액 이름</th>
				<th>금액 수치</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>총 지급횟수</td>
				<td>${map.count}</td>
			</tr>
			<tr>
				<td>총 지급금액</td>
				<td>${map.sum}</td>
			</tr>
			<tr>
				<td>총 금액평균</td>
				<td>${map.avg}</td>
			</tr>
			<tr>
				<td>최고 지급액</td>
				<td>${map.max}</td>
			</tr>
			<tr>
				<td>최소 지급액</td>
				<td>${map.min}</td>
			</tr>
			<tr>
				<td>총 금액편차</td>
				<td>${map.std}</td>
			</tr>
		</tbody>
	</table>
</body>
</html>