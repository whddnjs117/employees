<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<body class="container">
	<h1>현재 부서별 사원수</h1>
	<div>
		<a href="${pageContext.request.contextPath}/index" class="btn btn-success">홈으로</a>
	</div>
	<table class="table">
		<thead class="table-secondary">
			<tr>
				<th>부서 번호</th>
				<th>부서 이름</th>
				<th>부서 인원</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="map" items="${list}">
				<tr>
					<td>${map.deptNo }</td>
					<td>${map.deptName }</td>
					<td>${map.count }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>