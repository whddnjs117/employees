<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<style>
	.pagination{text-align: center;
				padding: 50px 0;
				}
	.page-link{display: inline-block;}
</style>
</head>
<body class="container">
<h1>회원 목록(10명씩 페이지)</h1>
	<div>
		<a href="${pageContext.request.contextPath}/index" class="btn btn-success">홈으로</a>
	</div>
	<form method="get" action="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage}">
		<select name="rowPerPage">
			<option value="10">10개씩</option>
			<option value="20">20개씩</option>
			<option value="30">30개씩</option>
			<option value="40">40개씩</option>
			<option value="50">50개씩</option>
		</select>
		<button type="submit" class="btn btn-success">확인</button>
	</form>
	<!-- 출력할것만 하는 테이블 -->
	<table class="table">
		<thead class="table-secondary">
			<tr>
				<th>사원 번호</th>
				<th>사원 생일</th>
				<th>사원 이름</th>
				<th>사원 성</th>
				<th>사원 성별</th>
				<th>입사 날짜</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="employees" items="${list}">
				<tr>
					<td>${employees.empNo}</td>
					<td>${employees.birthDate}</td>
					<td>${employees.lastName}</td>
					<td>${employees.firstName}</td>
					<td>${employees.gender}</td>
					<td>${employees.hireDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<ul class="pagination" style="text-align: center">
		<c:if test="${currentPage >100 }">
			<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage-100}&rowPerPage=${rowPerPage}" class="page-link">100개씩 넘기기</a>
		</c:if>
		<c:if test="${currentPage >1 }">
			<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}" class="page-link">이전</a>
		</c:if>
		
		<c:forEach var="i" begin="${currentPage}" end="${currentPage+9}" step="1">
			<c:if test="${currentPage >5}">
				<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${i-5}&rowPerPage=${rowPerPage}" class="page-link">${i-5}</a>
			</c:if>
		</c:forEach>
		<c:forEach var="i" begin="1" end="10" step="1">
			<c:if test="${currentPage <=5}">
				<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${i}&rowPerPage=${rowPerPage}" class="page-link">${i}</a>
			</c:if>
		</c:forEach>
		
		<c:if test="${currentPage <lastPage }">
			<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}" class="page-link">다음</a>
		</c:if>
		<c:if test="${currentPage <lastPage }">
			<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage+100}&rowPerPage=${rowPerPage}" class="page-link">100개씩 넘기기</a>
		</c:if>
	</ul>
</body>
</html>